import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

fun convertTimeToInt(time: String): Pair<Int, Int> {
    val parts = time.split(":").map { it.toInt() }
    return Pair(parts[0], parts[1])
}

fun convertDateToInt(date: String): Triple<Int, Int, Int> {
    val parts = date.split("/").map { it.toInt() }
    return Triple(parts[0], parts[1], parts[2])
}

fun main() {
    val stations = mutableListOf(
        Station(1, "Дмитров"),)

    val trains = mutableListOf(
        Train(1, listOf(Schedule(1, "7:00", "01/03/2023"), Schedule(6, "17:00", "02/03/2023")), 89.0))

    val railwayTicketOffice = RailwayTicketOffice(trains, stations)
    println("От станции Дмитров")
    println("Билет до Катуар на 9:00 01/03/2023")
    railwayTicketOffice.registration("Катуар", "9:00", "01/03/2023")
    railwayTicketOffice.searchTrain()
}
