package edu.square.views;

import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.widget.LabelPanelWidget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;
import static edu.square.utils.UIUtils.FontUtil.*;

public class ViewsBarComponent extends MComponent {
    private static final String[] viewsTitles = {"To do", "Calender", "TomatoTimer"};
    Font font;

    public ViewsBarComponent(MyView rootFrame, Dimension selfDimension) {
        super(rootFrame, selfDimension);
    }

    @Override
    protected void calculateSelfDimension() {

    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setBackground(Color.black);
    }

    @Override
    protected void initializeFonts() {
        font = getBoldFont(parentDimension, FONT_SIZE_1);
    }

    @Override
    protected void initializeJComponents() {
        LabelPanelWidget todoPanel = new LabelPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.3), "To do");
        todoPanel.getMainPanel().setFont(font);
        LabelPanelWidget CalenderPanel = new LabelPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.3), "Calender");
        CalenderPanel.getMainPanel().setFont(font);
        LabelPanelWidget TomatoTimerPanel = new LabelPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.3), "TomatoTimer");
        TomatoTimerPanel.getMainPanel().setFont(font);

        mainPanel.add(todoPanel.getMainPanel());
        mainPanel.add(CalenderPanel.getMainPanel());
        mainPanel.add(TomatoTimerPanel.getMainPanel());
    }

    @Override
    protected void initializeView() {

    }
}
