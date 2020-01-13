package multi.tenant

class Manufacturer {
    String name

    static constraints = {
        name blank: false, unique: true
    }
}
