package pay.one.faster.issuer.domain.card;

import java.math.BigDecimal;
import java.util.Set;

/** @author claudioed on 2019-02-07. Project credit-card-issuer */
public class CardTransactions {

  private final Set<Transaction> transactions;

  public CardTransactions(Set<Transaction> transactions) {
    this.transactions = transactions;
  }

  public Balance balance() {
    return new Balance(
        this.transactions.stream()
            .map(Transaction::operation)
            .reduce(BigDecimal.ZERO, BigDecimal::add));
  }
}
