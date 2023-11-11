package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MWidgetTestHelper;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class TextFieldPanelWidget extends MWidget {

    JTextField textField;

    Font font;
    Font font3;

    JLabel label;

    public TextFieldPanelWidget(Dimension parentJComponentDimension, Dimension selfDimension, String title) {
        super(parentJComponentDimension, selfDimension);
        setTitle(title);

    }

    public static void main(String[] args) {
        MWidgetTestHelper mWidgetTestHelper = new MWidgetTestHelper() {
            @Override
            public void initializeMWidget() {
                TextFieldPanelWidget textFieldPanelWidget = new TextFieldPanelWidget(jFrame.getSize(), jFrame.getSize(), "Title");
                jFrame.add(textFieldPanelWidget.getMainPanel());
            }
        };
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setBackground(new Color(198,230,232));
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(rootFrameDimension, FontUtil.FONT_SIZE_1);
    }

    @Override
    protected void initializeJComponents() {
        label = new JLabel();
        label.setFont(font);
        label.setForeground(new Color(92,179,204));
        label.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.3, 0.9));
        mainPanel.add(label);

        textField = new JTextField();
        textField.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.65, 0.9));
        textField.setFont(font);
        mainPanel.add(textField);
    }

    public JTextField getTextField() {
        return textField;
    }

    public void setTextField(String text) {
        textField.setText(text);
        textField.repaint();
    }

    public void setTitle(String title) {
        label.setText(title);
    }
}
