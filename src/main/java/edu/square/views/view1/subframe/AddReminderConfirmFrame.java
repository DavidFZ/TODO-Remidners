package edu.square.views.view1.subframe;

import edu.square.entity.Reminder;
import edu.square.utils.TimeUtils;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.view1.widget.TextFieldPanelWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.Calendar;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class AddReminderConfirmFrame {
    private final JFrame mainFrame;
    private final JTextField itemName;
    private final JButton confirmButton;
    private final JRadioButton flagRadio;
    private final TextFieldPanelWidget yearsTextFieldPanelWidget;
    private final TextFieldPanelWidget monthsTextFieldPanelWidget;
    private final TextFieldPanelWidget datesTextFieldPanelWidget;
    private final TextFieldPanelWidget hoursTextFieldPanelWidget;
    private JRadioButton emergentRadio;

    public AddReminderConfirmFrame(Dimension selfDimension) {
        Font font = FontUtil.getBoldFont(selfDimension, 0.05);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add item");
        mainFrame.setLayout(new BorderLayout());

        BlockPanelWidget blockPanelView = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.3));


        //inputPanel
        JLabel inputLabel = new JLabel("Reminder Content:");
        inputLabel.setFont(font);
        JLabel tipsLabel = new JLabel("Reminder Time (number):");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.05));
        inputLabel.setFont(font);
        itemName = new JTextField(30);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        flagRadio = new JRadioButton("Flagged");
        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        detailMessagePanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension.getSize(), 0.8, 0.1));
        detailMessagePanel.add(flagRadio);

        yearsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "years:");
        monthsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "months:");
        datesTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "dates:");
        hoursTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.45, 0.05), "hours:");

        setTextAsToday();

        inputPanel.setBackground(Color.green);
        inputPanel.add(inputLabel);
        inputPanel.add(itemName);
        inputPanel.add(tipsLabel);
        inputPanel.add(yearsTextFieldPanelWidget.getMainPanel());
        inputPanel.add(monthsTextFieldPanelWidget.getMainPanel());
        inputPanel.add(datesTextFieldPanelWidget.getMainPanel());
        inputPanel.add(hoursTextFieldPanelWidget.getMainPanel());
        inputPanel.add(detailMessagePanel);

        confirmButton = new JButton("Confirm");
        JPanel confirmPanel = new JPanel(new BorderLayout());
        //while input Enter will be same as click confirm button
        confirmPanel.add(confirmButton);

        //parent frame will not close when sub frame is closed
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        mainFrame.setAlwaysOnTop(true);
        mainFrame.add(BorderLayout.NORTH, blockPanelView.getMainPanel());
        mainFrame.add(BorderLayout.CENTER, inputPanel);
        mainFrame.add(BorderLayout.SOUTH, confirmPanel);
        mainFrame.setResizable(false);
        mainFrame.setLocationRelativeTo(null);

    }

    public static void main(String[] args) {
        AddReminderConfirmFrame addReminderConfirmFrame = new AddReminderConfirmFrame(new Dimension(500, 500));
        addReminderConfirmFrame.mainFrame.setVisible(true);
    }

    private void setTextAsToday() {
        Calendar calendar = Calendar.getInstance();
        yearsTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.YEAR)));
        monthsTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.MONTH) + 1));
        datesTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.DATE)));
        hoursTextFieldPanelWidget.setTextField(String.valueOf(calendar.get(Calendar.HOUR_OF_DAY)));
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
        String years = yearsTextFieldPanelWidget.getTextField().getText();
        String months = monthsTextFieldPanelWidget.getTextField().getText();
        String dates = datesTextFieldPanelWidget.getTextField().getText();
        String hours = hoursTextFieldPanelWidget.getTextField().getText();

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
