package edu.square.views.view1.view;

import edu.square.controller.view1.component.GroupedListComponentController;
import edu.square.controller.view1.component.LeftSideComponentController;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.component.LeftSideComponentModel;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view.MyView;
import edu.square.views.view1.component.DetailInformationComponentView;
import edu.square.views.view1.component.GroupedListComponentView;
import edu.square.views.view1.component.LeftSideComponentView;

import javax.swing.*;
import java.awt.*;

public class ListView extends MyView {
    public static String[] groupTitles = {"All", "Today", "Completed", "Flagged"};
    public final LeftSideComponentView leftSideComponent;
    public final GroupedListComponentView groupedListComponentView;
    public final DetailInformationComponentView detailInformationComponent;

    public ListView(JFrame parentFrame, Dimension selfDimension) {
        super(parentFrame, selfDimension);

        leftSideComponent = new LeftSideComponentView(rootFrameDimension, this);
        groupedListComponentView = new GroupedListComponentView(rootFrameDimension, this);
        detailInformationComponent = new DetailInformationComponentView(rootFrameDimension, this);

//        mainPanel.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        ListView listView = new ListView(mainFrame, mainFrame.getSize());

        mainFrame.add(listView.getMainPanel());

        mainFrame.setVisible(true);
    }
}


