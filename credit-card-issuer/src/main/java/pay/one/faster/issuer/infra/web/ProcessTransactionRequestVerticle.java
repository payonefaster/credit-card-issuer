package pay.one.faster.issuer.infra.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import pay.one.faster.issuer.domain.card.Transaction;
import pay.one.faster.issuer.domain.card.data.TransactionRequest;
import pay.one.faster.issuer.domain.card.service.TransactionService;

/**
 * @author claudioed on 2019-02-23.
 * Project credit-card-issuer
 */
public class ProcessTransactionRequestVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(ProcessTransactionRequestVerticle.class);

  private final TransactionService transactionService;

  public ProcessTransactionRequestVerticle(TransactionService transactionService) {
    this.transactionService = transactionService;
  }

  @Override
  public void start() {

    this.vertx.eventBus().consumer("transaction.request",consumer ->{
      final TransactionRequest transactionRequest = Json
          .decodeValue(consumer.body().toString(), TransactionRequest.class);
      final Transaction transaction = this.transactionService.register(transactionRequest);
      consumer.reply(Json.encode(transaction));
    });
  }

}
