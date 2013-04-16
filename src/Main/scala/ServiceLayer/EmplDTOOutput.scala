package ServiceLayer


/**
 * Created with IntelliJ IDEA.
 * User: ISolo
 * Date: 16.04.13
 * Time: 10:25
 */

import Interfaces.{ProjectHistoryEntry, DayOff, Employee}
import java.util.Date

case class EmplDTOOutput(id: Int,
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
  def apply() = Employee(id, firstName, middleName, lastName, skype, tel, email, lastUpdateDate, isArchived , dayOffs, projectHistory)

}

