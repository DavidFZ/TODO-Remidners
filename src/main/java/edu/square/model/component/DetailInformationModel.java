//package edu.square.model.component;
//
//import edu.square.entity.Reminder;
//import edu.square.views.component.DetailInformationComponent;
//import edu.square.views.widget.ReminderListWidgetView;
//import lombok.Getter;
//
//import java.awt.event.ActionListener;
//
//import static edu.square.model.view1.widget.ReminderModel.updateReminder;
//
//public class DetailInformationModel extends MComponentModel {
//    private final DetailInformationComponent detailInformationComponent;
//    @Getter
//    private ReminderListWidgetView.ReminderView reminderView;
//
//    public DetailInformationModel(DetailInformationComponent detailInformationComponent) {
//        super(detailInformationComponent);
//        this.detailInformationComponent = detailInformationComponent;
//
//        //invisible the component
//        setInvisibleOfComponent();
//
//        //set component inner listener
//        detailInformationComponent.getBackButton().addActionListener(e -> {
//            setInvisibleOfComponent();
//        });
//        detailInformationComponent.getDoneButton().addActionListener(e -> {
//            updateDBOfReminderDetailInfo();
//        });
//        detailInformationComponent.getResetButton().addActionListener(e -> {
//            resetViewOfReminderDetailInfo();
//        });
//        detailInformationComponent.getDeleteButton().addActionListener(e -> {
//            deleteDBOfReminder();
//            setInvisibleOfComponent();
//        });
//    }
//
//    public void updateViewOfReminderDetailInfo(ReminderListWidgetView.ReminderView reminderView) {
//        this.reminderView = reminderView;
//        Reminder reminder = reminderView.getReminder();
//        detailInformationComponent.getNameTextFieldPanelWidget().getTextField().setText(reminder.getContent());
//        detailInformationComponent.getNoteTextFieldPanelWidget().getTextField().setText(reminder.getNote());
//    }
//
//    public void resetViewOfReminderDetailInfo() {
//        updateViewOfReminderDetailInfo(reminderView);
//    }
//
//    public void updateDBOfReminderDetailInfo() {
//        Reminder reminder = reminderView.getReminder();
//        reminder.setContent(detailInformationComponent.getNameTextFieldPanelWidget().getTextField().getText());
//        reminder.setNote(detailInformationComponent.getNoteTextFieldPanelWidget().getTextField().getText());
//        updateReminder(reminder);
//    }
//
//    public void deleteDBOfReminder() {
//        Reminder reminder = reminderView.getReminder();
//        reminder.setIsDeleted(true);
//        updateReminder(reminder);
//    }
//
//    public void setVisibleOfComponent(ReminderListWidgetView.ReminderView reminderView) {
//        assert reminderView != null;
//        updateViewOfReminderDetailInfo(reminderView);
//        detailInformationComponent.getMainPanel().setVisible(true);
//    }
//
//    public void setInvisibleOfComponent() {
//        detailInformationComponent.getMainPanel().setVisible(false);
//    }
//
//    public void addListenerOnDeleteButton(ActionListener actionListener) {
//        detailInformationComponent.getDeleteButton().addActionListener(actionListener);
//    }
//
//}
