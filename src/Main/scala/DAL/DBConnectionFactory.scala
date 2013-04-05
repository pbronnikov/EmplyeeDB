package DAL

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 17:21
 * To change this template use File | Settings | File Templates.
 */

import com.twitter.querulous.evaluator._
import com.twitter.querulous.query._
import com.twitter.querulous.database._
import com.twitter.util.Duration


object DBConnectionFactory {
  val queryFactory = new SqlQueryFactory
  val apachePoolingDatabaseFactory = new ApachePoolingDatabaseFactory(
    1,      // minimum number of open/active connections at all times
    10,      // minimum number of open/active connections at all times
    com.twitter.util.Duration(10,java.util.concurrent.TimeUnit.SECONDS), // asynchronously check the health of open connections every `checkConnectionHealthWhenIdleFor` amount of time
    com.twitter.util.Duration(10,java.util.concurrent.TimeUnit.SECONDS), // maximum amount of time you're willing to wait to reserve a connection from the pool; throw an exception otherwise
    true,  // check connection health when reserving the connection from the pool
    com.twitter.util.Duration(10,java.util.concurrent.TimeUnit.SECONDS)  // destroy connections if they are idle for longer than `evictConnectionIfIdleFor` amount of time
  )
  val queryEvaluatorFactory = new StandardQueryEvaluatorFactory(apachePoolingDatabaseFactory, queryFactory)

  val queryEvaluator = QueryEvaluator("localhost", "root", "toor")
}
