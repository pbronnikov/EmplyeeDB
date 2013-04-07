/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */

object main {
  def main(args: Array[String]) = {

    val dal = new DataLayer();
    val allEmployees = dal.getAll

    //allEmployees.foreach(i => println(i.lastName));

    val empl = dal.getByID(1)

    println(empl.firstName)

    Service.check
    Service.run
  }
}
