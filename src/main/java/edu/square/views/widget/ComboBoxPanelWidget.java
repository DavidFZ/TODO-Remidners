package edu.square.views.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MWidgetTestHelper;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class ComboBoxPanelWidget extends MWidget {

    private final String[] options;
    private final String title;
    private Font font;
    private JComboBox<String> jComboBox;
    private JLabel titleLabel;

    public ComboBoxPanelWidget(Dimension rootFrameDimension, Dimension selfDimension, Font font, String title, String[] options) {
        super(rootFrameDimension, selfDimension);
        this.options = options;
        this.font = font;
        this.title = title;
        addJComponents();
    }

    public ComboBoxPanelWidget(Dimension rootFrameDimension, Dimension selfDimension, String title, String[] options) {
        super(rootFrameDimension, selfDimension);
        this.options = options;
        this.title = title;

        updateView();
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(selfDimension, FontUtil.FONT_SIZE_2);
    }

    @Override
    protected void initializeJComponents() {
        //initialize title label
        titleLabel = new JLabel();
        titleLabel.setFont(font);
        titleLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.3, 0.8));
        mainPanel.add(titleLabel);

        //initialize jComboBox
        jComboBox = new JComboBox<String>();
        jComboBox.setFont(font);
        jComboBox.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.6, 0.8));
        mainPanel.add(jComboBox);
    }

    private void updateView() {
        titleLabel.setText(title);
        for (String option : options) {
            jComboBox.addItem(option);
        }
    }


    public void addJComponents() {
        titleLabel = new JLabel(title);
        titleLabel.setFont(font);
        titleLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.3, 0.8));
        mainPanel.add(titleLabel);

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

    public static void main(String[] args) {
        MWidgetTestHelper mWidgetTestHelper = new MWidgetTestHelper() {
            @Override
            public void initializeMWidget() {
                String[] years = {
                        "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"
                };
                ComboBoxPanelWidget comboBoxPanelWidget = new ComboBoxPanelWidget(jFrame.getSize(), resizeDimensionWidthAndHeight(jFrame.getSize(), 0.4, 0.07), "years:", years);
                jFrame.add(comboBoxPanelWidget.getMainPanel());
            }
        };
    }
}
