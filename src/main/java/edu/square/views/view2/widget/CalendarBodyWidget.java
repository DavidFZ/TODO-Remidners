package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.ComponentResizeUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class CalendarBodyWidget extends MWidget {
    int firstDay;
    int month;

    int totalDay;

    public CalendarBodyWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension, selfDimension);
    }
    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
    }

    @Override
    protected void initializeFonts() {
    }

    @Override
    protected void initializeJComponents() {
        firstDay = this.getFirstDay();
        month = this.getMonth();
        totalDay = this.getTotalDay();
        //month name
        MonthNameWidget monthNameWidget = new MonthNameWidget(selfDimension, ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,1,0.2));
        monthNameWidget.changeMonth(month);
        monthNameWidget.changeLabelOfMonth();
        JPanel monthNamePanel = monthNameWidget.getMainPanel();
        //day of week
        Dimension dayOfWeekPanelDimension = ComponentResizeUtil.resizeDimensionHeightScale(selfDimension,0.15);
        Dimension eachDayOfWeekDimension = ComponentResizeUtil.resizeDimensionWidthScale(dayOfWeekPanelDimension,1/7);
        JPanel dayOfWeekPanel = new JPanel();
        dayOfWeekPanel.setPreferredSize(dayOfWeekPanelDimension);
        dayOfWeekPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        for(int i = 0; i < 7; i++){
            WeekOfDayWidget weekOfDayWidget =new WeekOfDayWidget(dayOfWeekPanelDimension,eachDayOfWeekDimension);
            weekOfDayWidget.setDay(i);
            weekOfDayWidget.changeDay();
            JPanel eachDayOdWeekPanel = weekOfDayWidget.getMainPanel();
            dayOfWeekPanel.add(eachDayOdWeekPanel);
        }

        //
        Dimension eachDayPanelDimension = ComponentResizeUtil.resizeDimensionHeightScale(selfDimension,0.6);
        JPanel eachDayPanel = new JPanel();
        eachDayPanel.setPreferredSize(eachDayPanelDimension);
        if(firstDay > 0){
            for(int i = 0;i<firstDay;i++){
                JPanel calendarDayPanel = new CalendarDayWidget(eachDayPanelDimension,ComponentResizeUtil.resizeDimensionWidthAndHeight(eachDayPanelDimension,1/7,1/7)).getMainPanel();
                eachDayPanel.add(calendarDayPanel);
            }
        }
        for(int i = 1; i < totalDay; i++){
            JPanel calendarDayPanel = new CalendarDayWidget(eachDayPanelDimension,ComponentResizeUtil.resizeDimensionWidthAndHeight(eachDayPanelDimension,1/7,1/7),i).getMainPanel();
            eachDayPanel.add(calendarDayPanel);
        }
    }

    public int getFirstDay(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH,1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public int getMonth(){
        Calendar calendar = Calendar.getInstance();
        int month = calendar.get(Calendar.MONTH) + 1;
        return month;
    }

    public int getTotalDay(){
        Calendar calendar = Calendar.getInstance();
        int number = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
        return number;
    }
}
