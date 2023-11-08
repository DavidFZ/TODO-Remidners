package edu.square.model.view1.component;

import edu.square.entity.Reminder;
import edu.square.model.component.MModel;
import edu.square.model.view1.widget.ReminderModel;
import lombok.Getter;
import lombok.Setter;

public class DetailInformationModel extends MModel {
    @Getter
    @Setter
    private Reminder reminder;

    public DetailInformationModel(Reminder reminder) {
        this.reminder = reminder;
    }

    public DetailInformationModel() {
        this.reminder = new Reminder();
    }

    public void updateReminder(Reminder reminder) {
        assert this.reminder.getUuid().equals(reminder.getUuid());

        this.reminder = reminder;
        ReminderModel.updateReminder(reminder);
    }

    public void deleteReminder() {
        reminder.setIsDeleted(true);
        ReminderModel.updateReminder(reminder);
    }
}
