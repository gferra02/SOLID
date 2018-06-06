// Open/Closed principle
// You should be able to extend a class behaviour without modifying it.
// Open for extension, closed for modification.
// Abstraction is the key.

interface CanShoot {
    fun shoot(): String
}

// I'm a laser beam. I can shoot.
final class LaserBeam : CanShoot {
    override fun shoot(): String {
        return "Ziiiip!"
    }
}

// I have weapons and trust me I can fire them all at once. Boom! Boom! Boom!
final class WeaponsComposite(var weapons: Array<CanShoot>) {
    fun shoot(): String {
        // return weapons.map { it -> it.shoot() }.get(0)
        // Modified the original above to get all of them when there is more than one
        return weapons.map { it -> it.shoot() }.toList().toString()
    }
}

final class RocketLauncher : CanShoot {
    override fun shoot(): String {
        return "Whoosh!"
    }
}

fun main (args: Array<String>) {
    val laser = LaserBeam()
    var weapons = WeaponsComposite(weapons = arrayOf(laser))

    println(weapons.shoot())

    val rocket = RocketLauncher()

    weapons = WeaponsComposite(weapons = arrayOf(laser, rocket))
    println(weapons.shoot())
}