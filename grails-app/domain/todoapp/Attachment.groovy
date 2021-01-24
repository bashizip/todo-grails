package todoapp

import training.Todo

class Attachment {
    String name
    String url

    static belongsTo = [todo: Todo]

    static constraints = {
        name maxSize: 20, blank: false
        url minSize: 10, maxSize: 255, nullable: true
    }

    @Override
    String toString() {
        url
    }
}
