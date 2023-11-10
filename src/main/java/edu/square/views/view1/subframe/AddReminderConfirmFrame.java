package edu.square.views.view1.subframe;

import edu.square.entity.Reminder;
import edu.square.utils.TimeUtils;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.widget.ComboBoxPanelWidgetView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class AddReminderConfirmFrame {
    private final JFrame mainFrame;
    private final JTextField itemName;
    private final JButton confirmButton;
    private final JRadioButton flagRadio;

    private final ComboBoxPanelWidgetView yearsComboBoxPanelWidgetView;
    private final ComboBoxPanelWidgetView monthsComboBoxPanelWidgetView;
    private final ComboBoxPanelWidgetView datesComboBoxPanelWidgetView;
    private final ComboBoxPanelWidgetView hoursComboBoxPanelWidgetView;
    private JRadioButton emergentRadio;
    String[] years = {
             "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"
    };
    String[] months = {
             "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12"
    };
    String[] days = {
             "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12"
    };
    String[] hours = {
            "1", "2", "3", "4",
            "5", "6", "7", "8",
            "9", "10", "11", "12",
            "13", "14", "15", "16",
            "17", "18", "19", "20",
            "21", "22", "23", "24",
            "25", "26", "27", "28",
            "29", "30", "31",
    };

    public AddReminderConfirmFrame(Dimension selfDimension) {
        Font font1 = FontUtil.getBoldFont(selfDimension, 0.05);
        Font font2 = FontUtil.getBoldFont(selfDimension, 0.03);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add item");
        mainFrame.setLayout(new BorderLayout());

        //inputPanel
        JLabel inputLabel = new JLabel("Reminder Content:");
        inputLabel.setFont(font1);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        inputPanel.setBackground(Color.green);
        inputPanel.add(inputLabel);

        itemName = new JTextField();
        itemName.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.05));
        JLabel tipsLabel = new JLabel("Reminder Time (number):");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.05));


        yearsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "years:", List.of(years));
        monthsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "months:", List.of(months));
        datesComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "days:", List.of(days));
        hoursComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "hours:", List.of(hours));
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.05));

//        yearsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "years:");
//        monthsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "months:");
//        datesTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "dates:");
//        hoursTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "hours:");

        flagRadio = new JRadioButton("Flagged");

        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        detailMessagePanel.add(blockPanelWidget.getMainPanel());
        detailMessagePanel.add(itemName);
        detailMessagePanel.add(tipsLabel);
        detailMessagePanel.add(yearsComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(monthsComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(datesComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(hoursComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(blockPanelWidget.getMainPanel());
//        detailMessagePanel.add(yearsTextFieldPanelWidget.getMainPanel());
//        detailMessagePanel.add(monthsTextFieldPanelWidget.getMainPanel());
//        detailMessagePanel.add(datesTextFieldPanelWidget.getMainPanel());
//        detailMessagePanel.add(hoursTextFieldPanelWidget.getMainPanel());
        detailMessagePanel.add(flagRadio);

        confirmButton = new JButton("Confirm");
        JPanel confirmPanel = new JPanel(new BorderLayout());
        //while input Enter will be same as click confirm button
        confirmPanel.add(confirmButton);

        //parent frame will not close when sub frame is closed
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        mainFrame.add(BorderLayout.NORTH, inputPanel);
        mainFrame.add(BorderLayout.CENTER, detailMessagePanel);
        mainFrame.add(BorderLayout.SOUTH, confirmPanel);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);
        setTextAsToday();
    }

    public static void main(String[] args) {
        AddReminderConfirmFrame addReminderConfirmFrame = new AddReminderConfirmFrame(new Dimension(500, 500));
        addReminderConfirmFrame.mainFrame.setVisible(true);
    }

    private void setTextAsToday() {
        Calendar calendar = Calendar.getInstance();
        yearsComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(calendar.get(Calendar.YEAR)));
        monthsComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(calendar.get(Calendar.MONTH) + 1));
        datesComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(calendar.get(Calendar.DATE)));
        hoursComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
//        yearsTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.YEAR)));
//        monthsTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.MONTH) + 1));
//        datesTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.DATE)));
//        hoursTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
    }

    public String getItemName() {
        return itemName.getText();
    }

    public void setVisibility(boolean visibility) {
        mainFrame.setVisible(visibility);
    }

    public void setConfirmButtonListener(ActionListener actionListener) {
        confirmButton.addActionListener(actionListener);
    }

    public void cleanTextField() {
        itemName.setText("");
    }

    public boolean isFlagged() {
        return flagRadio.isSelected();
    }

    public Reminder getReminderFromInput() {
        Reminder reminder = new Reminder(itemName.getText());
        Timestamp timestamp = illegalInputJudge();
        if (timestamp == null)
            return null;

        reminder.setRemindTime(timestamp);
        reminder.setIsImportant(isFlagged());
        return reminder;
    }

    private Timestamp illegalInputJudge() {
        //item judge
        String content = itemName.getText();
        if (content == null || content.equals("")) {
            JOptionPane.showMessageDialog(null, "Please input content");
            return null;
        } else if (content.length() > 30) {
            JOptionPane.showMessageDialog(null, "Please input content less than 30 characters");
            return null;
        }

        //time judge
        String years = (String) yearsComboBoxPanelWidgetView.getjComboBox().getSelectedItem();
        String months = (String) monthsComboBoxPanelWidgetView.getjComboBox().getSelectedItem();
        String dates = (String) datesComboBoxPanelWidgetView.getjComboBox().getSelectedItem();
        String hours = (String) hoursComboBoxPanelWidgetView.getjComboBox().getSelectedItem();
//        String years = yearsTextFieldPanelWidget.getTextField().getText();
//        String months = monthsTextFieldPanelWidget.getTextField().getText();
//        String dates = datesTextFieldPanelWidget.getTextField().getText();
//        String hours = hoursTextFieldPanelWidget.getTextField().getText();

        Timestamp timestamp = TimeUtils.convertToTimestamp(years, months, dates, hours);
        if (timestamp == null) {
            JOptionPane.showMessageDialog(null, "Please input correct time");
        }

        //time should be later than now
        if (timestamp.before(TimeUtils.getCurrentTimestamp())) {
            JOptionPane.showMessageDialog(null, "Please input time later than now");
            return null;
        }
        return timestamp;
    }
}
