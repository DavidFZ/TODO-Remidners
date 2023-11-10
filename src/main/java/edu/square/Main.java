package edu.square;

import edu.square.controller.view1.ListController;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.ViewsBarComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.view.ListView;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import static edu.square.utils.DBUtils.jdbc.DatabaseStatusUtil.forcedInitDB;
import static edu.square.utils.DevUtils.isDirExist;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;

public class Main {
    public static void main(String[] args) throws SQLException {
        if (!isDirExist("derbyDB"))
            forcedInitDB();

        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "TODO");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));

        MyView myView = new MyView(mainFrame, mainFrame.getSize());
        ViewsBarComponent viewsBarComponent = new ViewsBarComponent(myView, resizeDimensionWidthScale(mainFrame.getSize(), 0.1));
        viewsBarComponent.getMainPanel().setLayout(new FlowLayout(FlowLayout.CENTER,0,0));

        ListView listView = new ListView(mainFrame, resizeDimensionWidthScale(mainFrame, 0.9));
        ListController listController = new ListController(listView);
        JPanel listPanel = listView.getMainPanel();
        listPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.add(listView.getMainPanel());
        mainFrame.setVisible(true);
    }
}