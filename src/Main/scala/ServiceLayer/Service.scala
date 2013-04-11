import unfiltered.jetty._
import unfiltered.filter._
import unfiltered.request._
import unfiltered.response._

/**
 * Created with IntelliJ IDEA.
 * User: spl
 * Date: 07.04.13
 * Time: 20:26
 * To change this template use File | Settings | File Templates.
 */
class Service(logicInstance: EmployeeLogic) {
  val requestHandlerInstance = new RequestHandler(logicInstance)
  def run {
    Http(AppSettings.port, AppSettings.host).filter(Planify({
      case req@POST(Path("/create")) =>
        ResponseString(requestHandlerInstance.create(Body.string(req)))
      case req@POST(Path("/edit")) =>
        ResponseString(requestHandlerInstance.edit(Body.string(req)))
      case req @ POST(Path("/archive")) =>
        ResponseString(requestHandlerInstance.archive(Body.string(req)))
      case req@GET(Path("/getAll")) =>
        ResponseString(requestHandlerInstance.getAll)
      case req@POST(Path("/getByID")) =>
        ResponseString(requestHandlerInstance.getByID(Body.string(req)))
      case req@POST(Path("/search")) =>
        ResponseString(requestHandlerInstance.search(Body.string(req)))
      case req@POST(Path(Seg("addDayOff" :: id :: Nil))) =>
        ResponseString(requestHandlerInstance.addDayOff(Body.string(req), id))
      case req@POST(Path(Seg("editDayOff" :: id :: Nil))) =>
        ResponseString(requestHandlerInstance.editDayOff(Body.string(req), id))
      case req@POST(Path(Seg("deleteDayOff" :: id :: Nil))) =>
        ResponseString(requestHandlerInstance.deleteDayOff(Body.string(req), id))
      case _ =>
        ResponseString("Error. Wrong path")
    })).run
  }
}
