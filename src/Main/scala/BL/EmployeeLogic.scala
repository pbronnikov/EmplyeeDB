import scalaz.{Failure, Success, Validation}

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 10.04.13
 * Time: 15:35
 * To change this template use File | Settings | File Templates.
 */
class EmployeeLogic(val dataObject: DataLayerInterface) {

  def create(employee: Employee): Validation[Exception, Unit] = {
    dataObject.edit(employee)
  }

  def edit(employee: Employee): Validation[Exception, Unit] = {
    dataObject.edit(employee)
  }

  def archive(id: Int): Validation[Exception, Unit] = {
    val emp = dataObject.getByID(id)

    emp match {
      case Success(s) => {
        if (s.isEmpty)
          return Success()

        val arcEmp = s.get.copy(isArchived = true)
        return dataObject.edit(arcEmp)
      }

      case Failure(f) => {
        return Failure(f)
      }
    }
  }

  def getAll: Validation[Exception, Seq[Employee]] = {
    dataObject.getAll
  }

  def getByID(id: Int): Validation[Exception, Option[Employee]] = {
    dataObject.getByID(id)
  }

  def search(criteria: String): Validation[Exception, Seq[Employee]] = {
    dataObject.search(criteria)
  }

  def addDayOff(dayOff: DayOff, employeeID: Int): Validation[Exception, Unit] = {
    dataObject.editDayOff(dayOff, employeeID)
  }

  def editDayOff(dayOff: DayOff, employeeID: Int): Validation[Exception, Unit] = {
    dataObject.editDayOff(dayOff, employeeID)
  }

  def deleteDayOff(dayOff: DayOff): Validation[Exception, Unit] = {
    dataObject.deleteDayOff(dayOff)
  }

}