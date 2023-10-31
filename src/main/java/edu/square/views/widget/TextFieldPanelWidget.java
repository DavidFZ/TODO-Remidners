package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class TextFieldPanelWidget {

    JTextField textField;
    private JPanel panel;
    private String title;

    public TextFieldPanelWidget(Dimension dimension, Font font2, Font font3, String title, double scalingRatio) {
        panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel.setPreferredSize(resizeDimensionHeightScale(dimension, 0.07));
        panel.setBackground(Color.magenta);
        this.title = title;

        JLabel label = new JLabel(title);
        label.setFont(font2);
        label.setForeground(Color.blue);
        label.setPreferredSize(new Dimension((int) (0.2 * dimension.width), (int) (0.04 * dimension.height)));
        panel.add(label);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension((int) (0.75 * dimension.width), (int) (0.04 * dimension.height)));
        textField.setFont(font3);
        panel.add(textField);
    }

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(String text) {
        textField.setText(text);
        textField.repaint();
    }
}
