import DAL.DBConnectionFactory

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */

import scalaz._
import Scalaz._


class DataLayer extends DataLayerInterface{

  def edit(employee: Employee): Int = 0

  def getAll: Seq[Employee] =
  {
    return DBConnectionFactory.GetQueryEvaluator.select("SELECT * FROM Employee") { ToEmployee }
  }

  def ToEmployee(row: java.sql.ResultSet) : Employee =
  {
    new Employee(row.getInt("id"),
      row.getString("firstName"),
      row.getString("middleName"),
      row.getString("LastName"),
      row.getString("skype"),
      row.getString("tel"),
      row.getString("email"));
  }

  def getByID(id: Int): Employee =
  {
    return (DBConnectionFactory.GetQueryEvaluator.select("SELECT * FROM Employee where id=?", id) { ToEmployee }).head
  }

  def search(criteria: String): List[Employee] = null

  def editDayOff(dayOff: DayOff, employeeID: Int) {}

  def deleteDayOff(dayOff: DayOff, employeeID: Int) {}
}
