package edu.square.views.view2;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

//对于某一个月的panel
public class MonthPanel {
    private JPanel monthPanel = new JPanel();
    JPanel monthNamePanel = new JPanel();
    JPanel weekOfDayPanel = new JPanel();
    JPanel monthDayPanel = new JPanel();
    @Getter
    private List<CalendarDayPanel> calendarDayPanelList;

    JLabel monthNameLabel = new JLabel();
    int width, height;

    public MonthPanel(int i, int width, int height, int blockDay) {//i表示月份，1基
        this.width = width;
        this.height = height;
        monthPanel.setPreferredSize(new Dimension((int) width, (int) height));
        monthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        monthNamePanel.setPreferredSize(new Dimension((int) (width), (int) (0.1 * height)));
        monthDayPanel.setBackground(new Color(198, 230, 232));
        String[] months = {
                "January", "February", "March", "April", "May", "Jun", "July", "August", "September", "October", "November", "December"
        };
        monthNameLabel.setText(months[i - 1]);
        monthNameLabel.setFont(new Font("宋体", Font.BOLD, (int) (0.05 * width)));
        monthNamePanel.add(monthNameLabel);
        monthNamePanel.setBackground(new Color(198, 230, 232));
        monthPanel.add(monthNamePanel);

        weekOfDayPanel.setPreferredSize(new Dimension(new Dimension((int) (width), (int) (0.06 * height))));
        weekOfDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        String[] weekdays = {
                "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday",
        };

        for (String weekdayText : weekdays) {
            JPanel SundayPanel = new JPanel();
            SundayPanel.setPreferredSize(new Dimension((int) (width / 7.5), (int) (0.06 * height)));
            JLabel SundayLabel = new JLabel(weekdayText);
            SundayLabel.setFont(new Font("宋体", Font.BOLD, (int) (0.02 * width)));
            SundayPanel.add(SundayLabel);
            SundayPanel.setBackground(new Color(198, 230, 232));
            weekOfDayPanel.add(SundayPanel);
        }
        weekOfDayPanel.setBackground(new Color(198, 230, 232));
        monthPanel.add(weekOfDayPanel);


        monthDayPanel.setPreferredSize(new Dimension((int) width, (int) (height)));
        monthDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        monthDayPanel.setBackground(Color.BLUE);
        if (blockDay == 7) {
            blockDay = 0;
        }
        for (int k = 0; k < blockDay; k++) {
            JPanel blankPanel = new JPanel();
            blankPanel.setPreferredSize(new Dimension((int) (width / 7.5), (int) (width / 7.5)));
            monthDayPanel.add(blankPanel);
        }

        int days;
        if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i == 10 || i == 12) {
            days = 31;
        } else if (i == 2) {
            days = 29;
        } else {
            days = 30;
        }

        //add days into monthDayPanel
        for (int j = 1; j <= days; j++) {
            String s = String.valueOf(j);
            CalendarDayPanel calendarDayPanel = new CalendarDayPanel((int) (width / 7.5), s);
            calendarDayPanelList = new ArrayList<CalendarDayPanel>();
            calendarDayPanelList.add(calendarDayPanel);
            monthDayPanel.add(calendarDayPanel.getDayPanel());
        }

        monthDayPanel.setBackground(new Color(198, 230, 232));
        monthPanel.setBackground(new Color(198, 230, 232));
        monthPanel.add(monthDayPanel);


    }

//    public JPanel nextMonth(int i,int j){
//        JPanel m = new MonthPanel(i + 1,width,height,j + 2).monthPanel;
//        return m;
//    }


    public JPanel getMonthDayPanel() {
        return monthDayPanel;
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1000, 1000);
        JPanel j = new MonthPanel(3, 600, 800, 6).monthPanel;
        f.add(j);
        f.setVisible(true);
    }
}

