package pay.one.faster.issuer.domain.card;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class Transaction {

  private String id;

  private LocalDateTime at;

  private BigDecimal value;

  private Operation type;

  private String cardNumber;

  public BigDecimal operation(){
    return Operation.CREDIT.equals(this.type) ? value : value.negate();
  }

}
