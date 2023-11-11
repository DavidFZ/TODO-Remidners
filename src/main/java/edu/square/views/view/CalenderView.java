package edu.square.views.view;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.component.GroupedListComponentView;
import edu.square.views.view2.CalendarComponentView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class CalenderView extends MyView {
    @Getter
    private final CalendarComponentView calendarComponentView;
    @Getter
    private final GroupedListComponentView groupedListComponentView;

    public CalenderView(JFrame parentFrame, Dimension dimension) {
        super(parentFrame, dimension);

        calendarComponentView = new CalendarComponentView(rootFrameDimension, this);
        groupedListComponentView = new GroupedListComponentView(rootFrameDimension, this);
        groupedListComponentView.getGroupedTitleWidgetView().getTitleLabel().setFont(FontUtil.getBoldFont(rootFrameDimension, 0.02));

    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        CalenderView calenderView = new CalenderView(mainFrame, mainFrame.getSize());

        mainFrame.add(calenderView.getMainPanel());

        mainFrame.setVisible(true);
    }

    public void addListenerOnNextLabel(MouseAdapter mouseAdapter) {
        calendarComponentView.getCalenderPanelWidget().addListenerOnNextLabel(mouseAdapter);
    }

    public void addListenerOnLastLabel(MouseAdapter mouseAdapter) {
        calendarComponentView.getCalenderPanelWidget().addListenerOnLastLabel(mouseAdapter);
    }
}
