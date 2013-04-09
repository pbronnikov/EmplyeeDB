/**
 * Created with IntelliJ IDEA.
 * User: vitaliy
 * Date: 09.04.13
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */
import unfiltered.jetty._
import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import java.util.Date
import net.liftweb.json._
import net.liftweb.json.Serialization._
import net.liftweb.json.JsonDSL._

object RequestHandler {
  implicit val formats = Serialization.formats(NoTypeHints)
  val dataLayerInstance: DataLayerInterface = new DataLayer

  def create(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None) {
      dataLayerInstance.edit(e)
      "Employee created"
    } else
      "Error parsing Employee"
  }
  def edit(requestBody: String): String = {
    val e: Employee = read[Employee](requestBody)
    if (e != None) {
      dataLayerInstance.edit(e)
      "Employee edited"
    } else
      "Error parsing Employee"
  }
  /*
  def archive(requestBody: String): String = {
    if (requestBody.contains(Int)) {
      val id: Int = Integer.parseInt(requestBody)
      dataLayerInstance.archive(id)
    }
    "id " + id + " archived"
  }
  */
  def getAll: String = {
    val employeeList: Seq[Employee] = dataLayerInstance.getAll
    if (employeeList != None) {
      write(employeeList)
    } else
      "List is empty"
  }

  //requestBody.forall(_.isDigit)
  def getByID(requestBody: String): String = {
    var s: String = ""
    if (requestBody.forall(_.isDigit)) {
      val id: Int = Integer.parseInt(requestBody)
      val employee = dataLayerInstance.getByID(id)
      if (employee != None)
        write(employee)
      else
        s = "No such employee"
    } else
      s = "Body is not a number"
    s
  }
  def search(criteria: String): String = {
    val employeeList: Seq[Employee] = dataLayerInstance.search(criteria)
    if (employeeList != None) {
      write(employeeList)
    } else
      "List is empty"
  }

}