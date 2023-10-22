package edu.square.views.view;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.GroupedListComponent;

import javax.swing.*;
import java.awt.*;

public class View1 {
    public View1() {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        LeftSideComponent leftSideComponent = new LeftSideComponent(mainFrame, View1Controller.getGroupTitles());
        GroupedListComponent groupedListComponent = new GroupedListComponent(mainFrame);

        View1Controller view1Controller = new View1Controller(leftSideComponent, groupedListComponent);

        mainFrame.add(leftSideComponent.getLeftPanel());
        mainFrame.add(groupedListComponent.getMainPanel());

        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new View1();
    }
}
