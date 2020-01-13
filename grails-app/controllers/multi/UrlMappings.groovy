package multi

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        '/'(controller: 'manufacturer')
        '/vehicles'(resources: 'vehicle')
        '500' (controller: 'manufacturer', exception: TenantNotFoundException)
        "404"(view:'/notFound')
    }
}
