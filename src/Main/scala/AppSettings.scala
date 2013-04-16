/**
 * Created with IntelliJ IDEA.
 * User: ISolo
 * Date: 10.04.13
 * Time: 12:09
 */
package Main

import com.typesafe.config._

object AppSettings {
  private val conf = ConfigFactory.load()

  val db_host = AppSettings.conf.getString("settings.db_host")
  val db_database = AppSettings.conf.getString("settings.db_database")
  val db_user = AppSettings.conf.getString("settings.db_user")
  val db_password = AppSettings.conf.getString("settings.db_password")

  val host = AppSettings.conf.getString("settings.host")
  val port = AppSettings.conf.getInt("settings.port")

}
