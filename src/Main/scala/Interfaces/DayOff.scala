/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */

import java.util.Date

case class DayOff(val id: Int,
                  val from: Date,
                  val to: Date,
                  val description: String,
                  val dayOffType: String)

object DayOff {
  val TYPE_VACATION = "Vacation"
  val TYPE_EXCEPTIONAL = "Exceptional"
}

