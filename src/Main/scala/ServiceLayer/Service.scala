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
