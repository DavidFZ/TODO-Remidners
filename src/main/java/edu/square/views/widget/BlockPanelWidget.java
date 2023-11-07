package edu.square.views.widget;

import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class BlockPanelWidget extends MWidget {
    public BlockPanelWidget(Dimension parentJComponentDimension, double scalingRation) {
        super(parentJComponentDimension, resizeDimensionHeightScale(parentJComponentDimension,scalingRation));
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 0, 0));
    }

    @Override
    protected void initializeFonts() {
    }

    @Override
    protected void initializeJComponents() {
    }
}
