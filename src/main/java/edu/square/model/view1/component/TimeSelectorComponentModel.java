package edu.square.model.view1.component;

import edu.square.model.component.MModel;
import edu.square.model.view1.subframe.AddReminderConfirmFrameModel;

import java.util.Calendar;
import java.util.List;

public class TimeSelectorComponentModel extends MModel {
    public static final List<String> MONTHS = AddReminderConfirmFrameModel.getMonths();
    public static final List<String> HOURS = AddReminderConfirmFrameModel.getHours();
    public final List<String> YEARS = AddReminderConfirmFrameModel.getFutureYears(5);
    private final int[] cnt = new int[4];
    public List<String> days = AddReminderConfirmFrameModel.getDaysInThisMonth();

    public TimeSelectorComponentModel() {
        updateModelGlobally();
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
