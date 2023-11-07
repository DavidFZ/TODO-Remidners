package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class BlockPanelWidget extends MWidget {
    public BlockPanelWidget(Dimension parentJComponentDimension, double scalingRation) {
        super(parentJComponentDimension, resizeDimensionHeightScale(parentJComponentDimension, scalingRation));
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));

    }

    @Override
    protected void initializeFonts() {


    }

    @Override
    protected void initializeJComponents() {
    }
}
