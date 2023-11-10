package edu.square;

import edu.square.controller.ViewsBarComponentController;
import edu.square.controller.view1.ListController;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.ViewsBarComponentView;
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

        //main frame
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "TODO");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        //bar view
        ViewsBarComponentView viewsBarComponentView = new ViewsBarComponentView(mainFrame.getSize(), resizeDimensionWidthScale(mainFrame.getSize(), 0.1));
        viewsBarComponentView.getMainPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.add(viewsBarComponentView.getMainPanel());

        //list view
        ListView listView = new ListView(mainFrame, resizeDimensionWidthScale(mainFrame, 0.9));
        ListController listController = new ListController(listView);
        JPanel listPanel = listView.getMainPanel();
        listPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainFrame.add(listView.getMainPanel());



        Dimension barDimension = resizeDimensionWidthScale(mainFrame.getSize(), 0.1);
        ViewsBarComponentController viewsBarComponentController = new ViewsBarComponentController(mainFrame.getSize(), barDimension, listView);

        mainFrame.setVisible(true);

    }
}