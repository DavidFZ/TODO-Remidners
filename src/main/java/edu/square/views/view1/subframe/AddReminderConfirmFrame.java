package edu.square.views.view1.subframe;

import edu.square.controller.view1.component.TimSelectorComponentController;
import edu.square.entity.Reminder;
import edu.square.model.view1.component.TimeSelectorComponentModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.component.TimeSelectorComponentView;
import edu.square.views.view1.widget.BlockPanelWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class AddReminderConfirmFrame {
    private final JFrame mainFrame;
    private final JTextField itemName;
    private final JButton confirmButton;
    private final TimSelectorComponentController timSelectorComponentController;
    private final TimeSelectorComponentView timeSelectorComponentView;
    List<String> days;
    private JRadioButton emergentRadio;

    public AddReminderConfirmFrame(Dimension selfDimension) {
        days = TimeSelectorComponentModel.getDaysInThisMonth();

        Font font = FontUtil.getBoldFont(selfDimension, FontUtil.FONT_SIZE_1);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add Reminder");
        mainFrame.setLayout(new BorderLayout());

        //inputPanel
        JLabel inputLabel = new JLabel("Set Reminder Content");
        inputLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.1));
        inputLabel.setFont(font);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        inputPanel.setBackground(Color.green);
        inputPanel.add(inputLabel);

        itemName = new JTextField();
        itemName.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.1));

        BlockPanelWidget blockPanelWidget0 = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.1));

        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.05));

        timeSelectorComponentView = new TimeSelectorComponentView(selfDimension, resizeDimensionHeightScale(selfDimension, 0.5));
        timSelectorComponentController = new TimSelectorComponentController(timeSelectorComponentView, new TimeSelectorComponentModel());


        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        detailMessagePanel.add(blockPanelWidget.getMainPanel());
        detailMessagePanel.add(itemName);
        detailMessagePanel.add(blockPanelWidget0.getMainPanel());
        detailMessagePanel.add(timeSelectorComponentView.getMainPanel());

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
    }

    public static void main(String[] args) {
        AddReminderConfirmFrame addReminderConfirmFrame = new AddReminderConfirmFrame(new Dimension(500, 500));
        addReminderConfirmFrame.mainFrame.setVisible(true);
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

    public Reminder getReminderFromInput() {
        Reminder reminder = new Reminder(itemName.getText());
        illegalInputJudge();
        Timestamp timestamp = timSelectorComponentController.getTimestamp();
        if (timestamp == null)
            return null;

        reminder.setRemindTime(timestamp);
        reminder.setIsImportant(timeSelectorComponentView.getFlaggedRadio().isSelected());
        return reminder;
    }

    private void illegalInputJudge() {
        //item judge
        String content = itemName.getText();
        if (content == null || content.equals(""))
            JOptionPane.showMessageDialog(null, "Please input content");
        else if (content.length() > 30)
            JOptionPane.showMessageDialog(null, "Please input content less than 30 characters");
    }
}
