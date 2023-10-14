package edu.square.model;

import edu.square.entity.Reminder;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.square.controller.FrameTodayController.setReminderDoneStatusAndUpdate;

public class ReminderPanelModel extends JPanel {
    private static Font font1;
    private static Font font2;
    private static Font font3;
    private final JFrame parentFrame;

    @Getter
    private final Reminder reminder;
    private JLabel label;

    @Getter
    private JRadioButton radioButton;
    private JPanel innerPanel;

    public ReminderPanelModel(Reminder reminder, final JFrame parentFrame) {
        this.reminder = reminder;
        this.parentFrame = parentFrame;
        this.innerPanel = new JPanel();


        font1 = new Font("宋体", Font.BOLD, (int) (0.05 * parentFrame.getWidth()));
        font2 = new Font("宋体", Font.BOLD, (int) (0.03 * parentFrame.getWidth()));
        font3 = new Font("宋体", Font.BOLD, (int) (0.008 * parentFrame.getWidth()));

        setLayout(new FlowLayout(FlowLayout.CENTER));
        setPreferredSize(new Dimension((int) (0.9 * parentFrame.getWidth()), (int) (0.08 * parentFrame.getHeight())));
        setBackground(Color.green);

        JPanel innerPanel = createInnerPanel();
        add(innerPanel);
    }

    private JPanel createInnerPanel() {
        innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        innerPanel.setPreferredSize(new Dimension((int) (0.85 * parentFrame.getWidth()), (int) (0.07 * parentFrame.getHeight())));
        innerPanel.setBorder(new LineBorder(Color.PINK));
        innerPanel.setBackground(Color.yellow);

        label = new JLabel(reminder.getContent());
        label.setFont(font2);

        radioButton = new JRadioButton();
        //reload done status from db
        if (reminder.getDoneTime() != null) {
            radioButton.setSelected(true);
            label.setForeground(Color.GRAY);
        } else {
            radioButton.setSelected(false);
            label.setForeground(Color.black);
        }
        radioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (radioButton.isSelected()) {
                    label.setForeground(Color.GRAY);
                    setReminderDoneStatusAndUpdate(reminder, true);
                } else {
                    label.setForeground(Color.black);
                    setReminderDoneStatusAndUpdate(reminder, false);
                }
            }
        });

        innerPanel.add(radioButton);
        innerPanel.add(label);

        return innerPanel;
    }

    // Add any other methods or operations related to this panel here
}
