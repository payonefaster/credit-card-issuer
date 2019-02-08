package pay.one.faster.issuer.domain.card.repository;

import pay.one.faster.issuer.domain.card.Card;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public interface CardRepository {

  Card card(String cardNumber);

}
