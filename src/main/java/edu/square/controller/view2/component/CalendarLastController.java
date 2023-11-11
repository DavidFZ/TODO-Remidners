package edu.square.controller.view2.component;

import edu.square.views.view2.CalenderPanelWidget;
import edu.square.views.view2.MonthPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

public class CalendarLastController {
    private final CalenderPanelWidget c;
    public CalendarLastController(CalenderPanelWidget c){
        this.c = c;
        initialize();
    }

    private void initialize() {
        bindButton();
    }

    private void bindButton() {
        c.GetLastButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.month--;
                c.eachDayPanel.setVisible(false);
                Calendar calendar = Calendar.getInstance();
                int day;
                if (c.month < 1) {
                    c.month = 12;
                }
                calendar.set(calendar.get(Calendar.YEAR),c.month-1,1);
                day = calendar.get(Calendar.DAY_OF_WEEK);
                c.eachDayPanel = new MonthPanel(c.month,(int)(0.98*c.getmainPanel().getWidth()),(int)(0.8*c.getmainPanel().getHeight()),day-1).getMonthDayPanel();
                c.eachDayPanel.setVisible(true);
                c.dayPanel.add(c.eachDayPanel);
            }
        });
    }
}
