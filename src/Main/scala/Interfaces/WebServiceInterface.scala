/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 14:57
 * To change this template use File | Settings | File Templates.
 */
trait WebServiceInterface {
  def create(employee: Employee): Int
  def edit(employee: Employee): Int
  def archive(id: Int): Int
  def getAll : List[Employee]
  def getByID(id: Int): Employee
  def search(criteria: String): List[Employee]
  def addDayOff(dayOff: DayOff, employeeID: Int)
  def editDayOff(dayOff: DayOff, employeeID: Int)
  def deleteDayOff(dayOff: DayOff, employeeID: Int)
}
