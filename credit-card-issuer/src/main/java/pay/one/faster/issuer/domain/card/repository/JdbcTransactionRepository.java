package pay.one.faster.issuer.domain.card.repository;

import io.vertx.ext.jdbc.JDBCClient;
import java.time.LocalDate;
import pay.one.faster.issuer.domain.card.CardTransactions;
import pay.one.faster.issuer.domain.card.Transaction;
import pay.one.faster.issuer.domain.card.data.TransactionRequest;

/**
 * @author claudioed on 2019-02-07.
 * Project credit-card-issuer
 */
public class JdbcTransactionRepository implements TransactionRepository{

  private final JDBCClient jdbcClient;

  public JdbcTransactionRepository(JDBCClient jdbcClient) {
    this.jdbcClient = jdbcClient;
  }

  @Override
  public CardTransactions balance(String cardNumber, LocalDate date) {
    return null;
  }

  @Override
  public Transaction register(TransactionRequest request) {
    return null;
  }


}
