package edu.square.views.view1.subframe;

import edu.square.entity.Reminder;
import edu.square.model.view1.subframe.AddReminderConfirmFrameModel;
import edu.square.utils.TimeUtils;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.view1.widget.ComboBoxPanelWidgetView;

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

    private final List<String> YEARS = AddReminderConfirmFrameModel.getFutureYears(5);
    private final List<String> MONTHS = AddReminderConfirmFrameModel.getMonths();
    private final List<String> HOURS = AddReminderConfirmFrameModel.getHours();
    List<String> days;
    private JRadioButton emergentRadio;

    public AddReminderConfirmFrame(Dimension selfDimension) {
        days = AddReminderConfirmFrameModel.getDaysInThisMonth();

        Font font1 = FontUtil.getBoldFont(selfDimension, 0.05);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add Reminder");
        mainFrame.setLayout(new BorderLayout());

        //inputPanel
        JLabel inputLabel = new JLabel("Reminder Content");
        inputLabel.setFont(font1);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        inputPanel.setBackground(Color.green);
        inputPanel.add(inputLabel);

        itemName = new JTextField();
        itemName.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.1));

        BlockPanelWidget blockPanelWidget0 = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.1));

        JLabel tipsLabel = new JLabel("Set Reminder Time");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.1));
        tipsLabel.setFont(FontUtil.getBoldFont(selfDimension, FontUtil.FONT_SIZE_1));


        yearsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "year:", YEARS);
        monthsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "month:", MONTHS);
        datesComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "day:", days);
        hoursComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "hour:", HOURS);
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.05));

        flagRadio = new JRadioButton("Flagged");

        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        detailMessagePanel.add(blockPanelWidget.getMainPanel());
        detailMessagePanel.add(itemName);
        detailMessagePanel.add(blockPanelWidget0.getMainPanel());
        detailMessagePanel.add(tipsLabel);
        detailMessagePanel.add(yearsComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(monthsComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(datesComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(hoursComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(blockPanelWidget.getMainPanel());

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

        monthsComboBoxPanelWidgetView.getjComboBox().addActionListener(e -> {
            int year = Integer.parseInt((String) yearsComboBoxPanelWidgetView.getjComboBox().getSelectedItem());
            int month = Integer.parseInt((String) monthsComboBoxPanelWidgetView.getjComboBox().getSelectedItem());
            days = AddReminderConfirmFrameModel.getDaysInMonth(year, month);
            datesComboBoxPanelWidgetView.updateOptionsView(days);
        });
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
