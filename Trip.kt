package trip

import driver.Driver
import vehicle.Vehicle

class Trip(val destination: String) {
    var isCompleted: Boolean = false
    var assignedDriver: Driver? = null
    var assignedVehicle: Vehicle? = null

    fun completeTrip() {
        isCompleted = true
    }

    fun assignDriver(driver: Driver) {
        assignedDriver = driver
    }

    fun assignVehicle(vehicle: Vehicle) {
        assignedVehicle = vehicle
    }
    // Дополнительные методы и поля
}