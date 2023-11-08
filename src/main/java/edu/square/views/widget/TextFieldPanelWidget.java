package edu.square.views.widget;

import edu.square.utils.UIUtils.FontUtil;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class TextFieldPanelWidget extends MWidget {

    JTextField textField;
    private String title;

    Font font2;
    Font font3;

    public TextFieldPanelWidget(Dimension parentJComponentDimension, Dimension selfDimition,String title) {
        super(parentJComponentDimension, selfDimition);
        this.title = title;


    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setBackground(Color.magenta);
    }

    @Override
    protected void initializeFonts() {
        font2 = FontUtil.getBoldFont(rootFrameDimension, FontUtil.FONT_SIZE_2);
        font3 = FontUtil.getBoldFont(rootFrameDimension, FontUtil.FONT_SIZE_3);
    }

    @Override
    protected void initializeJComponents() {
        JLabel label = new JLabel(title);
        label.setFont(font2);
        label.setForeground(Color.blue);
        label.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.2, 0.04));
        mainPanel.add(label);

        textField = new JTextField();
        textField.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.75, 0.04));
        textField.setFont(font3);
        mainPanel.add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(String text) {
        textField.setText(text);
        textField.repaint();
    }
}
