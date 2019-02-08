package pay.one.faster.issuer.domain.card.service;

import pay.one.faster.issuer.domain.card.Card;
import pay.one.faster.issuer.domain.card.CardTransactions;
import pay.one.faster.issuer.domain.card.Transaction;
import pay.one.faster.issuer.domain.card.data.TransactionRequest;
import pay.one.faster.issuer.domain.card.repository.CardRepository;
import pay.one.faster.issuer.domain.card.repository.TransactionRepository;
import pay.one.faster.issuer.exception.InsufficientFunds;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class TransactionServiceImpl implements TransactionService {

  private final TransactionRepository transactionRepository;

  private final CardRepository cardRepository;

  public TransactionServiceImpl(TransactionRepository transactionRepository,
      CardRepository cardRepository) {
    this.transactionRepository = transactionRepository;
    this.cardRepository = cardRepository;
  }

  public Transaction register(TransactionRequest request) {
    final CardTransactions cardTransactions = this.transactionRepository.balance(request.getCardNumber(), request.getAt().toLocalDate());
    final Card card = this.cardRepository.card(request.getCardNumber());
    if (card.funds().compareTo(cardTransactions.balance().getValue()) > 0){
      return this.transactionRepository.register(request);
    }else{
      throw  new InsufficientFunds();
    }
  }

}
