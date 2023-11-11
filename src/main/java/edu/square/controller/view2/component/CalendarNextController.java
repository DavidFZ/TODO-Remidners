package edu.square.controller.view2.component;

import edu.square.views.view2.CalenderPanelWidget;
import edu.square.views.view2.MonthPanelWidget;

import java.util.Calendar;

public class CalendarNextController {
    private final CalenderPanelWidget c;
    public CalendarNextController(CalenderPanelWidget c){
        this.c = c;
        initialize();
    }

    private void initialize() {
        bindButton();
    }

    private void bindButton() {
        c.month++;
        c.currentMonthPanel.setVisible(false);
        Calendar calendar = Calendar.getInstance();
        int day;
        if(c.month <= 12){
            calendar.set(calendar.get(Calendar.YEAR),c.month-1,1);
            day = calendar.get(Calendar.DAY_OF_WEEK);
            c.currentMonthPanel = new MonthPanelWidget(c.month,(int)(0.98*c.getmainPanel().getWidth()),(int)(0.8*c.getmainPanel().getHeight()),day-1).getMonthDayPanel();
            c.currentMonthPanel.setVisible(true);
            c.dayPanel.add(c.currentMonthPanel);
        }
        else {
            c.month = 1;
            calendar.set(calendar.get(Calendar.YEAR),c.month-1,1);
            day = calendar.get(Calendar.DAY_OF_WEEK);
            c.currentMonthPanel = new MonthPanelWidget(c.month,(int)(0.98*c.getmainPanel().getWidth()),(int)(0.8*c.getmainPanel().getHeight()),day-1).getMonthDayPanel();
            c.currentMonthPanel.setVisible(true);
            c.dayPanel.add(c.currentMonthPanel);
        }
    }

}
