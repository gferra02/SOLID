// Single Responisibility Principle

// A class should have one, and only one reason to change.
// If a class as more than one responsibility, a change in one behaviour
// might cause a cascading effect on coupled behaviour(s)

interface CanBeOpened {
    fun open()
}

interface CanBeClosed {
    fun closed()
}

// I'm the door. I have an encapsulated state and you can change it using methods.
final class Door : CanBeOpened, CanBeClosed {

    private enum class State {
        Open, Closed
    }

    private var state: State = State.Closed

    override fun open() {
        state = State.Open
    }

    override fun closed() {
        state = State.Closed
    }
}

// I'm only responsible for opening, no idea what's inside or how to close.
class DoorOpener(door: CanBeOpened) {

    val door: CanBeOpened = door

    fun execute() {
        door.open()
        println("Door is now open")
    }
}

// I'm only responsible for closing, no idea what's inside or how to open.
class DoorCloser(door: CanBeClosed) {
    val door: CanBeClosed = door

    fun execute() {
        door.closed()
        println("Door is now closed")
    }
}

fun main (args: Array<String>) {
    val door = Door()

    val doorOpener = DoorOpener(door)
    doorOpener.execute()

    val doorCloser = DoorCloser(door)
    doorCloser.execute()
}
