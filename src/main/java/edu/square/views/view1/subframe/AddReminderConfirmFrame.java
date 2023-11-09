package edu.square.views.view1.subframe;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.view1.widget.TextFieldPanelWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class AddReminderConfirmFrame {
    private final JFrame mainFrame;
    private final JTextField itemName;
    private final JButton confirmButton;
    private JRadioButton flagRadio;
    private JRadioButton importRadio;

    public AddReminderConfirmFrame(Dimension selfDimension) {
        Font font = FontUtil.getBoldFont(selfDimension, 0.05);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add item");
        mainFrame.setLayout(new BorderLayout());

        BlockPanelWidget blockPanelView = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.3));


        //inputPanel
        JLabel inputLabel = new JLabel("Reminder Content:");
        inputLabel.setFont(font);
        JLabel tipsLabel = new JLabel("Deadline:");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension,0.8,0.05));
        inputLabel.setFont(font);
        itemName = new JTextField(30);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        flagRadio = new JRadioButton("flagged");
        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        detailMessagePanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension.getSize(), 0.8, 0.1));
        detailMessagePanel.add(flagRadio);
        TextFieldPanelWidget yearsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension,resizeDimensionWidthAndHeight(selfDimension,0.45,0.05),"years:");
        TextFieldPanelWidget monthsTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension,resizeDimensionWidthAndHeight(selfDimension,0.45,0.05),"months:");
        TextFieldPanelWidget datesTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension,resizeDimensionWidthAndHeight(selfDimension,0.45,0.05),"dates:");
        TextFieldPanelWidget hoursTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension,resizeDimensionWidthAndHeight(selfDimension,0.45,0.05),"hours:");


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
}
