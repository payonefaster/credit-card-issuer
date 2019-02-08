package pay.one.faster.issuer.domain.card;

import java.math.BigDecimal;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class Balance {

  private final BigDecimal value;

  public Balance(BigDecimal value) {
    this.value = value;
  }

  public BigDecimal getValue() {
    return value;
  }

}
