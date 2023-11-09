package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.ComponentResizeUtil;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;

public class CalendarDayWidget extends MWidget {
    Font numberFont;
    JLabel dayLabel;
    JPanel numberPanel;
    JPanel dayPanel;
    JTextArea noteArea;
    int day;
    public CalendarDayWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension, selfDimension);
    }
    public CalendarDayWidget(Dimension rootFrameDimension, Dimension selfDimension,int day){
        super(rootFrameDimension, selfDimension);
        this.day = day;
    }
    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
    }

    @Override
    protected void initializeFonts() {
        numberFont = FontUtil.getBoldFont(rootFrameDimension,0.008);
    }

    @Override
    protected void initializeJComponents() {
        dayLabel = new JLabel();
        if(day == 0){
            dayLabel.setText("");
        }
        else {
            dayLabel.setText(String.valueOf(day));
        }

        dayLabel.setFont(numberFont);
        noteArea = new JTextArea();
        noteArea.setLineWrap(true);
        noteArea.setWrapStyleWord(true);
        dayPanel = JPanelUtil.getFlowJpanel(FlowLayout.LEFT, ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,1,0.3));
        noteArea.setPreferredSize(selfDimension);
        dayPanel.add(dayLabel);
        mainPanel.add(dayPanel);
        mainPanel.add(noteArea);
    }
}
