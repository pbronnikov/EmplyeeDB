/**
 * Created with IntelliJ IDEA.
 * User: ISolo
 * Date: 10.04.13
 * Time: 12:09
 */
import com.typesafe.config._

object AppSettings {
  private val conf = ConfigFactory.load()

  val db_host = AppSettings.conf.getString("settings.db_host")
  val db_port = AppSettings.conf.getInt("settings.db_port")
  val host    = AppSettings.conf.getString("settings.host")
  val port    = AppSettings.conf.getInt("settings.port")

}
