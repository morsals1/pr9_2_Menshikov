package dispatcher

import manager.DriverManager
import manager.VehicleManager
import manager.TripManager
class Dispatcher(
    private val driverManager: DriverManager,
    private val vehicleManager: VehicleManager,
    private val tripManager: TripManager
){
    fun assignTripToDriver(driverName: String, tripDestination: String) {
        val driver = driverManager.getAvailableDrivers().find { it.name == driverName }
        val trip = tripManager.getPendingTrips().find { it.destination == tripDestination }
        val vehicle = vehicleManager.getAvailableVehicles().firstOrNull() // Простая логика выбора автомобиля

        if (driver != null && trip != null && vehicle != null) {
            trip.assignDriver(driver)
            trip.assignVehicle(vehicle)
            println("Trip assigned successfully to ${driver.name} for destination ${trip.destination}.")
        } else {
            println("Failed to assign trip.")
        }
    }
}