package edu.square.views.view1.subframe;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Map;

public class AddReminderConfirmFrame {
    private final JFrame mainFrame;
    private final JTextField itemName;
    private final JButton confirmButton;

    public AddReminderConfirmFrame(Dimension selfDimension) {
        Font font = FontUtil.getBoldFont(selfDimension, 0.05);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add item");
        confirmButton = new JButton("Confirm");
        itemName = new JTextField(40);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel inputLabel = new JLabel("Reminder Content:");

        inputLabel.setFont(font);

        inputPanel.setBounds((int) (0.1 * mainFrame.getHeight()), (int) (0.2 * mainFrame.getHeight()), (int) (0.8 * mainFrame.getWidth()), (int) (0.2 * mainFrame.getWidth()));
        inputPanel.add(inputLabel);
        inputPanel.add(itemName);

        JPanel confirmPanel = new JPanel(new BorderLayout());
        confirmPanel.setBounds(50, 100, 200, 200);
        confirmButton.setSize(100, 100);

        //while input Enter will be same as click confirm button
        confirmPanel.add(confirmButton, BorderLayout.SOUTH);

        //parent frame will not close when sub frame is closed
        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        mainFrame.setAlwaysOnTop(true);
        mainFrame.add(inputPanel);
        mainFrame.add(confirmPanel);
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
}
