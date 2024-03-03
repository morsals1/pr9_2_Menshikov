package manager

import driver.Driver
import trip.Trip
import vehicle.Vehicle
class VehicleManager {
    private val vehicles = mutableListOf<Vehicle>()

    fun addVehicle(vehicle: Vehicle) {
        vehicles.add(vehicle)
    }

    fun repairVehicle(vehicle: Vehicle) {
        vehicle.repair()
    }

    fun getAvailableVehicles(): List<Vehicle> {
        return vehicles.filter { it.isFunctional }
    }
}