package edu.square.views;

import javax.swing.*;
import java.awt.*;
//对于某一个月的panel
public class MonthPanel {
    JPanel monthPanel = new JPanel();
    MonthPanel(int i,int width,int heigh,int day){
        monthPanel.setPreferredSize(new Dimension((int)width,(int)heigh));
        monthPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        JPanel monthNamePanel = new JPanel();
        monthNamePanel.setPreferredSize(new Dimension((int)(width),(int)(0.1*heigh)));

        if(i == 1){
            JLabel monthNameLabel = new JLabel("January");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 2){
            JLabel monthNameLabel = new JLabel("February");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 3){
            JLabel monthNameLabel = new JLabel("March");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 4){
            JLabel monthNameLabel = new JLabel("April");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 5){
            JLabel monthNameLabel = new JLabel("May");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 6){
            JLabel monthNameLabel = new JLabel("Jun");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 7){
            JLabel monthNameLabel = new JLabel("July");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 8){
            JLabel monthNameLabel = new JLabel("August");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 9){
            JLabel monthNameLabel = new JLabel("September");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 10){
            JLabel monthNameLabel = new JLabel("October");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 11){
            JLabel monthNameLabel = new JLabel("November");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        if(i == 12){
            JLabel monthNameLabel = new JLabel("December");
            monthNameLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.05*width)));
            monthNamePanel.add(monthNameLabel);
        }
        monthPanel.add(monthNamePanel);


        JPanel weekOfDayPanel = new JPanel();
        weekOfDayPanel.setPreferredSize(new Dimension(new Dimension((int)(width),(int)(0.06*heigh))));
        weekOfDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JPanel SundayPanel = new JPanel();
        SundayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel SundayLabel = new JLabel("Sunday");
        SundayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        SundayPanel.add(SundayLabel);
        weekOfDayPanel.add(SundayPanel);

        JPanel MondayPanel = new JPanel();
        MondayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel MondayLabel = new JLabel("Monday");
        MondayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        MondayPanel.add(MondayLabel);
        weekOfDayPanel.add(MondayPanel);

        JPanel TuesdayPanel = new JPanel();
        TuesdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel TuesdayLabel = new JLabel("Tuesday");
        TuesdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        TuesdayPanel.add(TuesdayLabel);
        weekOfDayPanel.add(TuesdayPanel);

        JPanel WednesdayPanel = new JPanel();
        WednesdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel WednesdayLabel = new JLabel("Wednesday");
        WednesdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        WednesdayPanel.add(WednesdayLabel);
        weekOfDayPanel.add(WednesdayPanel);

        JPanel ThursdayPanel = new JPanel();
        ThursdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel ThursdayLabel = new JLabel("Thursday");
        ThursdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        ThursdayPanel.add(ThursdayLabel);
        weekOfDayPanel.add(ThursdayPanel);

        JPanel FridayPanel = new JPanel();
        FridayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel FridayLabel = new JLabel("Friday");
        FridayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        FridayPanel.add(FridayLabel);
        weekOfDayPanel.add(FridayPanel);

        JPanel SaturdayPanel = new JPanel();
        SaturdayPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.06*heigh)));
        JLabel SaturdayLabel = new JLabel("Saturday");
        SaturdayLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.02*width)));
        SaturdayPanel.add(SaturdayLabel);
        weekOfDayPanel.add(SaturdayPanel);


        monthPanel.add(weekOfDayPanel);


        JPanel monthDayPanel = new JPanel();
        monthDayPanel.setPreferredSize(new Dimension((int)width,(int)(heigh)));
        monthDayPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
//        monthDayPanel.setBackground(Color.BLUE);
        for(int k = 0; k < day; k++){
            JPanel blankPanel = new JPanel();
            blankPanel.setPreferredSize(new Dimension((int)(width/7.5),(int)(0.8*width/7.5)));
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

        monthPanel.add(monthDayPanel);

    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.setSize(1000,1000);
        JPanel j = new MonthPanel(3,600,800,6).monthPanel;
        f.add(j);
        f.setVisible(true);
    }
}

