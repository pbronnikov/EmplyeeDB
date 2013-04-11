/**
 * Created with IntelliJ IDEA.
 * User: vitaliy
 * Date: 09.04.13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */

import net.liftweb.json._
import net.liftweb.json.Serialization._

class RequestHandler(logicInstance: EmployeeLogic) {
  implicit val formats = Serialization.formats(NoTypeHints)

  def create(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None) {
      logicInstance.create(e)
      "Employee created"
    } else
      "Error parsing Employee"
  }

  def edit(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None) {
      logicInstance.edit(e)
      "Employee edited"
    } else
      "Error parsing Employee"
  }

  def archive(requestBody: String): String = {
    if (requestBody.contains(Int)) {
      val id: Int = Integer.parseInt(requestBody)
      logicInstance.archive(id)
    }
    "Error: method not implemented"
  }

  def getAll: String = {
    val employeeList = logicInstance.getAll
    if (employeeList != None) {
      write(employeeList)
    } else
      "List is empty"
  }

  def getByID(requestBody: String): String = {
    if (requestBody.forall(_.isDigit)) {
      val id: Int = Integer.parseInt(requestBody)
      val employee = logicInstance.getByID(id)
      if (employee != None)
        write(employee)
      else
        "No such employee"
    } else
      "Body is not a number"
  }

  def search(criteria: String): String = {
    val employeeList = logicInstance.search(criteria)
    if (employeeList != None) {
      write(employeeList)
    } else
      "List is empty"
  }

  def addDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit))
      if (d != None) {
        logicInstance.addDayOff(d, Integer.parseInt(id))
        "DayOff added"
      } else
        "Incorrect dayOff message"
    else
      "Incorrect id"
  }

  def editDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit))
      if (d != None) {
        logicInstance.editDayOff(d, Integer.parseInt(id))
        "DayOff edited"
      } else
        "Incorrect dayOff message"
    else
      "Incorrect id"
  }

  def deleteDayOff(requestBody: String, id: String): String = {
    val d: DayOff = read[DayOff](requestBody)
    if (id.forall(_.isDigit))
      if (d != None) {
        logicInstance.deleteDayOff(d /*, Integer.parseInt(id)*/)
        "DayOff deleted"
      } else
        "Incorrect dayOff message"
    else
      "Incorrect id"
  }
}
