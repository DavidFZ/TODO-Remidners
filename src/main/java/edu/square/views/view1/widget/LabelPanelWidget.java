package edu.square.views.view1.widget;

import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static edu.square.utils.UIUtils.FontUtil.getBoldFont;

public class LabelPanelWidget extends MWidget {
    private boolean beSelected = false;
    private Font font;

    private JLabel label;

    public LabelPanelWidget(Dimension parentDimension, Dimension selfDimension, String title) {
        super(parentDimension, selfDimension);
        label.setText(title);

        mainPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                setBeSelected();
            }
        });
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
        if (beSelected) {
            label.setForeground(Color.white);
            mainPanel.setBackground(Color.black);
        } else {
            label.setForeground(Color.black);
            mainPanel.setBackground(Color.white);
        }
        beSelected = !beSelected;
    }
}
