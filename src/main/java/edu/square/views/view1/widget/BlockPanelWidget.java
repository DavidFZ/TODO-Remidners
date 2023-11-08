package edu.square.views.view1.widget;

import edu.square.views.widget.MWidget;

import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class BlockPanelWidget extends MWidget {
    public BlockPanelWidget(Dimension parentJComponentDimension, Dimension selfDimension) {
        super(parentJComponentDimension, selfDimension);
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
