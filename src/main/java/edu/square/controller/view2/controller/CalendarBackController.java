package edu.square.controller.view2.controller;

import edu.square.views.view2.view.CalendarPanel;
import edu.square.views.view2.view.CalendarPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalendarBackController {
    private CalendarPanel c;
    public CalendarBackController(CalendarPanel calendarPanel){
        this.c = calendarPanel;
        initialize();
    }

    public void initialize(){
        backButton();
    }

    public void backButton(){
        c.GetBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.calenderPanel.setVisible(false);
            }
        });
    }
}
