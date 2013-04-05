/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:15
 * To change this template use File | Settings | File Templates.
 */
class Employee (
  val id: Int,
  val firstName: String,
  val middleName: String,
  val lastName: String,

  val skype: String,
  val tel: String,
  val email: String)
{
   var dayOffs = List[DayOff]()
   var projectHistory = List[ProjectHistoryEntry]()
}

