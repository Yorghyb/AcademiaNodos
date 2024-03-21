fun main() {
    val productosBike = arrayListOf<productos>()
//    val preciosBike = arrayListOf<precios>()
//    val stockBike = arrayListOf<stock>(5)
    println("Bienvenido al e-commerce BikeYaba")
    var opcionElegida: Int? = null
    while (opcionElegida != 6) {
        println("[1] Mostrar los productos creados")
        println("[2] Crear un producto")
        println("[3] Modificar producto")
        println("[4] eliminar un ´producto")
        println("[5] Entrada de producto al stock")
        println("[6] Salir")
        opcionElegida = readln().toIntOrNull()
        when (opcionElegida) {
            1 -> bike.mostrarProductos
        } else run {
            println("Opcion elegida no es viable")
        }
    }


//    val bike1 = bike(
//        idBike = 1001,
//        marca = "trek",
//        color = "rojo",
//        talla = "M",
//    )
//    val bike2 = bike(
//        idBike = 1002,
//        marca = "scott",
//        color = "Negro",
//        talla = "S",
//    )






    fun crearProducto(productosbike: bike, preciosbike: bike, stockbike: bike) {
        var products = toString();
        println("Debes ingresar el nombre de tu nuevo producto")
        var producto = readln().toString()

    }


    fun mostrarProductos(productosbike: bike, preciosbike: bike, stockbike: bike) {
        println("Bike disponibles")
        productosbike.forEach { println("Bike"(It)) }
    }
}



class bike(
    val idBike: Int,
    val marca: String,
    val color: String,
    val talla: String,
    val cantidad: String,
    val precio: Double,

    )






