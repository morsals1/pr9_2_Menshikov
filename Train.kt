class Train(val number: Int, val schedule: List<Schedule>, val price: Double) {
    fun getEndStation(): Schedule = schedule.last()
}