package edu.square.views.view2;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getCenterFlowMainPanel;

public class CalendarComponentView extends MComponent {

    public CalendarComponentView(Dimension rootFrameDimension, MyView myView) {
        super(myView, rootFrameDimension);

    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, 0.45);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = getCenterFlowMainPanel(selfDimension);
//        mainPanel.setBackground(Color.yellow);
    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {
        CalenderPanelWidget calenderPanelWidget = new CalenderPanelWidget(selfDimension, selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainPanel.add(calenderPanelWidget.getMainPanel());
    }

    @Override
    protected void initializeView() {

    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        MyView myView = new MyView(mainFrame, mainFrame.getSize());

        CalendarComponentView calendarComponentView = new CalendarComponentView(resizeDimensionWidthScale(mainFrame.getSize(), 0.45), myView);
        mainFrame.add(myView.getMainPanel());
        mainFrame.setVisible(true);
    }
}
