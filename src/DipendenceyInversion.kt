interface TimeTraveling {
    fun travelInTime(time: String): String
}

final class DeLorean : TimeTraveling {
    override fun travelInTime(time: String): String {
        return "Used Flux Capacitor and travelled in time by: ${time}s"
    }
}

final class EmmettBrown(private val timeMachine: TimeTraveling) {
    // Emmet Brown is given the DeLorean as a TimeTraveling device, not the concrete class DeLorean.
    fun travelInTime(time: String): String {
        return timeMachine.travelInTime(time)
    }
}

fun main(args: Array<String>) {

    val timeMachine = DeLorean()

    val mastermind = EmmettBrown(timeMachine)
    println(mastermind.travelInTime("3445433"))
}