package edu.square.views;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.GroupedListComponent;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;

public class MainFrame {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();


        //VIEW 1
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        LeftSideComponent leftSideComponent = new LeftSideComponent(mainFrame, View1Controller.getGroupTitles());
        GroupedListComponent groupedListComponent = new GroupedListComponent(mainFrame);

        mainFrame.add(leftSideComponent.getLeftPanel());
        mainFrame.add(groupedListComponent.getTodayPanelManage());

        mainFrame.setVisible(true);
    }
}
