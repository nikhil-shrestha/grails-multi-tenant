package multi.tenant

import grails.gorm.multitenancy.CurrentTenant
import grails.gorm.services.Join
import grails.gorm.services.Service
import grails.gorm.transactions.Transactional
import groovy.transform.CompileStatic

@Service(Vehicle)
@CurrentTenant
@CompileStatic
abstract class VehicleService {

  @Join('engines')
  abstract List<Vehicle> list(Map args)

  abstract Integer count()

  @Join('engines')
  abstract Vehicle find(Serializable id)

  abstract Vehicle save(String model, Integer year)

  abstract Vehicle delete(Serializable id)

  @Transactional
  Vehicle update(Serializable id, String model, Integer year) {
    Vehicle vehicle = find(id)
    if (vehicle != null) {
      vehicle.model = model
      vehicle.year = year
      vehicle.save(failOnError: true)
    }
    vehicle
  }
}