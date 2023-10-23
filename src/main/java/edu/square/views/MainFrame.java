package edu.square.views;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.LeftSideView;
import edu.square.views.component.TodayPanelManage;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;

public class MainFrame {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();


        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        LeftSideView leftSideView = new LeftSideView(mainFrame);


        TodayPanelManage todayPanelManage = new TodayPanelManage(mainFrame);
        mainFrame.add(leftSideView.getLeftPanel());
        mainFrame.add(todayPanelManage.getTodayPanelManage());
        mainFrame.setVisible(true);
    }
}
