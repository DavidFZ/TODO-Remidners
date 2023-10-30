package edu.square.views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class CalendarFrame extends Frame {
    Frame calenderFrame = new JFrame();
    static JPanel eachDayPanel = new JPanel();
    static int month;
    //日历除了日期以外的部分
    CalendarFrame() {
        //can change size
        calenderFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        calenderFrame.setUndecorated(true);
        calenderFrame.setSize(600, 800);
        //back button
        JPanel backPanel = new JPanel();
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backPanel.setPreferredSize(new Dimension((calenderFrame.getWidth()),(int)(0.05*calenderFrame.getHeight())));
        JLabel backLabel = new JLabel("back");
        backLabel.setFont(new Font("宋体",Font.BOLD,13));
        backPanel.add(backLabel);
        //title
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension((calenderFrame.getWidth()),(int)(0.05*calenderFrame.getHeight())));
        JLabel titleLabel = new JLabel("Calender");
        titleLabel.setFont(new Font("宋体",Font.BOLD,25));
        titlePanel.add(titleLabel);

        //day of week

        //last month and next month
        JPanel lastAndNextPanel =new JPanel();
        JPanel lastPanel = new JPanel();
        JPanel nextPanel = new JPanel();
        lastAndNextPanel.setPreferredSize(new Dimension(calenderFrame.getWidth(),(int)(0.1*calenderFrame.getHeight())));
        lastAndNextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setPreferredSize(new Dimension((int)(0.48*calenderFrame.getWidth()),(int)(0.1*calenderFrame.getHeight())));
        nextPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setPreferredSize(new Dimension((int)(0.48*calenderFrame.getWidth()),(int)(0.1*calenderFrame.getHeight())));
        JLabel lastLabel = new JLabel("LAST Month");
        JLabel nextLabel = new JLabel("Next Month");
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextPanel);
        //panel of days

        JPanel dayPanel = new JPanel();
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        dayPanel.setPreferredSize(new Dimension((int)(1*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight())));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay()-1;
        month = this.GetMonth();
        eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),dayOfWeek).monthPanel;
//      eachDayPanel.setBackground(Color.GREEN);
        dayPanel.add(eachDayPanel);

        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calenderFrame.dispose();
            }
        });

        lastLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month--;
                eachDayPanel.setVisible(false);
                if(month >= 1){
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),dayOfWeek).monthPanel;
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
                if(month <= 12){
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),dayOfWeek).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }

            }
        });




        calenderFrame.add(titlePanel);
        calenderFrame.add(backPanel);
        calenderFrame.add(lastAndNextPanel);
        calenderFrame.add(dayPanel);

    }

    public int GetThisMonthFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public int GetMonth(){
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }


    public static void main(String[] args) {
        Frame frame = new CalendarFrame().calenderFrame;

        frame.setVisible(true);
        System.out.println();
    }


}

