import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(startDate: LocalDateTime) {
    constructor(date: LocalDate) : this(date.atStartOfDay())

    val date: LocalDateTime = startDate.plusSeconds(1000*1000*1000)
}
