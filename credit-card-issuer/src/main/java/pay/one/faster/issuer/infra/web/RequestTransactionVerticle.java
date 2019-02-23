package pay.one.faster.issuer.infra.web;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.eventbus.DeliveryOptions;
import io.vertx.core.http.HttpServer;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.handler.BodyHandler;

/**
 * @author claudioed on 2019-02-23.
 * Project credit-card-issuer
 */
public class RequestTransactionVerticle extends AbstractVerticle {

  private static final Logger LOGGER = LoggerFactory.getLogger(RequestTransactionVerticle.class);

  @Override
  public void start() {
    Router router = Router.router(vertx);
    router.route().handler(BodyHandler.create());
    router.post("/api/transaction").handler(handler ->{
      DeliveryOptions options = new DeliveryOptions();
      options.setHeaders(handler.request().headers());
      vertx.eventBus().send("transaction.request",handler.getBodyAsJson(),options, result ->{
        handler.response().end(result.result().body().toString());
      });
    });
    final HttpServer httpServer = vertx.createHttpServer();
    httpServer.requestHandler(router::accept).listen(8080);
  }

}