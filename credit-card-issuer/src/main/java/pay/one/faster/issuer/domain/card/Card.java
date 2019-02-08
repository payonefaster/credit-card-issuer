package pay.one.faster.issuer.domain.card;

import java.math.BigDecimal;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class Card {

  private String number;

  private String holder;

  private String validUntil;

  private String cvv;

  private Funds funds;

  private DueDate dueDate;

  public BigDecimal funds(){
    return this.funds.getValue();
  }

}
