package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class BlockPanelWidget extends MWidget{
    public BlockPanelWidget(Dimension parentJComponentDimension, double scalingRation) {
        super(parentJComponentDimension,resizeDimensionHeightScale(parentJComponentDimension, scalingRation));
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, scalingRation));
    }



    @Override
    protected void initializeMainPanel() {

    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {

    }
}
