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
    }

    public void updateReminder(Reminder reminder) {
        if (this.reminder == null)
            this.reminder = reminder;
        else
            assert this.reminder.getUuid().equals(reminder.getUuid());

        this.reminder = reminder;
        ReminderModel.updateReminder(reminder);
    }

    public void deleteReminder() {
        reminder.setIsDeleted(true);
        ReminderModel.updateReminder(reminder);
    }

    @Override
    public void updateModelGlobally() {
        if (reminder == null || reminder.getUuid() == null)
            return;

        reminder = ReminderModel.queryReminderByUUID(reminder.getUuid());
    }
}
