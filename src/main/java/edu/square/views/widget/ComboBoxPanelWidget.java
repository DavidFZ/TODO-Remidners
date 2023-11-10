package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class ComboBoxPanelWidget extends MWidget {

    JComboBox<String> jComboBox;

    String[] options;

    Font font;
    String title;

    public ComboBoxPanelWidget(Dimension rootFrameDimension, Dimension selfDimension, Font font, String title, String[] options) {
        super(rootFrameDimension, selfDimension);
        this.options = options;
        this.font = font;
        this.title = title;
        addJComponents();
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {

    }

    public void addJComponents() {
        JLabel label = new JLabel(title);
        label.setFont(font);
        label.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.3, 0.8));
        mainPanel.add(label);

        jComboBox = new JComboBox<String>();
        jComboBox.setFont(font);
        for (String option : options) {
            jComboBox.addItem(option);
        }

        jComboBox.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.6, 0.8));
        mainPanel.add(jComboBox);
    }

    public JComboBox<String> getjComboBox() {
        return jComboBox;
    }
}
