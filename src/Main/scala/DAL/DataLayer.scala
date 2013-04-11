import DAL.DBConnectionFactory
import java.sql.Timestamp
import scalaz.{Failure, Success, Validation}

/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 16:30
 * To change this template use File | Settings | File Templates.
 */


class DataLayer extends DataLayerInterface {

  def edit(employee: Employee): Validation[Exception, Unit] = {
    try {
      Success(
        employee.id match {
          case 0 => createEmployee(employee)
          case _ => updateEmployee(employee)
        }
      )
    } catch {
      case e: Exception => Failure(e)
    }
  }

  private def createEmployee(employee: Employee): Validation[Exception, Unit] = {
    try {
      Success(DBConnectionFactory.GetQueryEvaluator().insert("INSERT INTO Employee SET firstName=?, middleName=?, LastName=?, " +
        "skype=?, tel=?, email=?, lastUpdateDate=?, isArchived=?", employee.firstName, employee.middleName, employee.lastName, employee.skype,
        employee.tel, employee.email, employee.lastUpdateDate, employee.isArchived))
    } catch {
      case e: Exception => Failure(e)
    }

  }

  private def updateEmployee(employee: Employee) {
    DBConnectionFactory.GetQueryEvaluator().insert("UPDATE Employee SET firstName=?, middleName=?, LastName=?, " +
      "skype=?, tel=?, email=? lastUpdateDate=?, isArchived=? WHERE id=?", employee.firstName, employee.middleName, employee.lastName, employee.skype,
      employee.tel, employee.email, employee.lastUpdateDate, employee.isArchived, employee.id)
  }

  def getAll: Validation[Exception, Seq[Employee]] = {
    try {
      Success(DBConnectionFactory.GetQueryEvaluator.select("SELECT * FROM Employee") {
        ToEmployee
      })
    } catch {
      case e: Exception => Failure(e)
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

  def getByID(id: Int): Validation[Exception, Option[Employee]] = {
    try {
      Success(
        DBConnectionFactory.GetQueryEvaluator.selectOne("SELECT * FROM Employee where id=?", id) {
          ToEmployee
        }
      )
    } catch {
      case e: Exception => Failure(e)
    }
  }

  def search(criteria: String): Validation[Exception, Seq[Employee]] = {
    val wildCardCriteria = "%" + criteria + "%"

    try {
      Success(
        DBConnectionFactory.GetQueryEvaluator().select("SELECT * FROM Employee WHERE firstName LIKE ? " +
          "OR middleName LIKE ? OR LastName LIKE ? OR skype LIKE ? OR tel LIKE ? OR email LIKE ? OR id LIKE ?",
          wildCardCriteria, wildCardCriteria, wildCardCriteria, wildCardCriteria,
          wildCardCriteria, wildCardCriteria, wildCardCriteria) {
          ToEmployee
        }
      )
    } catch {
      case e: Exception => Failure(e)
    }

  }

  def editDayOff(dayOff: DayOff, employeeID: Int): Validation[Exception, Unit] = {
    try {
      Success(
        dayOff.id match {
          case 0 => createDayOff(dayOff, employeeID)
          case _ => updateDayOff(dayOff)
        }
      )
    } catch {
      case e: Exception => Failure(e)
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

  def deleteDayOff(dayOff: DayOff): Validation[Exception, Unit] = {
    try {
      Success(
        DBConnectionFactory.GetQueryEvaluator().execute("DELETE FROM dayoff WHERE id=?", dayOff.id)
      )
    } catch {
      case e: Exception => Failure(e)
    }

  }
}
