package pay.one.faster.issuer.domain.card.repository;

import java.time.LocalDate;
import pay.one.faster.issuer.domain.card.CardTransactions;
import pay.one.faster.issuer.domain.card.Transaction;
import pay.one.faster.issuer.domain.card.data.TransactionRequest;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public interface TransactionRepository {

  CardTransactions balance(String cardNumber,LocalDate date);

  Transaction register(TransactionRequest request);

}
