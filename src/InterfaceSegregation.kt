// Interface Segregation principle
// Make fine grained interfaces that are client specific.
// It's better to have many smaller interfaces, rather than fewer, fatter ones.

// I have a landing site.
interface LandingSiteHaving {
    var landingSite: String
}

// I can land on LandingSiteHaving objects.
interface Landing {
    fun landOn(on: LandingSiteHaving): String
}

// I have payload.
interface PayloadHaving {
    var payload: String
}

// I can fetch payload from vehicle (ex. via Canadarm).
final class InternationalSpaceStation {
    // Space station has no idea about landing capabilities of SpaceXCRS8.
    fun fetchPayload(vehicle: PayloadHaving): String {
        return "Deployer ${vehicle.payload} at April 10, 2016, 11:23 UTC"
    }
}

// I'm a barge - I have landing site (well, you get the idea).
final class OfCourseIStillLoveYouBarge : LandingSiteHaving {
    override var landingSite = "a barge on the Atlantic Ocean"
}

// I have payload and can land on things having landing site.
// I'm a very limited Space Vehicle, I know.
final class SpaceXCRS8 : Landing, PayloadHaving {

    override var payload = "BEAM and some Cube Sats"

    // CRS8 knows only about the landing site information.
    override fun landOn(on: LandingSiteHaving): String {
        return "Landed on ${on.landingSite} at April 8, 2016 20:52 UTC"
    }
}

fun main(args: Array<String>) {
    val crs8 = SpaceXCRS8()
    val barge = OfCourseIStillLoveYouBarge()
    val spaceStation = InternationalSpaceStation()

    println(spaceStation.fetchPayload(crs8))
    println(crs8.landOn(barge))
}