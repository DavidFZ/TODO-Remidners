package edu.square.views.component;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.widget.BlockPanelWidget;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.widget.SearchPanelWidget;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getCenterFlowMainPanel;

public class LeftSideView {

    private static final String[] groupTitles = View1Controller.getGroupTitles();
    private final Dimension parentJComponentDimension;
    private final Dimension mainPanelDimension;
    Font font1;
    Font font2;
    Font font3;
    private JPanel mainPanel;
    private List<GroupLabelWidget> groupLabelViews;

    public LeftSideView(JFrame parentFrame) {
        parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        mainPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.2);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);


        //ROOT COMPONENT OF LEFT GROUP VIEW
        mainPanel = getCenterFlowMainPanel(mainPanelDimension);
        mainPanel.setBackground(Color.green);

        //SEARCH PANEL
        SearchPanelWidget searchPanelView = new SearchPanelWidget(mainPanelDimension, font2);
        mainPanel.add(searchPanelView.getSearchTipsPanel());
        mainPanel.add(searchPanelView.getSearchPanel());

        //BLOCK PANEL
        BlockPanelWidget blockPanelView = new BlockPanelWidget(parentJComponentDimension,0.2);
        mainPanel.add(blockPanelView.getMainPanel());

        //GROUP LABEL
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(mainPanelDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupTitles));
        groupLabelViews = viewBuilder.build(titles);
        for (GroupLabelWidget groupLabelView :
                groupLabelViews) {
            mainPanel.add(groupLabelView.getGroupView());
        }
    }

    public static void main(String[] args) {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        LeftSideView leftSideView = new LeftSideView(jFrame);
        JPanel panel = leftSideView.getLeftPanel();

        jFrame.add(panel);
        jFrame.setVisible(true);
    }

    public JPanel getLeftPanel() {
        return mainPanel;
    }

}
