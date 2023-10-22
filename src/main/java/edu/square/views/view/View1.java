package edu.square.views.view;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.TodayPanelManage;

import javax.swing.*;
import java.awt.*;

public class View1 {
    public View1() {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        LeftSideComponent leftSideComponent = new LeftSideComponent(mainFrame);


        TodayPanelManage todayPanelManage = new TodayPanelManage(mainFrame);
        mainFrame.add(leftSideComponent.getLeftPanel());
        mainFrame.add(todayPanelManage.getTodayPanelManage());
        mainFrame.setVisible(true);
    }
}
