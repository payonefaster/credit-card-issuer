package pay.one.faster.issuer.domain.card.service;

import pay.one.faster.issuer.domain.card.Transaction;
import pay.one.faster.issuer.domain.card.data.TransactionRequest;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public interface TransactionService {

  Transaction register(TransactionRequest request);

}
