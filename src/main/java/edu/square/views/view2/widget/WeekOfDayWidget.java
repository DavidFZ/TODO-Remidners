package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;

public class WeekOfDayWidget extends MWidget {
    Font font;
    int day;
    JPanel mainPanel;
    JLabel dayName;

    WeekOfDayWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension,selfDimension);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(rootFrameDimension,0.03);
    }

    @Override
    protected void initializeJComponents() {
        dayName.setFont(font);
        mainPanel.add(dayName);
    }

    public void setDay(int d){
        day = d;
    }

    public void changeDay(){
        if(day == 1){
            dayName.setText("Monday");
        }
        else if (day == 2) {
            dayName.setText("Tuesday");
        }
        else if (day == 3) {
            dayName.setText("Wednesday");
        }
        else if(day == 4){
            dayName.setText("Thursday");
        }
        else if(day == 5){
            dayName.setText("Friday");
        }
        else if(day == 6){
            dayName.setText("Saturday");
        }
        else if(day == 0){
            dayName.setText("Sunday");
        }
    }
}
