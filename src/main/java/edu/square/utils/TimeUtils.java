package edu.square.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
     * Get the Timestamp of start and end of specific day
     *
     * @param isTheStartOfTheDay return the start of the day or the end of the day
     * @return Timestamp
     */
    public static Timestamp getStartOrEndTimestampOfDate(LocalDate day, boolean isTheStartOfTheDay) {
        LocalDateTime todayEnd = day.atTime(23, 59, 59, 999999999);

        LocalDateTime localDateTime;
        if (isTheStartOfTheDay)
            return Timestamp.valueOf(day.atStartOfDay());
        return Timestamp.valueOf(todayEnd);
    }

    /**
     * Get the Timestamp of start and end of today
     *
     * @param isTheStartOfTheDay return the start of the day or the end of the day
     * @return Timestamp
     */
    public static Timestamp getStartOrEndTimestampOfToday(boolean isTheStartOfTheDay) {
        return getStartOrEndTimestampOfDate(LocalDate.now(), isTheStartOfTheDay);
    }

    /**
     * Get current Timestamp
     *
     * @return current Timestamp
     */
    public static Timestamp getCurrentTimestamp() {
        long currentTIme = System.currentTimeMillis();
        return new Timestamp(currentTIme);
    }

    public static Timestamp getOneHourFormerTimestamp() {
        long currentTIme = System.currentTimeMillis() - 3600000;
        return new Timestamp(currentTIme);
    }

    public static Timestamp convertToTimestamp(String year, String month, String day, String hour) {
        StringHourTime stringHourTime = new StringHourTime(year, month, day, hour);
        if (!stringHourTime.stringLegalJudge())
            return null;
        //将数组转化为Timestamp
        String yearMonthDayHour = stringHourTime.yearMonthDayHour[0] + "-" + stringHourTime.yearMonthDayHour[1] + "-" + stringHourTime.yearMonthDayHour[2] + " " + stringHourTime.yearMonthDayHour[3] + ":00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = simpleDateFormat.parse(yearMonthDayHour);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }

        return new Timestamp(date.getTime());
    }

    public static class StringHourTime {
        private final String[] yearMonthDayHour = new String[4];
        private final int[] yearMonthDayHourInt = new int[4];

        private StringHourTime(String year, String month, String day, String hour) {
            yearMonthDayHour[0] = year;
            yearMonthDayHour[1] = month;
            yearMonthDayHour[2] = day;
            yearMonthDayHour[3] = hour;
        }

        private boolean stringLegalJudge() {
            for (int i = 0; i < yearMonthDayHour.length; i++) {
                String s = yearMonthDayHour[i];
                //null or empty
                if (s == null || s.equals(""))
                    return false;
                //not int
                try {
                    yearMonthDayHourInt[i] = Integer.parseInt(s);
                } catch (NumberFormatException e) {
                    return false;
                }
            }
            //year
            if (yearMonthDayHourInt[0] < 0 || yearMonthDayHourInt[0] > 9999)
                return false;
            //month
            if (yearMonthDayHourInt[1] < 1 || yearMonthDayHourInt[1] > 12)
                return false;
            //day
            if (yearMonthDayHourInt[2] < 1 || yearMonthDayHourInt[2] > 31)
                return false;
            //hour
            return yearMonthDayHourInt[3] >= 0 && yearMonthDayHourInt[3] <= 23;
        }
    }
}
