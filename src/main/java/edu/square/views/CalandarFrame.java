package edu.square.views;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Locale;

public class CalandarFrame extends Frame {
    Frame calenderFrame = new JFrame();
    //日历除了日期以外的部分
    CalandarFrame() {
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
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        dayPanel.setPreferredSize(new Dimension((int)(1*calenderFrame.getWidth()),(int)(0.8*calenderFrame.getHeight())));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay();
        LocalDate currentDate = LocalDate.now();
        int month = currentDate.getMonthValue();
        JPanel eachDayPanel = this.getThisMonthPanel(month,dayOfWeek);
        dayPanel.add(eachDayPanel);
        int firstDayOfLastMonthNumber = this.GetEveryMonthFirstDay(month - 1);
        int firstDayOfNextMonthNumber = this.GetEveryMonthFirstDay(month + 1);

        backLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calenderFrame.dispose();
            }
        });

        lastLabel.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(firstDayOfLastMonthNumber >= 0){
                    dayPanel.removeAll();
                    dayPanel.revalidate();
                    System.out.println("click");
                    JPanel lastMonthPanel = new MonthPanel(month-1,(int) (0.98 * calenderFrame.getWidth()), (int) (0.8 * calenderFrame.getHeight()), firstDayOfLastMonthNumber).monthPanel;
                    dayPanel.add(lastMonthPanel);

                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
            }
            @Override
            public void mouseReleased(MouseEvent e) {
            }
            @Override
            public void mouseEntered(MouseEvent e) {
            }
            @Override
            public void mouseExited(MouseEvent e) {
            }
        });

        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(firstDayOfNextMonthNumber >= 0){
                    eachDayPanel.setVisible(false);
                    JPanel lastMonthPanel = new MonthPanel(month+1,(int) (0.98 * calenderFrame.getWidth()), (int) (0.8 * calenderFrame.getHeight()), firstDayOfNextMonthNumber).monthPanel;
                    dayPanel.add(lastMonthPanel);

                }
            }
        });



        calenderFrame.add(titlePanel);
        calenderFrame.add(backPanel);
        calenderFrame.add(lastAndNextPanel);
        calenderFrame.add(dayPanel);
        calenderFrame.setVisible(true);

    }

    public JPanel getThisMonthPanel(int i, int day){
        JPanel monthPanel = new JPanel();
        monthPanel = new MonthPanel(i, (int) (0.98 * calenderFrame.getWidth()), (int) (0.8 * calenderFrame.getHeight()), day).monthPanel;
        return monthPanel;
    }

    public int GetThisMonthFirstDay(){
        Calendar calender = Calendar.getInstance();
        calender.set(Calendar.DAY_OF_MONTH,1);
        return calender.get(Calendar.DAY_OF_WEEK) - 1;
    }

    public int GetEveryMonthFirstDay(int i){
        int result = 0;
        if(i == 1 || i == 10){
            return result;
        }
        else if(i == 2 || i == 3 || i==11){
            result = 3;
            return result;
        }
        else if(i == 4 || i == 7){
            result = 6;
            return result;
        }
        else if(i == 5){
            result = 1;
            return result;
        }
        else if(i == 6){
            result = 4;
            return result;
        }
        else if(i == 8){
            result = 2;
            return result;
        }
        else if(i == 12 || i == 9){
            result = 5;
            return result;
        }
        else{
            return -1;
        }
    }

    public static void main(String[] args) {
        Frame frame = new CalandarFrame().calenderFrame;

        frame.setVisible(true);
        System.out.println();
    }


}