package edu.square.views.view1.component;

import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.widget.GroupLabelWidget;
import lombok.Getter;

import java.awt.*;
import java.awt.event.MouseListener;
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
        groupLabelWidgets = new ArrayList<>();
    }


    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                LeftSideComponentView leftSideComponentView = new LeftSideComponentView(jFrame.getSize(), myView);
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
        mainPanel.setBackground(Color.yellow);
    }

    @Override
    protected void initializeFonts() {
        font1 = getBoldFont(parentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentDimension, FONT_SIZE_3);
    }

    @Override
    protected void initializeJComponents() {
//        //SEARCH PANEL
//        SearchPanelWidget searchPanelWidget = new SearchPanelWidget(parentDimension,resizeDimensionHeightScale(selfDimension,0.15));
//        mainPanel.add(searchPanelWidget.getMainPanel());
//
//        //BLOCK PANEL
//        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(selfDimension, 0.2);
//        blockPanelWidget.getMainPanel().setBackground(Color.yellow);
//        mainPanel.add(blockPanelWidget.getMainPanel());
//
//        //GROUP LABEL
//        initialize as empty
    }

    @Override
    protected void initializeView() {
    }

    public void setGroupLabelWidgetsTitle(String[] groupedTitles) {
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(selfDimension);
        List<String> titles = new ArrayList<>(Arrays.asList(groupedTitles));
        groupLabelWidgets = viewBuilder.build(titles);
        for (GroupLabelWidget groupLabelWidget : groupLabelWidgets) {
            mainPanel.add(groupLabelWidget.getMainPanel());
        }
    }

    public void setGroupLabelCount(int index, int count) {
        assert index >= 0 && index < groupLabelWidgets.size();
        groupLabelWidgets.get(index).setGroupViewCount(count);
    }

    public void setGroupLabelTitle(int index, String title) {
        assert index >= 0 && index < groupLabelWidgets.size();
        groupLabelWidgets.get(index).setGroupViewTitle(title);
    }

    public void addGroupLabel(String title, int count) {
        GroupLabelWidget.ViewBuilder viewBuilder = new GroupLabelWidget.ViewBuilder(selfDimension);
        GroupLabelWidget groupLabelWidget = viewBuilder.build(title);
        groupLabelWidget.setGroupViewCount(count);
        groupLabelWidgets.add(groupLabelWidget);
        mainPanel.add(groupLabelWidget.getMainPanel());
    }

    public void addGroupLabelMouseListener(int index, MouseListener groupLabelWidgetMouseListener) {
        assert index >= 0 && index < groupLabelWidgets.size();
        groupLabelWidgets.get(index).addMouseListener(groupLabelWidgetMouseListener);
    }
}
