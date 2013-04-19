/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:21
 * To change this template use File | Settings | File Templates.
 */
package Interfaces

import java.util.Date

case class DayOff(id: Int,
                  from: Date,
                  to: Date,
                  description: String,
                  dayOffType: String)

object DayOff {
  val TYPE_VACATION = "Vacation"
  val TYPE_EXCEPTIONAL = "Exceptional"
}

