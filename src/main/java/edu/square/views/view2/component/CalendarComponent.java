package edu.square.views.view2.component;

import edu.square.utils.UIUtils.ComponentResizeUtil;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view2.widget.CalendarBodyWidget;
import edu.square.views.view2.widget.CalendarFunctionWidget;
import edu.square.views.view2.widget.CalendarTitleWidget;

import javax.swing.*;
import java.awt.*;

public class CalendarComponent extends MComponent {
    CalendarComponent(Dimension parentDimension, MyView myView){
        super(myView,parentDimension);
    }
    @Override
    protected void calculateSelfDimension() {
        selfDimension = ComponentResizeUtil.resizeDimensionScale(parentDimension,0.99);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = JPanelUtil.getCenterFlowMainPanel(selfDimension);

    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {
        Dimension titleDimension = ComponentResizeUtil.resizeDimensionHeightScale(selfDimension,0.2);
        JPanel titlePanel = new CalendarTitleWidget(selfDimension,titleDimension).getMainPanel();

        Dimension functionDimension = ComponentResizeUtil.resizeDimensionHeightScale(selfDimension,0.2);
        JPanel functionPanel = new CalendarFunctionWidget(selfDimension,functionDimension).getMainPanel();

        Dimension calendarBodyWidget = ComponentResizeUtil.resizeDimensionHeightScale(selfDimension,0.55);
        JPanel calendarBodyPanel = new CalendarBodyWidget(selfDimension,calendarBodyWidget).getMainPanel();

        mainPanel.add(titlePanel);
        mainPanel.add(functionPanel);
        mainPanel.add(calendarBodyPanel);
    }

    @Override
    protected void initializeView() {

    }
}
