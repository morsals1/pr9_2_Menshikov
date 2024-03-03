fun main() {
    val driverManager = manager.DriverManager()
    val vehicleManager = manager.VehicleManager()
    val tripManager = manager.TripManager()
    val dispatcher = dispatcher.Dispatcher(driverManager, vehicleManager, tripManager)

    println("введите имя водителя")
    val driver1 = driver.Driver("Водитель ${readln()!!.toString()}")
    val driver2 = driver.Driver("Водитель ${readln()!!.toString()}")
    driverManager.addDriver(driver1)
    driverManager.addDriver(driver2)

    println("введите навзание автомобиля")
    val vehicle1 = vehicle.Vehicle("Автомобиль ${readln()!!.toString()}")
    val vehicle2 = vehicle.Vehicle("Автомобиль ${readln()!!.toString()}")
    vehicleManager.addVehicle(vehicle1)
    vehicleManager.addVehicle(vehicle2)

    println("введите пункт назначения")
    val trip1 = trip.Trip("Пункт назначения ${readln()!!.toString()}")
    val trip2 = trip.Trip("Пункт назначения ${readln()!!.toString()}")
    tripManager.addTrip(trip1)
    tripManager.addTrip(trip2)

    dispatcher.assignTripToDriver(driver1.name, trip1.destination)
    dispatcher.assignTripToDriver(driver2.name, trip2.destination)

    println("Назначенные рейсы:")
    tripManager.getPendingTrips().forEach {
        println("${it.destination} назначен на ${it.assignedDriver?.name} с автомобилем ${it.assignedVehicle?.model}")
    }

    trip1.completeTrip()

    println("Завершенные рейсы:")
    tripManager.getPendingTrips().filter { it.isCompleted }.forEach {
        println("${it.destination} завершен водителем ${it.assignedDriver?.name}")
    }

    println("Еще не завершенные рейсы:")
    tripManager.getPendingTrips().filter { !it.isCompleted }.forEach {
        println("${it.destination} еще не завершен и назначен водителю ${it.assignedDriver?.name}")
    }
}
