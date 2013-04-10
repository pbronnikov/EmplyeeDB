import DAL.DBConnectionFactory
import java.sql.Timestamp
import tools.nsc.util.JavaCharArrayReader

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */

import scalaz._
import Scalaz._


class DataLayer extends DataLayerInterface {

  def edit(employee: Employee) {
    employee.id match {
      case 0 => createEmployee(employee)
      case _ => updateEmployee(employee)
    }
  }

  private def createEmployee(employee: Employee) {
    DBConnectionFactory.GetQueryEvaluator().insert("INSERT INTO Employee SET firstName=?, middleName=?, LastName=?, " +
      "skype=?, tel=?, email=?, lastUpdateDate=?, isArchived=?", employee.firstName, employee.middleName, employee.lastName, employee.skype,
    employee.tel, employee.email, employee.lastUpdateDate, employee.isArchived)
  }

  private def updateEmployee(employee: Employee) {
    DBConnectionFactory.GetQueryEvaluator().insert("UPDATE Employee SET firstName=?, middleName=?, LastName=?, " +
      "skype=?, tel=?, email=? lastUpdateDate=?, isArchived=? WHERE id=?", employee.firstName, employee.middleName, employee.lastName, employee.skype,
      employee.tel, employee.email, employee.lastUpdateDate, employee.isArchived, employee.id)
  }

  def getAll: Seq[Employee] = {
    DBConnectionFactory.GetQueryEvaluator.select("SELECT * FROM Employee") {
      ToEmployee
    }
  }

  def ToEmployee(row: java.sql.ResultSet): Employee = {
    new Employee(row.getInt("id"),
      row.getString("firstName"),
      row.getString("middleName"),
      row.getString("LastName"),
      row.getString("skype"),
      row.getString("tel"),
      row.getString("email"),
      new java.util.Date(row.getTimestamp("lastUpdateDate").getTime),
      row.getBoolean("lastUpdateDate"),
      Nil, Nil)
  }

  def getByID(id: Int): Option[Employee] = {
    DBConnectionFactory.GetQueryEvaluator.selectOne("SELECT * FROM Employee where id=?", id) {
      ToEmployee
    }
  }

  def search(criteria: String): Seq[Employee] = {
    val wildCardCriteria = "%" + criteria + "%"
    DBConnectionFactory.GetQueryEvaluator().select("SELECT * FROM Employee WHERE firstName LIKE ? " +
      "OR middleName LIKE ? OR LastName LIKE ? OR skype LIKE ? OR tel LIKE ? OR email LIKE ? OR id LIKE ?",
      wildCardCriteria, wildCardCriteria, wildCardCriteria, wildCardCriteria,
      wildCardCriteria, wildCardCriteria, wildCardCriteria) {
      ToEmployee
    }
  }

  def editDayOff(dayOff: DayOff, employeeID: Int) {
    dayOff.id match {
      case 0 => createDayOff(dayOff, employeeID)
      case _ => updateDayOff(dayOff)
    }
  }

  private def createDayOff(dayOff: DayOff, employeeID: Int) {
    DBConnectionFactory.GetQueryEvaluator().insert("INSERT INTO dayoff (`employee_id`,`from`,`to`,`Description`," +
      "`DayOffType`) Values (?, ?, ?, ?, ?)", employeeID,
      new Timestamp(dayOff.from.getTime()), new Timestamp(dayOff.to.getTime()), dayOff.description, 1)
  }

  private def updateDayOff(dayOff: DayOff) {
    DBConnectionFactory.GetQueryEvaluator().execute("UPDATE dayoff SET from=?, to=?, Description=?, DayOffType=? WHERE id=?",
      new java.sql.Date(dayOff.from.getTime), new java.sql.Date(dayOff.to.getTime), dayOff.description, dayOff.dayOffType)
  }

  def deleteDayOff(dayOff: DayOff) {
    DBConnectionFactory.GetQueryEvaluator().execute("DELETE FROM dayoff WHERE id=?", dayOff.id)
  }
}
