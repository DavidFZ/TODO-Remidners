package edu.square.model.view1.subframe;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddReminderConfirmFrameModel {

    public static List<String> getFutureYears(int futureYearCount) {
        int currentYear = Calendar.getInstance().get(java.util.Calendar.YEAR);

        return convertIntToStringListStepOne(currentYear, currentYear + futureYearCount);
    }

    public static List<String> getMonths() {
        return convertIntToStringListStepOne(1, 12);
    }

    public static List<String> getDaysInMonth(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        int daysInMonth = yearMonth.lengthOfMonth();

        return convertIntToStringListStepOne(1, daysInMonth);
    }


    private static List<String> getHours() {
        return convertIntToStringListStepOne(0, 23);
    }

    /**
     * Include start and end
     *
     * @param start
     * @param end
     * @return
     */
    private static List<String> convertIntToStringListStepOne(int start, int end) {
        assert start <= end;

        List<String> stringList = new ArrayList<>();
        for (int i = start; i <= end; i++)
            stringList.add(String.valueOf(i));

        return stringList;
    }
}
