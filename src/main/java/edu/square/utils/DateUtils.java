package edu.square.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DateUtils {

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
}
