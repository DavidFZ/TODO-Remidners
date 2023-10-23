package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class ControlPanelView {

    private JPanel controlPanel;

    private JPanel resetPanel;

    private JPanel donePanel;

    public ControlPanelView(Dimension dimension, Font font) {
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        controlPanel.setPreferredSize(resizeDimensionHeightScale(dimension, 0.1));
        controlPanel.setBackground(Color.green);

        //resetPanel
        {
            resetPanel = new JPanel();
            resetPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            resetPanel.setPreferredSize(new Dimension((int) (0.48 * dimension.width), (int) (0.08 * dimension.height)));
            resetPanel.setBackground(Color.orange);
            JButton resetButton = new JButton("Reset");
            resetButton.setPreferredSize(new Dimension((int) (0.2 * dimension.width), (int) (0.04 * dimension.height)));
            resetButton.setFont(font);
            resetButton.setBackground(Color.white);
            resetPanel.add(resetButton);

            controlPanel.add(resetPanel);
        }

        //donePanel
        {
            donePanel = new JPanel();
            donePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            donePanel.setPreferredSize(new Dimension((int) (0.48 * dimension.width), (int) (0.08 * dimension.height)));
            donePanel.setBackground(Color.orange);
            JButton doneButton = new JButton("Done");
            doneButton.setPreferredSize(new Dimension((int) (0.2 * dimension.width), (int) (0.04 * dimension.height)));
            doneButton.setFont(font);
            doneButton.setBackground(Color.white);
            donePanel.add(doneButton);
            controlPanel.add(donePanel);
        }


    }

    public JPanel getControlPanel() {
        return controlPanel;
    }
}
