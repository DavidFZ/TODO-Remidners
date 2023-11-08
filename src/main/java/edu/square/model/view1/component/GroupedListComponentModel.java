package edu.square.model.view1.component;

import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.widget.ReminderModel;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class GroupedListComponentModel extends MModel {
    @Setter
    private List<Reminder> list;

    public GroupedListComponentModel() {
        list = new ArrayList<>();
    }

    public void addReminder(Reminder reminder) {
        list.add(reminder);
        //persist layer
        ReminderModel.insertReminder(reminder);
    }

    public void deleteReminder(Reminder reminder) {
        list.remove(reminder);
    }

}
