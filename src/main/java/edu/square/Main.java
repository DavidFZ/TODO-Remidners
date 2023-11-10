package edu.square;

import edu.square.controller.view1.ListController;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.ViewsBarComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.view.ListView;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();

        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        MyView myView = new MyView(mainFrame, mainFrame.getSize());
        ViewsBarComponent viewsBarComponent = new ViewsBarComponent(myView, resizeDimensionWidthScale(mainFrame.getSize(), 0.1));

//        ListView listView = new ListView(mainFrame, resizeDimensionWidthScale(mainFrame,0.9));
//        ListController listController = new ListController(listView);
//        mainFrame.add(listView.getMainPanel());
        mainFrame.setVisible(true);
    }
}