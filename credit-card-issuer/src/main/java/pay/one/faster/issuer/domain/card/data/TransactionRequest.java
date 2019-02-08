package pay.one.faster.issuer.domain.card.data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import pay.one.faster.issuer.domain.card.Operation;

/** @author claudioed on 2019-02-07. Project credit-card-issuer */
public class TransactionRequest {

  private String cardNumber;

  private BigDecimal value;

  private LocalDateTime at;

  private Operation type;

  public String getCardNumber() {
    return cardNumber;
  }

  public BigDecimal getValue() {
    return value;
  }

  public LocalDateTime getAt() {
    return at;
  }

  public Operation getType() {
    return type;
  }

  public TransactionId id() {
    return new TransactionId(this.cardNumber, this.value, this.at, this.type);
  }
}
