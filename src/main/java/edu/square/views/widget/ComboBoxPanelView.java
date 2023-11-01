package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class ComboBoxPanelView extends MWidget {

    JComboBox<String> jComboBox;

    String[] options;

    public ComboBoxPanelView(Dimension dimension, double scalingRatio, Font font, String[] options, Color background) {
        super();
        this.options = options;

        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(resizeDimensionHeightScale(dimension, scalingRatio));
        mainPanel.setBackground(background);

        jComboBox = new JComboBox<String>();
        jComboBox.setFont(font);
        for (String option : options) {
            jComboBox.addItem(option);
        }

        jComboBox.setPreferredSize(new Dimension((int) (0.7 * dimension.width), (int) (0.8 * scalingRatio * dimension.height)));
        mainPanel.add(jComboBox);
    }
}
