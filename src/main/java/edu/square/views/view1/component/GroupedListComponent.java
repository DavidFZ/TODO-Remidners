package edu.square.views.view1.component;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.widget.GroupedTitleWidgetView;
import edu.square.views.widget.ReminderListWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class GroupedListComponent extends MComponent {
    private final double scaling = 0.4;
    Font font1;
    Font font2;
    Font font3;
    @Getter
    JButton addButton;
    private GroupedTitleWidgetView groupedTitleWidgetView;
    private ReminderListWidgetView reminderListWidgetView;
    @Getter
    private JFrame printFrame;
    @Getter
    private JButton confirmButton;


    public GroupedListComponent(Dimension rootFrameDimension, MyView myView) {
        super(myView, rootFrameDimension);
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                GroupedListComponent groupedListComponent = new GroupedListComponent(jFrame.getSize(), myView);
            }
        };
    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, scaling);
    }

    @Override
    protected void initializeMainPanel() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        mainPanel = getFlowJpanel(flowLayout, selfDimension);
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(parentDimension, 0.05);
        font2 = FontUtil.getBoldFont(parentDimension, 0.03);
        font3 = FontUtil.getBoldFont(parentDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        //GROUP TITLE
        groupedTitleWidgetView = new GroupedTitleWidgetView(parentDimension, resizeDimensionHeightScale(selfDimension,0.1));
        mainPanel.add(groupedTitleWidgetView.getMainPanel());

        //GROUP LABEL
        reminderListWidgetView = new ReminderListWidgetView(parentDimension, parentDimension);
        mainPanel.add(reminderListWidgetView.getScrollPane());
    }

    @Override
    protected void initializeView() {

    }
}
