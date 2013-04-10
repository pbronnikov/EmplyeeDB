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
object Service {
  def run {
    Http(AppSettings.port, AppSettings.host).filter(Planify({
      case req@POST(Path("/create")) =>
        ResponseString(RequestHandler.create(Body.string(req)))
      case req@POST(Path("/edit")) =>
        ResponseString(RequestHandler.edit(Body.string(req)))
      //case req @ POST(Path("/archive")) =>
      //  ResponseString(RequestHandler.archive(Body.string(req)))
      case req@GET(Path("/getAll")) =>
        ResponseString(RequestHandler.getAll)
      case req@POST(Path("/getByID")) =>
        ResponseString(RequestHandler.getByID(Body.string(req)))
      case req@POST(Path("/search")) =>
        ResponseString(RequestHandler.search(Body.string(req)))
      case req@POST(Path(Seg("addDayOff" :: id :: Nil))) =>
        ResponseString(RequestHandler.addDayOff(Body.string(req), id))
      case req@POST(Path(Seg("editDayOff" :: id :: Nil))) =>
        ResponseString(RequestHandler.editDayOff(Body.string(req), id))
      case req@POST(Path(Seg("deleteDayOff" :: id :: Nil))) =>
        ResponseString(RequestHandler.deleteDayOff(Body.string(req), id))
      case _ =>
        ResponseString("Error. Wrong path")
    })).run
  }
}
