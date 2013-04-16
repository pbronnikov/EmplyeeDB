package ServiceLayer

import Interfaces.{Employee, ProjectHistoryEntry, DayOff}

/**
 * Created with IntelliJ IDEA.
 * User: ISolo
 * Date: 16.04.13
 * Time: 13:41
 */
case class EmplDTOInput(id: Int,
                           firstName: String,
                           middleName: String,
                           lastName: String,

                           skype: String,
                           tel: String,
                           email: String,

                           var dayOffs: List[DayOff],
                           var projectHistory: List[ProjectHistoryEntry]) {
  def apply() = Employee(id, firstName, middleName, lastName, skype, tel, email, lastUpdateDate = new java.util.Date(), isArchived = false, dayOffs, projectHistory)
}

