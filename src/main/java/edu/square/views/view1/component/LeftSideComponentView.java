package edu.square.views.view1.component;

import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.widget.BlockPanelWidget;
import edu.square.views.widget.GroupLabelWidget;
import edu.square.views.view1.widget.SearchPanelWidget;
import lombok.Getter;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getCenterFlowMainPanel;

public class LeftSideComponentView extends MComponent {
    private static final String[] testGroupTitles = {"All", "Today", "Completed", "Flagged"};
    Font font1;
    Font font2;
    Font font3;

    @Getter
    private List<GroupLabelWidget> groupLabelWidgets;

    public LeftSideComponentView(Dimension rootFrameDimension, MyView myView) {
        super(myView, rootFrameDimension);
    }


    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                LeftSideComponentView leftSideComponentView = new LeftSideComponentView(jFrame.getSize(), myView);
                leftSideComponentView.setGroupLabelWidgetsTitle(testGroupTitles);
            }
        };
    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, 0.2);
    }

    @Override
    protected void initializeMainPanel() {
        //ROOT COMPONENT OF LEFT GROUP VIEW
        mainPanel = getCenterFlowMainPanel(selfDimension);
    }

    @Override
    protected void initializeFonts() {
        font1 = getBoldFont(parentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentDimension, FONT_SIZE_3);
    }

    @Override
    protected void initializeJComponents() {
        //SEARCH PANEL
        SearchPanelWidget searchPanelWidget = new SearchPanelWidget(parentDimension,selfDimension);
        mainPanel.add(searchPanelWidget.getMainPanel());

        //BLOCK PANEL
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(getParentDimension(), 0.2);
        blockPanelWidget.getMainPanel().setBackground(Color.yellow);
        mainPanel.add(blockPanelWidget.getMainPanel());

        //GROUP LABEL
        //initialize as empty
    }

    @Override
    protected void setColors() {
        mainPanel.setBackground(Color.green);
    }

    public void setGroupLabelWidgetsTitle(String[] groupedTitles) {
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(selfDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupedTitles));
        groupLabelWidgets = viewBuilder.build(titles);
        for (GroupLabelWidget groupLabelWidget : groupLabelWidgets) {
            mainPanel.add(groupLabelWidget.getGroupView());
        }
    }
}
