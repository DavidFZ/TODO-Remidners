package edu.square.views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
//每个月中每一天的panel
public class CalendarDayPanel {
    JPanel dayPanel = new JPanel();

    CalendarDayPanel(int size, String s) {
        dayPanel.setPreferredSize(new Dimension(size, (int) (0.8 * size)));
        dayPanel.setBackground(Color.WHITE);
        JLabel dayLabel = new JLabel(s);
        dayLabel.setFont(new Font("宋体", Font.BOLD, (int) (0.2 * size)));
        dayPanel.setLayout(new BorderLayout());
        dayPanel.add(dayLabel, BorderLayout.NORTH);
        JTextArea dayTextArea = new JTextArea();
        dayTextArea.setLineWrap(true);
        dayTextArea.setBorder(null);
        dayPanel.add(dayTextArea, BorderLayout.CENTER);

        dayPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ;
            }
        });
    }
}
