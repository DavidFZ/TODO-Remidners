package edu.square.views.view;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.view.ListView;
import edu.square.views.view2.CalendarComponentView;

import javax.swing.*;
import java.awt.*;

public class CalenderView extends MyView {

    public final CalendarComponentView calendarComponentView;

    public CalenderView(JFrame parentFrame, Dimension dimension) {
        super(parentFrame, dimension);
        calendarComponentView = new CalendarComponentView(rootFrameDimension, this);
    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        CalenderView calenderView = new CalenderView(mainFrame, mainFrame.getSize());

        mainFrame.add(calenderView.getMainPanel());

        mainFrame.setVisible(true);
    }
}
