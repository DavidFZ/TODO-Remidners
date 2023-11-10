package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class ComboBoxPanelView extends MWidget {

    JComboBox<String> jComboBox;

    String[] options;

    public ComboBoxPanelView(Dimension rootFrameDimension,Dimension dimension, double scalingRatio, Font font, String[] options, Color background) {
        super(rootFrameDimension,resizeDimensionHeightScale(dimension,scalingRatio));
        selfDimension = resizeDimensionHeightScale(dimension, scalingRatio);
        this.options = options;

        mainPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setBackground(background);

        jComboBox = new JComboBox<String>();
        jComboBox.setFont(font);
        for (String option : options) {
            jComboBox.addItem(option);
        }

        jComboBox.setPreferredSize(new Dimension((int) (0.7 * dimension.width), (int) (0.8 * scalingRatio * dimension.height)));
        mainPanel.add(jComboBox);
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
