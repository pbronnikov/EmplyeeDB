
/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */

class DataLayer extends DataLayerInterface{

  def edit(employee: Employee): Int = 0

  def getAll: List[Employee] = null

  def getByID(id: Int): Employee = null

  def search(criteria: String): List[Employee] = null

  def editDayOff(dayOff: DayOff, employeeID: Int) {}

  def deleteDayOff(dayOff: DayOff, employeeID: Int) {}
}
