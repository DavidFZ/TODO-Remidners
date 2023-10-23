package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class BlockPanelView {
    private JPanel mainPanel;

    public BlockPanelView(Dimension parentJComponentDimension, Color backgroundColor) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, 0.2));
        mainPanel.setBackground(backgroundColor);
    }

    public BlockPanelView(Dimension parentJComponentDimension,double scalingRatio) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, scalingRatio));
    }

    public JPanel getBlockPanel() {
        return mainPanel;
    }

}
