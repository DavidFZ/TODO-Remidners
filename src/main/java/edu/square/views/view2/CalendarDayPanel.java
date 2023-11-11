package edu.square.views.view2;

import edu.square.entity.Reminder;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.util.List;

//每个月中每一天的panel
public class CalendarDayPanel {
    JTextArea dayTextArea = new JTextArea();
    private final JPanel dayPanel = new JPanel();
    private final JLabel dayLabel = new JLabel();
    @Getter
    @Setter
    private List<Reminder> todayReminderList;

    CalendarDayPanel(int size, String s) {
        dayPanel.setPreferredSize(new Dimension(size, size));
        dayPanel.setBackground(Color.WHITE);
        dayLabel.setText(s);
        dayLabel.setFont(new Font("宋体", Font.BOLD, (int) (0.2 * size)));
        dayPanel.setLayout(new BorderLayout());
        dayPanel.add(dayLabel, BorderLayout.NORTH);

        JLabel jLabel = new JLabel();
        jLabel.setForeground(new Color(92, 179, 204));

        JPanel heightPanel = new JPanel();
        heightPanel.setPreferredSize(new Dimension(size, ((int) (0.15 * size))));
        heightPanel.setBackground(new Color(216, 227, 231));
        JPanel mainPanel = new JPanel();
        mainPanel.setPreferredSize(new Dimension(size, ((int) (0.75 * size))));
        mainPanel.setBackground(new Color(216, 227, 231));
        jLabel.setFont(new Font("宋体", Font.BOLD, (int) (0.4 * size)));

        JPanel notePanel = new JPanel();
        notePanel.setBackground(new Color(216, 227, 231));
        notePanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(jLabel);
        notePanel.add(heightPanel);
        notePanel.add(mainPanel);
        dayPanel.add(notePanel);


//        dayTextArea.setLineWrap(true);
//        dayTextArea.setBorder(null);
//        dayPanel.add(dayTextArea, BorderLayout.CENTER);
    }

    public void addMouseListener(MouseAdapter mouseAdapter) {
        dayPanel.addMouseListener(mouseAdapter);
    }

    public void setDayLabel(String s) {
        dayLabel.setText(s);
    }

    public JPanel getDayPanel() {
        return dayPanel;
    }
}
