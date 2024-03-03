class RailwayTicketOffice(private val trains: MutableList<Train>, private val stations: MutableList<Station>) {
    private var stationSearch: String = ""
    private var time: String = "00:00"
    private var date: String = "01/01/2000"

    fun registration(stationSearch: String, time: String, date: String) {
        this.stationSearch = stationSearch
        this.time = time
        this.date = date
    }

    fun searchTrain() {
        val timeInt = convertTimeToInt(time)
        val dateInt = convertDateToInt(date)

        val newPackTrains = trains.filter { train ->
            train.schedule.any { schedule ->
                val scheduleDateInt = convertDateToInt(schedule.date)
                val scheduleTimeInt = convertTimeToInt(schedule.time)
                schedule.numberStation == stations.find { it.name == stationSearch }?.number &&
                        (scheduleDateInt.third > dateInt.third ||
                                (scheduleDateInt.third == dateInt.third && scheduleDateInt.second > dateInt.second) ||
                                (scheduleDateInt.third == dateInt.third && scheduleDateInt.second == dateInt.second && scheduleDateInt.first >= dateInt.first)) &&
                        (scheduleTimeInt.first > timeInt.first ||
                                (scheduleTimeInt.first == timeInt.first && scheduleTimeInt.second >= timeInt.second))
            }
        }

        newPackTrains.forEach { printTrain(it) }
    }

    fun printTrain(train: Train) {
        println("\n=====================")
        println("Номер поезда: ${train.number}")
        println("Станции: ")
        train.schedule.forEach { schedule ->
            println("${schedule.numberStation}. ${stations.find { it.number == schedule.numberStation }?.name} - ${schedule.time} | ${schedule.date}")
        }
        println("Конечная станция: ${stations.find { it.number == train.getEndStation().numberStation }?.name}")
        println("Дата и время: ${train.getEndStation().time} | ${train.getEndStation().date}")
        println("Цена: ${train.price}")
        println("=====================")
    }
}