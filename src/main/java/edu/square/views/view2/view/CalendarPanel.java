package edu.square.views.view2.view;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view.MyView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;

public class CalendarPanel extends JPanel {
    public JPanel calenderPanel = new JPanel();
    JPanel backPanel = new JPanel();//back function
    JPanel titlePanel = new JPanel();
    JPanel lastAndNextPanel = new JPanel();
    JPanel lastPanel = new JPanel();
    JPanel nextPanel = new JPanel();
    JLabel lastLabel = new JLabel("Last Month");
    JLabel nextLabel = new JLabel("Next Month");

    JLabel backLabel = new JLabel("back");

    public static int month;

    public static JPanel eachDayPanel = new JPanel();

    public JPanel dayPanel = new JPanel();

    //日历除了日期以外的部分
    CalendarPanel(Dimension dimension) {
        //can change size
        calenderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        calenderPanel.setSize(dimension);
        //back button
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backPanel.setPreferredSize(new Dimension((calenderPanel.getWidth()), (int) (0.05 * calenderPanel.getHeight())));
        backLabel.setFont(new Font("宋体", Font.BOLD, 13));
        backPanel.add(backLabel);
        //title
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension((calenderPanel.getWidth()), (int) (0.05 * calenderPanel.getHeight())));
        JLabel titleLabel = new JLabel("Calender");
        titleLabel.setFont(new Font("宋体", Font.BOLD, 25));
        titlePanel.add(titleLabel);

        //last month and next month
        lastAndNextPanel.setPreferredSize(new Dimension(calenderPanel.getWidth(), (int) (0.1 * calenderPanel.getHeight())));
        lastAndNextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setPreferredSize(new Dimension((int) (0.48 * calenderPanel.getWidth()), (int) (0.1 * calenderPanel.getHeight())));
        nextPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setPreferredSize(new Dimension((int) (0.48 * calenderPanel.getWidth()), (int) (0.1 * calenderPanel.getHeight())));
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextPanel);
        //panel of days
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dayPanel.setPreferredSize(new Dimension((int) (1 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight())));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay() - 1;
        month = this.GetMonth();
        eachDayPanel = new MonthPanel(month, (int) (0.98 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight()), dayOfWeek).monthPanel;
//      eachDayPanel.setBackground(Color.GREEN);
        dayPanel.add(eachDayPanel);

//        backLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                calenderFrame.dispose();
//            }
//        });

        lastLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month--;
                eachDayPanel.setVisible(false);
                Calendar calendar = Calendar.getInstance();
                int day;
                if (month >= 1) {
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                } else {
                    month = 12;
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }
            }
        });
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month++;
                eachDayPanel.setVisible(false);
                Calendar calendar = Calendar.getInstance();
                int day;
                if (month <= 12) {
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                } else {
                    month = 1;
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * calenderPanel.getWidth()), (int) (0.8 * calenderPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }

            }
        });


        calenderPanel.add(titlePanel);
        calenderPanel.add(backPanel);
        calenderPanel.add(lastAndNextPanel);
        calenderPanel.add(dayPanel);

    }

    public int GetThisMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public int GetMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public JLabel GetBackButton() {
        return this.backLabel;
    }

    public JLabel GetLastButton() {
        return this.lastLabel;
    }

    public JLabel GetNextButton() {
        return this.nextLabel;
    }

    public JPanel getCalenderPanel() {
        return this.calenderPanel;
    }


    public static void main(String[] args) {


//        Dimension dimension = new Dimension(1000,1000);
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        JPanel jPanel = new CalendarPanel(mainFrame.getSize()).calenderPanel;
//        JFrame frame = new JFrame();
        mainFrame.add(jPanel);
        mainFrame.setVisible(true);
        System.out.println();

//        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
//        CalendarPanel calendarPanel = new CalendarPanel(mainFrame.getSize());
//        JPanel jPanel1 = new CalendarPanel(dimension).calenderPanel;
//        mainFrame.add(jPanel1);
//        mainFrame.setVisible(true);
    }


}

