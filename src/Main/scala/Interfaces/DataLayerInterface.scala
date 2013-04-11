import scalaz.Validation

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
trait DataLayerInterface {
  def edit(employee: Employee): Validation[Exception, Unit]

  def getAll: Validation[Exception, Seq[Employee]]

  def getByID(id: Int): Validation[Exception, Option[Employee]]

  def search(criteria: String): Validation[Exception, Seq[Employee]]

  def editDayOff(dayOff: DayOff, employeeID: Int): Validation[Exception, Unit]

  def deleteDayOff(dayOff: DayOff): Validation[Exception, Unit]
}
