import unfiltered.jetty._
import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._
import java.util.Date
import net.liftweb.json._
import net.liftweb.json.Serialization._
import net.liftweb.json.JsonDSL._

/**
 * Created with IntelliJ IDEA.
 * User: spl
 * Date: 07.04.13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
object Service {
  implicit val formats = Serialization.formats(NoTypeHints)

  case class Employee (
                        val id: Int,
                        val firstName: String,
                        val middleName: String,
                        val lastName: String,

                        val skype: String,
                        val tel: String,
                        val email: String,
                        var dayOffs: List[DayOff],
                        var projectHistory: List[ProjectHistoryEntry] ) {
    def printSelf: Unit = {
      println("\n\nid: " + id)
      println("firstname: " + firstName)
      println("middlename: " + middleName)
      println("lastname: " + lastName)
      println("skype: " + skype)
      println("tel: " + tel)
      println("email: " + email)
      for(t <- dayOffs) {
        println("id: " + t.id)
        println("from: " + t.from)
        println("to: " + t.to)
        println("description: " + t.description)
        println("type: " + t.dayOffType)
      }
      for(t <- projectHistory) {
        println("from: " + t.from)
        println("to: " + t.to)
        println("projname: " + t.projectName)
        println("role: " + t.role)
      }
    }
  }

  var emp = Employee(11, "Josh", "", "Porrigeman", "skypeaccount", "cellphonenumber", "ubermail@sickestperson.com",
    List(DayOff(1, new Date(), new Date(), "dayoffnumberone", /*"Vacation"*/DayOffType.Vacation),
      DayOff(2, new Date(), new Date(), "dayoffnumbertwo", DayOffType.Exceptional/*"Exceptional"*/)),
    List(ProjectHistoryEntry(new Date(), new Date(), "NEBULA", /*"Member"*/ProjectRole.Member),
      ProjectHistoryEntry(new Date(), new Date(), "KELVIN", /*"PM"*/ProjectRole.PM)))

  def check {
    val js: String = write(emp)
    println("EMPLOYEE COMPARISON: " + (read[Employee](js) == emp))
  }
  def run {
    Http(1234).filter(Planify({
      case req @ GET(Path(Seg("employee" :: "id" :: num :: Nil))) =>
        //action
        ResponseString("employee id = " + Integer.parseInt(num))
      case req @ GET(Path(Seg("testemployee" :: Nil))) =>
        ResponseString(write(emp))
      case req @ POST(Path(Seg("employee" :: Nil))) =>
        println("BODY:\n" + Body.string(req) + "\nENDOFBODY")
        val newEmp = read[Employee](Body.string(req))
        ResponseString("received")
    })).run
  }
}
