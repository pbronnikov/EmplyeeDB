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
  private var port: Int = 1234
  /*
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
    def toString: String = {
      var s1: String = ""
      for(t <- dayOffs)
        s1 = "id: " + t.id + "\nfrom: " + t.from + "\nto: " + t.to + "\ndescription: " + t.description +
          "\ntype: " + t.dayOffType

      var s2: String = ""
      for(t <- projectHistory)
        s2 = "from: " + t.from + "\nto: " + t.to + "\nprojname: " + t.projectName + "\nrole: " + t.role

      "id: " + id + "\nfirstname: " + firstName + "\nmiddlename: " + middleName + "\nlastname: " + lastName +
        "\nskype: " + skype + "\ntel: " + tel + "\nemail: " + email + "\n" + s1 + "\n" + s2
    }
  }

  var emp = Employee(11, "Josh", "", "Porrigeman", "skypeaccount", "cellphonenumber", "ubermail@sickestperson.com",
    List(DayOff(1, new Date(), new Date(), "dayoffnumberone", DayOff.TYPE_VACATION),
      DayOff(2, new Date(), new Date(), "dayoffnumbertwo", DayOff.TYPE_EXCEPTIONAL)),
    List(ProjectHistoryEntry(new Date(), new Date(), "NEBULA", ProjectHistoryEntry.ROLE_MEMBER),
      ProjectHistoryEntry(new Date(), new Date(), "KELVIN", ProjectHistoryEntry.ROLE_PM)))

  def check {
    val js: String = write(emp)
    println("EMPLOYEE COMPARISON: " + (read[Employee](js) == emp))
  }
  */
  def run {
    Http(port).filter(Planify({
      case req @ POST(Path("/create")) =>
        ResponseString(RequestHandler.create(Body.string(req)))
      case req @ POST(Path("/edit")) =>
        ResponseString(RequestHandler.edit(Body.string(req)))
      //case req @ POST(Path("/archive")) =>
      //  ResponseString(RequestHandler.archive(Body.string(req)))
      case req @ GET(Path("/getAll")) =>
        ResponseString(RequestHandler.getAll)
      case req @ POST(Path("/getByID")) =>
        ResponseString(RequestHandler.getByID(Body.string(req)))
      case req @ POST(Path("/search")) =>
        ResponseString(RequestHandler.search(Body.string(req)))
      case _ =>
        ResponseString("Error. Wrong path")
    })).run
  }

   def run(port: Int) {
     this.port = port
     run
   }
}
