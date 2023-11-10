package edu.square.views.view1.widget;

import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static edu.square.utils.UIUtils.FontUtil.getBoldFont;

public class LabelPanelWidget extends MWidget {
    private Font font;

    private JLabel label;

    public LabelPanelWidget(Dimension parentDimension, Dimension selfDimension, String title) {
        super(parentDimension, selfDimension);
        label.setText(title);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void initializeFonts() {
        font = getBoldFont(selfDimension, 0.15);
    }

    @Override
    protected void initializeJComponents() {
        label = new JLabel("");
        label.setFont(font);
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(label);
    }

    public void setBeSelected() {
        label.setForeground(Color.black);
        mainPanel.setBackground(Color.white);
    }

    public void setNotSelected() {
        label.setForeground(Color.white);
        mainPanel.setBackground(Color.black);
    }
}
