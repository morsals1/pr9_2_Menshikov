package manager

import driver.Driver
import trip.Trip
import vehicle.Vehicle
class TripManager {
    private val trips = mutableListOf<Trip>()

    fun addTrip(trip: Trip) {
        trips.add(trip)
    }

    fun completeTrip(trip: Trip) {
        trip.completeTrip()
    }

    fun getPendingTrips(): List<Trip> {
        return trips.filter { !it.isCompleted }
    }
}