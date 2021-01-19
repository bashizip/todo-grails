package training

class Todo {

    String title
    String description

    static hasMany = [checkList: CheckList]
    static belongsTo = [user: User]

    static constraints = {
        title size: 0..45, blank: false
        description size: 0..255
    }

    @Override
    String toString() {
      return title
    }
}
