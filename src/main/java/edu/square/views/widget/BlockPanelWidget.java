package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class BlockPanelWidget {
    private JPanel mainPanel;

    public BlockPanelWidget(Dimension parentJComponentDimension, Color backgroundColor) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, 0.2));
        mainPanel.setBackground(backgroundColor);
    }

    public BlockPanelWidget(Dimension parentJComponentDimension) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, 0.2));
    }

    public BlockPanelWidget(Dimension parentJComponentDimension, double scalingRation) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(parentJComponentDimension, scalingRation));
    }

    public JPanel getBlockPanel() {
        return mainPanel;
    }

}
