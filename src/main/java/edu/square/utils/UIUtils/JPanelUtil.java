package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

public class JPanelUtil {
    public static JPanel getCenterFlowMainPanel(Dimension mainPanelDimension) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(mainPanelDimension);
        return mainPanel;
    }

    public static JPanel getFlowJpanel(int flowLayout) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(flowLayout));
        return jPanel;
    }

    public static JPanel getFlowJpanel(int flowLayout, Dimension dimension) {
        JPanel jPanel = getFlowJpanel(flowLayout);
        jPanel.setPreferredSize(dimension);
        return jPanel;
    }

    public static JPanel getFlowJpanel(int flowLayout, Dimension dimension, Color color) {
        JPanel jPanel = getFlowJpanel(flowLayout, dimension);
        jPanel.setBackground(color);
        return jPanel;
    }

    public static JPanel getFlowJpanel(FlowLayout flowLayout, Dimension dimension) {
        JPanel jPanel = new JPanel();
        jPanel.setLayout(flowLayout);
        jPanel.setPreferredSize(dimension);
        return jPanel;
    }

    public static JPanel getFlowJpanel(FlowLayout flowLayout, Dimension dimension, Color color) {
        JPanel jPanel = getFlowJpanel(flowLayout, dimension);
        jPanel.setBackground(color);
        return jPanel;
    }

}
