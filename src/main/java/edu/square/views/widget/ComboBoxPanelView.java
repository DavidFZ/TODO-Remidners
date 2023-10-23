package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class ComboBoxPanelView {
    JPanel jPanel;

    JComboBox<String> jComboBox;

    String[] options;

    public ComboBoxPanelView(Dimension dimension, double scalingRatio, Font font, String[] options, Color background) {
        this.options = options;
        jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        jPanel.setPreferredSize(resizeDimensionHeightScale(dimension, scalingRatio));
        jPanel.setBackground(background);
        jComboBox = new JComboBox<String>();
        jComboBox.setFont(font);
        for (String option : options) {
            jComboBox.addItem(option);
        }
        jComboBox.setPreferredSize(new Dimension((int) (0.7 * dimension.width), (int) (0.8 * scalingRatio * dimension.height)));
        jPanel.add(jComboBox);

    }

    public JPanel getjPanel() {
        return jPanel;
    }
}
