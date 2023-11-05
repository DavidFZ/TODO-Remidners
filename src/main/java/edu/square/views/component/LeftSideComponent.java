package edu.square.views.component;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.MyView;
import edu.square.views.widget.BlockPanelWidget;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.widget.SearchPanelWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getCenterFlowMainPanel;

public class LeftSideComponent extends MComponent {

    Font font1;
    Font font2;
    Font font3;
    @Getter
    private List<GroupLabelWidget> groupLabelWidgets;

    public LeftSideComponent(Dimension parentFrameDimension, MyView myView, String[] groupedTitles) {
        super(parentFrameDimension);

        //TODO: clean this up
        Dimension parentJComponentDimension = new Dimension((int) parentFrameDimension.getWidth(), (int) parentFrameDimension.getHeight());
        Dimension mainPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.2);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);


        //ROOT COMPONENT OF LEFT GROUP VIEW
        mainPanel = getCenterFlowMainPanel(mainPanelDimension);
        mainPanel.setBackground(Color.green);

        //SEARCH PANEL
        SearchPanelWidget searchPanelWidget = new SearchPanelWidget(mainPanelDimension, font2);
        mainPanel.add(searchPanelWidget.getSearchTipsPanel());
        mainPanel.add(searchPanelWidget.getSearchPanel());

        //BLOCK PANEL
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(parentJComponentDimension, 0.2);
        mainPanel.add(blockPanelWidget.getMainPanel());

        //GROUP LABEL
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(mainPanelDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupedTitles));
        groupLabelWidgets = viewBuilder.build(titles);
        for (GroupLabelWidget groupLabelWidget :
                groupLabelWidgets) {
            mainPanel.add(groupLabelWidget.getGroupView());
        }

        myView.addMComponent(this);
    }

    public LeftSideComponent(JFrame parentFrame, String[] groupedTitles) {
        super(parentFrame.getSize());

        Dimension parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        Dimension mainPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.2);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);


        //ROOT COMPONENT OF LEFT GROUP VIEW
        mainPanel = getCenterFlowMainPanel(mainPanelDimension);
        mainPanel.setBackground(Color.green);

        //SEARCH PANEL
        SearchPanelWidget searchPanelWidget = new SearchPanelWidget(mainPanelDimension, font2);
        mainPanel.add(searchPanelWidget.getSearchTipsPanel());
        mainPanel.add(searchPanelWidget.getSearchPanel());

        //BLOCK PANEL
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(parentJComponentDimension, 0.2);
        mainPanel.add(blockPanelWidget.getMainPanel());

        //GROUP LABEL
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(mainPanelDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupedTitles));
        groupLabelWidgets = viewBuilder.build(titles);
        for (GroupLabelWidget groupLabelWidget :
                groupLabelWidgets) {
            mainPanel.add(groupLabelWidget.getGroupView());
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        LeftSideComponent leftSideComponent = new LeftSideComponent(jFrame, View1Controller.groupTitles);
        JPanel panel = leftSideComponent.getLeftPanel();

        jFrame.add(panel);
        jFrame.setVisible(true);
    }

    public JPanel getLeftPanel() {
        return mainPanel;
    }

    @Override
    protected void initializeMainPanel() {

    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {

    }

    @Override
    protected void setColors() {

    }
}
