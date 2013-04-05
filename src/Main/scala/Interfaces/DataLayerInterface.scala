/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 15:55
 * To change this template use File | Settings | File Templates.
 */
trait DataLayerInterface
{
    def edit(employee: Employee): Int
    def getAll : Seq[Employee]
    def getByID(id: Int): Employee
    def search(criteria: String): List[Employee]
    def editDayOff(dayOff: DayOff, employeeID: Int)
    def deleteDayOff(dayOff: DayOff, employeeID: Int)
}
