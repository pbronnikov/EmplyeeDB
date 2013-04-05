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
import java.util.concurrent.TimeUnit


object DBConnectionFactory {
  private val host = "localhost"
  private val user = "root"
  private val password = "toor"

  private val queryFactory = new SqlQueryFactory
  private val apachePoolingDatabaseFactory = new ApachePoolingDatabaseFactory(
    1,      // minimum number of open/active connections at all times
    10,      // minimum number of open/active connections at all times
    Duration(10, TimeUnit.SECONDS), // asynchronously check the health of open connections every `checkConnectionHealthWhenIdleFor` amount of time
    Duration(10, TimeUnit.SECONDS), // maximum amount of time you're willing to wait to reserve a connection from the pool; throw an exception otherwise
    true,  // check connection health when reserving the connection from the pool
    Duration(10, TimeUnit.SECONDS)  // destroy connections if they are idle for longer than `evictConnectionIfIdleFor` amount of time
  )
  private val queryEvaluatorFactory = new StandardQueryEvaluatorFactory(apachePoolingDatabaseFactory, queryFactory)

  def GetQueryEvaluator() =  queryEvaluatorFactory(host, user, password)
}
