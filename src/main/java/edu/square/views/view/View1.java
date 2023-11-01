package edu.square.views.view;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.DetailInformationComponent;
import edu.square.views.component.GroupedListComponent;
import edu.square.views.component.LeftSideComponent;

import javax.swing.*;
import java.awt.*;

public class View1 {
    public View1() {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        LeftSideComponent leftSideComponent = new LeftSideComponent(mainFrame, View1Controller.getGroupTitles());
        GroupedListComponent groupedListComponent = new GroupedListComponent(mainFrame.getSize());
        DetailInformationComponent detailInformationComponent = new DetailInformationComponent(mainFrame.getSize());

        View1Controller view1Controller = new View1Controller(leftSideComponent, groupedListComponent,detailInformationComponent);

        mainFrame.add(leftSideComponent.getLeftPanel());
        mainFrame.add(groupedListComponent.getMainPanel());
        mainFrame.add(detailInformationComponent.getMainPanel());

        mainFrame.setVisible(true);
        mainFrame.setResizable(false);
    }

    public static void main(String[] args) {
        new View1();
    }
}
