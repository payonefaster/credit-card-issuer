package pay.one.faster.issuer.domain.card.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import pay.one.faster.issuer.domain.card.Operation;
import pay.one.faster.issuer.infra.crypto.Hashing;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class TransactionId {

  private final String cardNumber;

  private final BigDecimal value;

  private final LocalDateTime at;

  private final Operation type;

  public TransactionId(String cardNumber, BigDecimal value, LocalDateTime at,
      Operation type) {
    this.cardNumber = cardNumber;
    this.value = value;
    this.at = at;
    this.type = type;
  }

  public String id(){
    return Hashing.hash(this.cardNumber + this.value + this.type + this.at.toString());
  }

}
