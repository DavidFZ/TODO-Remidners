package edu.square.views.view;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.DetailInformationComponent;
import edu.square.views.component.GroupedListComponent;
import edu.square.views.view1.component.LeftSideComponentView;
import edu.square.views.component.MComponent;

import javax.swing.*;
import java.awt.*;

public class ListView extends MyView {
    public static String[] groupTitles = {"All", "Today", "Completed", "Flagged"};
    MComponent leftSideComponent;
    MComponent groupedListComponent;
    MComponent detailInformationComponent;

    public ListView(JFrame parentFrame, Dimension selfDimension) {
        super(parentFrame, selfDimension);

        leftSideComponent = new LeftSideComponentView(rootFrameDimension, this);

        LeftSideComponentView leftSideComponentView = (LeftSideComponentView) this.leftSideComponent;
        leftSideComponentView.setGroupLabelWidgetsTitle(groupTitles);
        //groupedListComponent
        groupedListComponent = new GroupedListComponent(rootFrameDimension,this);
        //detailInformationComponent
        detailInformationComponent = new DetailInformationComponent(rootFrameDimension,this);
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

