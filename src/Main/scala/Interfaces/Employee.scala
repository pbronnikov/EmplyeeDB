/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
package Interfaces

import java.util.Date
import ServiceLayer.{EmplDTOOutput, EmplDTOInput}

case class Employee(id: Int,
                    firstName: String,
                    middleName: String,
                    lastName: String,

                    skype: String,
                    tel: String,
                    email: String,

                    lastUpdateDate: Date,
                    isArchived: Boolean,

                    var dayOffs: List[DayOff],
                    var projectHistory: List[ProjectHistoryEntry]) {

  def apply() = {
    EmplDTOOutput(id, firstName, middleName, lastName, skype, tel, email, lastUpdateDate, isArchived, dayOffs, projectHistory)
  }
}
