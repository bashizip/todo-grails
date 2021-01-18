package training

class CheckList {

    String label

    static belongsTo=[todo:Todo]

    static constraints = {
        label blank:false, size:3..50
    }

    @Override
    String toString() {
        label
    }
}
