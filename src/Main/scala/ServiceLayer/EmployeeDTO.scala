package ServiceLayer


/**
 * Created with IntelliJ IDEA.
 * User: ISolo
 * Date: 16.04.13
 * Time: 10:25
 */

import Interfaces.{ProjectHistoryEntry, DayOff, Employee}

case class EmployeeDTO(id: Int,
                       firstName: String,
                       middleName: String,
                       lastName: String,

                       skype: String,
                       tel: String,
                       email: String,

                       var dayOffs: List[DayOff],
                       var projectHistory: List[ProjectHistoryEntry]) {
  def apply() = new Employee(id, firstName, middleName, lastName, skype, tel, email, lastUpdateDate = new java.util.Date(), isArchived = false, dayOffs, projectHistory)
}

