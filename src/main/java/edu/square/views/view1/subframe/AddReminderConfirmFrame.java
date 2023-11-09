package edu.square.views.view1.subframe;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.view1.widget.BlockPanelWidget;

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
        itemName = new JTextField(40);
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        inputPanel.setBounds((int) (0.1 * mainFrame.getHeight()), (int) (0.2 * mainFrame.getHeight()), (int) (0.8 * mainFrame.getWidth()), (int) (0.2 * mainFrame.getWidth()));
        flagRadio = new JRadioButton("flagged");
        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        detailMessagePanel.setPreferredSize(resizeDimensionWidthAndHeight(inputPanel.getSize(), 0.9, 0.5));
        detailMessagePanel.add(flagRadio);
        inputPanel.add(inputLabel);
        inputPanel.add(itemName);
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
