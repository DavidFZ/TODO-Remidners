package edu.square.utils;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeUtils {

    /**
     * Generate dates in one year range.
     * Start date should be before the End date
     * Otherwise, this method will modify these vars
     *
     * @param startDate LocalDateObj
     * @param endDate   EndDateObj
     * @return List<LocalDate> List of LocalDate range between startDate and endDate
     */
    public static List<LocalDate> generateDatesInRange(LocalDate startDate, LocalDate endDate) {
        assert endDate.isAfter(startDate);
        if (!endDate.isAfter(startDate)) {
            LocalDate t = endDate;
            endDate = startDate;
            startDate = t;
        }

        List<LocalDate> datesInRange = new ArrayList<>();
        LocalDate currentDate = startDate;

        while (!currentDate.isAfter(endDate)) {
            datesInRange.add(currentDate);
            currentDate = currentDate.plusDays(1);
        }

        return datesInRange;
    }

    /**
     * Generate the hole dates between years
     *
     * @param startYear include start year
     * @param endYear   include end year
     * @return hole days in range of [startYear, endYear]
     */
    public static List<LocalDate> generateDatesInRange(int startYear, int endYear) {
        List<LocalDate> datesInRange = new ArrayList<>();

        for (int year = startYear; year <= endYear; year++) {
            LocalDate startDate = LocalDate.of(year, 1, 1);
            LocalDate endDate = LocalDate.of(year, 12, 31);

            LocalDate currentDate = startDate;
            while (!currentDate.isAfter(endDate)) {
                datesInRange.add(currentDate);
                currentDate = currentDate.plusDays(1);
            }
        }

        return datesInRange;
    }


    /**
     * Get dates in range of this month
     *
     * @return List<LocalDate> dates in range of this month
     */
    public static List<LocalDate> getDateInThisMoth() {
        return getDatesInTheMoth(LocalDate.now());
    }

    /**
     * Get all dates in the month of the given date
     *
     * @param date Given date
     * @return All dates in the month of the given date
     */
    public static List<LocalDate> getDatesInTheMoth(LocalDate date) {
        LocalDate startOfMoth = date.withDayOfMonth(1);
        LocalDate endOfMoth = date.withDayOfMonth(date.lengthOfMonth());
        return generateDatesInRange(startOfMoth, endOfMoth);
    }

    public static Date covertLocalDateToStartOfDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }


    /**
     * Get the Timestamp of start and end of today
     *
     * @param isTheStartOfTheDay return the start of the day or the end of the day
     * @return Timestamp
     */
    public static Timestamp getStartTimestampOfToday(boolean isTheStartOfTheDay) {
        LocalDate today = LocalDate.now();
        LocalDateTime todayEnd = today.atTime(23, 59, 59, 999999999);

        LocalDateTime localDateTime;
        if (isTheStartOfTheDay)
            return Timestamp.valueOf(today.atStartOfDay());
        return Timestamp.valueOf(todayEnd);
    }

}
