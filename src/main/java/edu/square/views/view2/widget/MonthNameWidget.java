package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;



public class MonthNameWidget extends MWidget {
    JLabel monthLabel;
    Font monthFont;
    int month;
    MonthNameWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension,selfDimension);
    }
    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    }

    @Override
    protected void initializeFonts() {
        monthFont = FontUtil.getBoldFont(rootFrameDimension,0.05);
    }

    @Override
    protected void initializeJComponents() {
        monthLabel.setFont(monthFont);
        mainPanel.add(monthLabel);
    }

    public void changeMonth(int i){
        month = i;
    }

    public void changeLabelOfMonth(){
        if(month == 1){
            monthLabel.setText("January");
        }
        else if(month == 2){
            monthLabel.setText("February");
        }
        else if(month == 3){
            monthLabel.setText("March");
        }
        else if(month == 4){
            monthLabel.setText("April");
        }
        else if(month == 5){
            monthLabel.setText("May");
        }
        else if(month == 6){
            monthLabel.setText("June");
        }
        else if(month == 7){
            monthLabel.setText("July");
        }
        else if(month == 8){
            monthLabel.setText("August");
        }
        else if(month == 9){
            monthLabel.setText("September");
        }
        else if(month == 10){
            monthLabel.setText("October");
        }
        else if(month == 11){
            monthLabel.setText("November");
        }
        else if(month == 12){
            monthLabel.setText("December");
        }
    }
}
