package edu.square.views.component;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.widget.BlockPanelView;
import edu.square.views.widget.GroupLabelView;
import edu.square.views.widget.SearchPanelView;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getMainPanel;

public class LeftSideView {

    private static final String[] groupTitles = {"Today", "Completed", "All", "Flagged"};
    private final Dimension parentJComponentDimension;
    private final Dimension mainPanelDimension;
    Font font1;
    Font font2;
    Font font3;
    private JPanel mainPanel;
    private List<GroupLabelView> groupLabelViews;

    public LeftSideView(JFrame parentFrame) {
        parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        mainPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.2);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);


        //ROOT COMPONENT OF LEFT GROUP VIEW
        mainPanel = getMainPanel(mainPanelDimension);
        mainPanel.setBackground(Color.green);

        //SEARCH PANEL
        SearchPanelView searchPanelView = new SearchPanelView(mainPanelDimension, font2);
        mainPanel.add(searchPanelView.getSearchTipsPanel());
        mainPanel.add(searchPanelView.getSearchPanel());

        //BLOCK PANEL
        BlockPanelView blockPanelView = new BlockPanelView(parentJComponentDimension,0.2);
        mainPanel.add(blockPanelView.getBlockPanel());

        //GROUP LABEL
        GroupLabelView.ViewBuilder viewBuilder = new GroupLabelView.ViewBuilder(mainPanelDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupTitles));
        groupLabelViews = viewBuilder.build(titles);
        for (GroupLabelView groupLabelView :
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
