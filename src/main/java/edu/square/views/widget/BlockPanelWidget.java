package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class BlockPanelWidget extends MWidget{
    public BlockPanelWidget(Dimension parentJComponentDimension, double scalingRation) {
        super();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, scalingRation));
    }

    @Override
    protected void setMainPanelFlowLayout(FlowLayout flowLayout) {

    }
}
