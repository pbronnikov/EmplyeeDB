/**
 * Created with IntelliJ IDEA.
 * User: vitaliy
 * Date: 09.04.13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
import net.liftweb.json._
import net.liftweb.json.Serialization._
import scalaz.{Failure, Success}

class RequestHandler(logicInstance: EmployeeLogic) {
  implicit val formats = Serialization.formats(NoTypeHints)

  def create(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None)
      logicInstance.create(e) match {
        case Success(_) => "Employee created"
        case Failure(f) => f.getMessage
      }
    else
      "Error parsing Employee"
  }

  def edit(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None)
      logicInstance.edit(e) match {
        case Success(_) => "Employee edit"
        case Failure(f) => f.getMessage
      }
    else
      "Error parsing Employee"
  }

  def archive(requestBody: String): String = {
    if (requestBody.forall(_.isDigit)) {
      val id: Int = Integer.parseInt(requestBody)
      logicInstance.archive(id) match {
        case Success(_) => "Employee " + id + " archived"
        case Failure(f) => f.getMessage
      }
    } else
      "Body is not a number"
  }

  def getAll: String = {
    logicInstance.getAll match {
      case Success(employeeList) => write(employeeList)
      case Failure(f) => f.getMessage
    }
  }

  def getByID(requestBody: String): String = {
    if (requestBody.forall(_.isDigit)) {
      val id: Int = Integer.parseInt(requestBody)
      logicInstance.getByID(id) match {
        case Success(employee) => write(employee)
        case Failure(f) => f.getMessage
      }
    } else
      "Body is not a number"
  }

  def search(criteria: String): String = {
    logicInstance.search(criteria) match {
      case Success(employeeList) => write(employeeList)
      case Failure(f) => f.getMessage
    }
  }

  def addDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit)) {
      if (d != None) {
        logicInstance.addDayOff(d, Integer.parseInt(id)) match {
          case Success(_) => "DayOff added"
          case Failure(f) => f.getMessage
        }
      } else
        "Can not parse DayOff"
    } else
      "Incorrect id"
  }

  def editDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit)) {
      if (d != None) {
        logicInstance.editDayOff(d, Integer.parseInt(id)) match {
          case Success(_) => "DayOff edited"
          case Failure(f) => f.getMessage
        }
      } else
        "Can not parse DayOff"
    } else
        "Incorrect id"
  }

  def deleteDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit)) {
      if (d != None) {
        logicInstance.deleteDayOff(d) match {
          case Success(_) => "DayOff deleted"
          case Failure(f) => f.getMessage
        }
      } else
        "Can not parse DayOff"
    } else
      "Incorrect id"
  }
}
