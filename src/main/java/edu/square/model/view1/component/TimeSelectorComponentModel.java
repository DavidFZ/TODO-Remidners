package edu.square.model.view1.component;

import edu.square.model.component.MModel;
import edu.square.model.view1.subframe.AddReminderConfirmFrameModel;

import java.util.List;

public class TimeSelectorComponentModel extends MModel {
    public static final List<String> MONTHS = AddReminderConfirmFrameModel.getMonths();
    public static final List<String> HOURS = AddReminderConfirmFrameModel.getHours();
    public final List<String> YEARS = AddReminderConfirmFrameModel.getFutureYears(5);
    public List<String> days = AddReminderConfirmFrameModel.getDaysInThisMonth();

    @Override
    public void updateModelGlobally() {
    }
}
