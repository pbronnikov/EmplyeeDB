/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 10.04.13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
class EmployeeLogic(val dataObject: DataLayerInterface) {

  def create(employee: Employee){
    dataObject.edit(employee);
  }

  def edit(employee: Employee){
    dataObject.edit(employee);
  }

  def archive(id: Int){
    val emp = dataObject.getByID(id)
    if (emp.isEmpty)
      return;

    //val arcEmp = emp.get.copy(isArchieve = true)
    val arcEmp = emp.get.copy(firstName = "Pavel")

    dataObject.edit(arcEmp);
  }

  def getAll: Seq[Employee] = {
    dataObject.getAll
  }

  def getByID(id: Int): Option[Employee] = {
    dataObject.getByID(id)
  }

  def search(criteria: String): Seq[Employee] = {
    dataObject.search(criteria)
  }

  def addDayOff(dayOff: DayOff, employeeID: Int) = {
    dataObject.editDayOff(dayOff, employeeID);
  }

  def editDayOff(dayOff: DayOff, employeeID: Int) = {
    dataObject.editDayOff(dayOff, employeeID);
  }

  def deleteDayOff(dayOff: DayOff) = {
    dataObject.deleteDayOff(dayOff);
  }
}
