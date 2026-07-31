import java.time.DayOfWeek
import java.time.LocalDate
import java.time.YearMonth
import java.util.stream.Stream

class Meetup(month: Int, year: Int) {

    private val ym = YearMonth.of(year, month)

    val dates: Stream<LocalDate> get() =
        ym.atDay(1)
            .datesUntil(
                /* endExclusive = */ ym.plusMonths(1)
                    .atDay(1))


    fun day(dayOfWeek: DayOfWeek, schedule: MeetupSchedule): LocalDate{
        return dates.filter { it.dayOfWeek == dayOfWeek }
            .toList()
            .bySchedule(schedule)
    }

    private fun List<LocalDate>.bySchedule(schedule: MeetupSchedule): LocalDate {
        return when (schedule) {
            MeetupSchedule.FIRST -> first()
            MeetupSchedule.SECOND -> drop(1).first()
            MeetupSchedule.THIRD -> drop(2).first()
            MeetupSchedule.FOURTH -> drop(3).first()
            MeetupSchedule.LAST -> last()
            MeetupSchedule.TEENTH -> first { it.dayOfMonth in 13..19 }
        }
    }
}
