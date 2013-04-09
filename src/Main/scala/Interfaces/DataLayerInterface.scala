/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
trait DataLayerInterface
{
    def edit(employee: Employee)
    def getAll : Seq[Employee]
    def getByID(id: Int): Option[Employee]
    def search(criteria: String): Seq[Employee]
    def editDayOff(dayOff: DayOff, employeeID: Int)
    def deleteDayOff(dayOff: DayOff)
}
