package edu.square.views.view2.controller;

import edu.square.views.view2.view.CalendarFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalendarBackController {
    private CalendarFrame c;
    public CalendarBackController(CalendarFrame calendarFrame){
        this.c = calendarFrame;
        initialize();
    }

    public void initialize(){
        backButton();
    }

    public void backButton(){
        c.GetBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.calenderFrame.dispose();
            }
        });
    }
}
