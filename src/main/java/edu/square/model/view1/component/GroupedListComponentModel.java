package edu.square.model.view1.component;

import edu.square.entity.Reminder;
import edu.square.model.MModel;
import lombok.Data;
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
    }

    public void removeReminder(Reminder reminder) {
        list.remove(reminder);
    }

}
