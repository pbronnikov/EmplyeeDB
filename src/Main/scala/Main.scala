/**
 * Created with IntelliJ IDEA.
 * User: pbronnikov
 * Date: 02.04.13
 * Time: 17:40
 * To change this template use File | Settings | File Templates.
 */
package Main

import Interfaces.DataLayerInterface
import DAL.DataLayer
import BL.EmployeeLogic
import ServiceLayer.Service


object main {
  def main(args: Array[String]) = {
    val dataLayerInstance: DataLayerInterface = new DataLayer()
    val employeeLogicInstance: EmployeeLogic = new EmployeeLogic(dataLayerInstance)
    val service = new Service(employeeLogicInstance)
    service.run
  }
}
