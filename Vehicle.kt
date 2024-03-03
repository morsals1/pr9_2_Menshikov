package vehicle

class Vehicle(val model: String) {
    var isFunctional: Boolean = true

    fun repair() {
        isFunctional = true
    }
    // Дополнительные методы и поля
}