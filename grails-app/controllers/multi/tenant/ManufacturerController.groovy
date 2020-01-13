package multi.tenant

import org.grails.datastore.mapping.multitenancy.web.SessionTenantResolver
import grails.gorm.transactions.ReadOnly
import groovy.transform.CompileStatic

@CompileStatic
class ManufacturerController {
  @ReadOnly
  def index() {
    render view: '/index', model: [manufacturers: Manufacturer.list()]
  }

  @ReadOnly
  def select(String id) {
    Manufacturer m = Manufacturer.where {
      name == id
    }.first()
    if (m) {
      println "Manufacturer::" + m
      session.setAttribute(SessionTenantResolver.ATTRIBUTE, m.name.toLowerCase())
      redirect controller: 'vehicle'
    } else {
      render status: 404
    }
  }
}
