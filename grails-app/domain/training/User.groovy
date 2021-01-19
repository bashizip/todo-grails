package training

class User {

    String email
    String name

    static hasMany = [todo: Todo]

    static constraints = {
        email size: 5..45, blank: false, nullable: false
        name size: 3..50, blank: true, nullable: true
    }

    @Override
    String toString() {
        name == null ? email : name
    }
}
