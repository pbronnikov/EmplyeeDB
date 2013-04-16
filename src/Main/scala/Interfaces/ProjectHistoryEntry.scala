/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:28
 * To change this template use File | Settings | File Templates.
 */
package Interfaces

import java.util.Date

case class ProjectHistoryEntry(val from: Date,
                               val to: Date,
                               val projectName: String,
                               val role: String)

object ProjectHistoryEntry {
  val ROLE_PM = "PM"
  val ROLE_MEMBER = "Member"
}

