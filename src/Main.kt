fun main() {

    //Testing params
    val testName = "Pepe"
    val testTypeName = "Pajaro"
    val testWashingType = "Con un atomizador de agua se lo aplicamos a la mascota"
    val testFood = "alpiste"
    val testSound = "pio pio"

    //Begin
    println("Bienvenidos a tu juego de mascota")
    println("Para crear tu mascota necesitamos algunos datos")
    println("¿Que nombre quieres para tu mascota?")
    //val petName = readln()
    val petName = testName
    println("¿Que tipo de mascota es?")
    //val petTypeName = readln()
    val petTypeName = testTypeName
    println("¿Como se baña tu mascota?")
    //val washingInstructions = readln()
    val washingInstructions = testWashingType
    println("¿Que tipo de comida le das?")
    //val foodType = readln()
    val foodType = testFood
    println("¿Que sonido hace tu animal?")
    //val soundType = readln()
    val soundType = testSound
    val pet = Pet(
        name = petName,
        type = PetType(petTypeName, washingInstructions, foodType, soundType),

        )
    //Poner menu de funciones para hacer con la mascota
    //[1] Jugar
    //[2] Sonido
    //[3] Ver estado de la mascota
    println("Entremos al menú de tu mascota")
    var opcionMenu: Int? = null
    while (opcionMenu != 4) {
        menuMascota()
        opcionMenu = readln().toIntOrNull()
        when (opcionMenu) {
            1 -> pet.play()
            2 -> pet.eat()
            3 -> pet.reset()
            4 -> println("Salir")
            else -> println("Opción no valida")
        }
    }


//    pet.play()
//    pet.sound()
//    pet.eat()
//    pet.reset()


}

fun menuMascota() {
    println("[1] Jugar con tu mascota")
    println("[2] Darle de comer a tu mascota")
    println("[3] Dormir a tu mascota")
    println("[4] Salir del menú de tu mascota")


}

class Pet(
    val name: String,
    var health: Int = 100,
    val type: PetType,
    var energy: Int = 100,
    var hungry: Int = 10,
    var sleep: Float = 0.0F
) {


    fun play() {
        val phrases = arrayListOf(
            "La mascota $name, se subió encima del sofá",
            "La mascota $name, salta la silla",
            "La mascota $name, sale a saludar",
            "La mascota $name, está corriendo alrededor mío",
            "La mascota $name, mueve la cola",
            "La mascota $name, me persigue",
            "La mascota $name, está oliendo el piso"
        )
        println(phrases.random())
        val wastedEnergy = (1..80).random()
        if (energy - wastedEnergy > 0) {
            energy -= wastedEnergy
            println("La mascota de tipo: ${type.name}, gastó $wastedEnergy% de energia, su energía actualmente es: $energy")
        } else {
            println("El necesita descanso")
        }
    }

    fun sound() {
        type.sound()
    }

    fun eat() {
        val hambreAumentada = (1..80).random()
        if (hungry <= 70) {
            hungry = hungry + hambreAumentada
            println("El porcentaje de hambre de tu ${type.name} es: $hungry%")
        } else {
            println("aun no tiene hambre")
        }
        if (hungry >= 10) {
            println("Dale algo de comer a tu mascota ${type.name}")
            println("Indica el valor de comida que deseas darle")
            println("EL valor de comida no puede ser mayor a $hungry")
            val comida = readln().toIntOrNull()
            if (comida == null) {
                println("No puedes darle ese valor de comida!")
            } else {
                if (comida > hungry) {
                    println("No puedes darle tanta comida")
                } else {
                    val porcentajeHambre = hungry - comida
                    if (porcentajeHambre <= 0) {
                        val energiaRecuperada = (1..15).random()
                        energy = energy + energiaRecuperada
                        println("Tu mascota tiene $energy% de energia")
                        println("No necesita mas comida")
                    } else {
                        println("Puedes darle mas comida si quieres.")
                    }
                }
            }
        } else {
            println("Tu mascota aun no tiene hambre")
        }
    }

    fun reset() {
        val suenoAumentada = (1..70).random()
        if (sleep <= 70) {
            sleep = sleep + suenoAumentada
            println("El porcentaje de sueno de tu ${type.name} es: $sleep%")
        } else {
            println("aun no tiene sueño")
        }
        if (sleep >= 10) {
            println("tu mascota ${type.name} necesita dormir unas horas")
            println("Indica el valor de horas de sueño que le vas a dar")
            println("EL valor de horas no puede ser mayor a $sleep")
            val sueno = readln().toIntOrNull()
            if (sueno == null) {
                println("No puedes darle ese valor de horas!")
            } else {
                if (sueno > sleep) {
                    println("No puedes darle tantas horas de sueño")
                } else {
                    val porcentajeSueno = sleep - sueno
                    if (porcentajeSueno <= 0) {
                        val energiaRecuperada = (1..15).random()
                        energy = energy + energiaRecuperada
                        println("Tu mascota tiene $energy% de energia")
                        println("No necesita mas horas de sueño")
                    } else {
                        println("Puedes darle mas horas de sueño si quieres.")
                    }
                }
            }
        } else {
            println("Tu mascota aun no tiene sueño")
        }
    }

}

class PetType(
    val name: String,
    val washingInstructions: String,
    val food: String,
    val sound: String
) {

    fun sound() {
        println("$name está haciendo un sonido de: $sound")
    }


    override fun toString(): String {
        return "$name, $washingInstructions, $food "
    }
}
