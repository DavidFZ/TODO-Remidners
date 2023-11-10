package edu.square.views.view1.widget;

import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.FontUtil.*;

public class LabelPanelWidget extends MWidget {

    Font font1;
    Font font2;
    Font font3;

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
        font1 = getBoldFont(selfDimension, 0.15);
    }

    @Override
    protected void initializeJComponents() {
        label = new JLabel("");
        label.setFont(font1);
        label.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.add(label);
    }
}
