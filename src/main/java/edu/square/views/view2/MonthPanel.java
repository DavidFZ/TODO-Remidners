package edu.square.views.view2;

import javax.swing.*;
import java.awt.*;

//对于某一个月的panel
public class MonthPanel {
    public JPanel monthPanel = new JPanel();
    JPanel monthNamePanel = new JPanel();
    JPanel weekOfDayPanel = new JPanel();
    JPanel monthDayPanel = new JPanel();

    JLabel monthNameLabel = new JLabel();
    int width,height;
    public MonthPanel(int i, int width, int heigh, int day){
        this.width = width;
        this.height = heigh;
        monthPanel.setPreferredSize(new Dimension((int)width,(int)heigh));
        monthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        monthNamePanel.setPreferredSize(new Dimension((int)(width),(int)(0.1*heigh)));
        monthDayPanel.setBackground(new Color(198,230,232));
        if(i == 1){
            monthNameLabel.setText("January");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 2){
            monthNameLabel.setText("February");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 3){
            monthNameLabel.setText("March");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 4){
            monthNameLabel.setText("April");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 5){
            monthNameLabel.setText("May");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 6){
            monthNameLabel.setText("Jun");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 7){
            monthNameLabel.setText("July");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 8){
            monthNameLabel.setText("August");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 9){
            monthNameLabel.setText("September");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 10){
            monthNameLabel.setText("October");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 11){
            monthNameLabel.setText("November");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 12){
            monthNameLabel.setText("December");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        monthNamePanel.setBackground(new Color(198,230,232));
        monthPanel.add(monthNamePanel);


        weekOfDayPanel.setPreferredSize(new Dimension(new Dimension((int)(width),(int)(0.06*heigh))));
        weekOfDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel SundayPanel = new JPanel();
        SundayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel SundayLabel = new JLabel("Sunday");
        SundayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        SundayPanel.add(SundayLabel);
        SundayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(SundayPanel);

        JPanel MondayPanel = new JPanel();
        MondayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel MondayLabel = new JLabel("Monday");
        MondayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        MondayPanel.add(MondayLabel);
        MondayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(MondayPanel);

        JPanel TuesdayPanel = new JPanel();
        TuesdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel TuesdayLabel = new JLabel("Tuesday");
        TuesdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        TuesdayPanel.add(TuesdayLabel);
        TuesdayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(TuesdayPanel);

        JPanel WednesdayPanel = new JPanel();
        WednesdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel WednesdayLabel = new JLabel("Wednesday");
        WednesdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        WednesdayPanel.add(WednesdayLabel);
        WednesdayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(WednesdayPanel);

        JPanel ThursdayPanel = new JPanel();
        ThursdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel ThursdayLabel = new JLabel("Thursday");
        ThursdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        ThursdayPanel.add(ThursdayLabel);
        ThursdayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(ThursdayPanel);

        JPanel FridayPanel = new JPanel();
        FridayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel FridayLabel = new JLabel("Friday");
        FridayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        FridayPanel.add(FridayLabel);
        FridayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(FridayPanel);

        JPanel SaturdayPanel = new JPanel();
        SaturdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel SaturdayLabel = new JLabel("Saturday");
        SaturdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        SaturdayPanel.add(SaturdayLabel);
        SaturdayPanel.setBackground(new Color(198,230,232));
        weekOfDayPanel.add(SaturdayPanel);

        weekOfDayPanel.setBackground(new Color(198,230,232));
        monthPanel.add(weekOfDayPanel);



        monthDayPanel.setPreferredSize(new Dimension((int)width,(int)(heigh)));
        monthDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        monthDayPanel.setBackground(Color.BLUE);
        if(day == 7){
            day = 0;
        }
        for(int k = 0; k < day; k++){
            JPanel blankPanel = new JPanel();
            blankPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(width/7.5)));
            monthDayPanel.add(blankPanel);
        }
        if(i == 1 || i== 3 || i==5 || i == 7 || i == 8 || i == 10 || i == 12){
            for(int j = 1; j < 32 ; j++){
                String s = String.valueOf(j);
                JPanel J = new CalendarDayPanel((int)(width/7.5),s).dayPanel;
                monthDayPanel.add(J);
            }
        }
        else if(i == 2){
            for(int j = 1; j < 29 ; j++){
                String s = String.valueOf(j);
                JPanel J = new CalendarDayPanel((int)(width/7.5),s).dayPanel;
                monthDayPanel.add(J);
            }
        }
        else{
            for(int j = 1; j < 31 ; j++){
                String s = String.valueOf(j);
                JPanel J = new CalendarDayPanel((int)(width/7.5),s).dayPanel;
                monthDayPanel.add(J);
            }
        }
        monthDayPanel.setBackground(new Color(198,230,232));
        monthPanel.setBackground(new Color(198,230,232));
        monthPanel.add(monthDayPanel);


    }

//    public JPanel nextMonth(int i,int j){
//        JPanel m = new MonthPanel(i + 1,width,height,j + 2).monthPanel;
//        return m;
//    }



    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1000,1000);
        JPanel j = new MonthPanel(3,600,800,6).monthPanel;
        f.add(j);
        f.setVisible(true);
    }
}

