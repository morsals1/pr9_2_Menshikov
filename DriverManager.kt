package manager

import driver.Driver
import trip.Trip
import vehicle.Vehicle
class DriverManager {
    private val drivers = mutableListOf<Driver>()

    fun addDriver(driver: Driver) {
        drivers.add(driver)
    }

    fun removeDriver(driver: Driver) {
        drivers.remove(driver)
    }

    fun getAvailableDrivers(): List<Driver> {
        return drivers.filter { it.isAvailable }
    }
}