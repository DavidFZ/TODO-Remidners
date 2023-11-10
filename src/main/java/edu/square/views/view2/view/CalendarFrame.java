package edu.square.views.view2.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class CalendarFrame extends Frame {
    public Frame calenderFrame = new JFrame();
    JPanel backPanel = new JPanel();//back function
    JPanel titlePanel = new JPanel();
    JPanel lastAndNextPanel =new JPanel();
    JPanel lastPanel = new JPanel();
    JPanel nextPanel = new JPanel();
    JLabel lastLabel = new JLabel("Last Month");
    JLabel nextLabel = new JLabel("Next Month");

    JLabel backLabel = new JLabel("back");

    public static int month;

    public static JPanel eachDayPanel = new JPanel();

    public JPanel dayPanel = new JPanel();
    //日历除了日期以外的部分
    CalendarFrame(Dimension dimension) {
        //can change size
        calenderFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        calenderFrame.setSize(dimension);
        //back button
        backPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        backPanel.setPreferredSize(new Dimension((calenderFrame.getWidth()),(int)(0.05*calenderFrame.getHeight())));
        backLabel.setFont(new Font("宋体",Font.BOLD,13));
        backPanel.add(backLabel);
        //title
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(new Dimension((calenderFrame.getWidth()),(int)(0.05*calenderFrame.getHeight())));
        JLabel titleLabel = new JLabel("Calender");
        titleLabel.setFont(new Font("宋体",Font.BOLD,25));
        titlePanel.add(titleLabel);

        //last month and next month
        lastAndNextPanel.setPreferredSize(new Dimension(calenderFrame.getWidth(),(int)(0.1*calenderFrame.getHeight())));
        lastAndNextPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setPreferredSize(new Dimension((int)(0.48*calenderFrame.getWidth()),(int)(0.1*calenderFrame.getHeight())));
        nextPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setPreferredSize(new Dimension((int)(0.48*calenderFrame.getWidth()),(int)(0.1*calenderFrame.getHeight())));
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextPanel);
        //panel of days
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
        dayPanel.setPreferredSize(new Dimension((int)(1*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight())));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay()-1;
        month = this.GetMonth();
        eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),dayOfWeek).monthPanel;
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
                if(month >= 1){
                    calendar.set(calendar.get(Calendar.YEAR),month-1,1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),day-1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }
                else{
                    month = 12;
                    calendar.set(calendar.get(Calendar.YEAR),month-1,1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),day-1).monthPanel;
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
                if(month <= 12){
                    calendar.set(calendar.get(Calendar.YEAR),month-1,1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),day-1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }
                else {
                    month = 1;
                    calendar.set(calendar.get(Calendar.YEAR),month-1,1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month,(int)(0.98*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight()),day-1).monthPanel;
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

    public JLabel GetBackButton(){
        return this.backLabel;
    }

    public JLabel GetLastButton(){
        return this.lastLabel;
    }

    public JLabel GetNextButton(){
        return this.nextLabel;
    }


    public static void main(String[] args) {
        Dimension dimension = new Dimension(500,900);
        Frame frame = new CalendarFrame(dimension).calenderFrame;

        frame.setVisible(true);
        System.out.println();
    }


}

