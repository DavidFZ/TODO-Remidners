package edu.square.model.view1.component;

import edu.square.model.component.MModel;

import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TimeSelectorComponentModel extends MModel {
    public static final List<String> MONTHS = getMonths();
    public static final List<String> HOURS = getHours();
    public final List<String> YEARS = getFutureYears(5);
    private final int[] cnt = new int[4];
    public List<String> days = getDaysInThisMonth();

    public TimeSelectorComponentModel() {
        updateModelGlobally();
    }

    public static List<String> getFutureYears(int futureYearCount) {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);

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

    public static List<String> getDaysInThisMonth() {
        Calendar calendar = Calendar.getInstance();
        return getDaysInMonth(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1);
    }

    public static List<String> getHours() {
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


    public void updateTimeCounter() {
        Calendar calendar = Calendar.getInstance();
        cnt[0] = calendar.get(Calendar.YEAR);
        cnt[1] = calendar.get(Calendar.MONTH) + 1;
        cnt[2] = calendar.get(Calendar.DATE);
        cnt[3] = calendar.get(Calendar.HOUR_OF_DAY);
    }


    @Override
    public void updateModelGlobally() {
        updateTimeCounter();
    }
}
