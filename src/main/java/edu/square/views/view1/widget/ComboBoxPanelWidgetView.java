package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MWidgetTestHelper;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class ComboBoxPanelWidgetView extends MWidget {

    private final String title;
    private List<String> options;
    private Font font;
    private JComboBox<String> jComboBox;
    private JLabel titleLabel;

    public ComboBoxPanelWidgetView(Dimension rootFrameDimension, Dimension selfDimension, String title, List<String> options) {
        super(rootFrameDimension, selfDimension);
        this.options = options;
        this.title = title;

        updateView();
    }

    public static void main(String[] args) {
        MWidgetTestHelper mWidgetTestHelper = new MWidgetTestHelper() {
            @Override
            public void initializeMWidget() {
                String[] years = {
                        "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030"
                };
                ComboBoxPanelWidgetView comboBoxPanelWidgetView = new ComboBoxPanelWidgetView(jFrame.getSize(), resizeDimensionWidthAndHeight(jFrame.getSize(), 0.4, 0.07), "years:", List.of(years));
                jFrame.add(comboBoxPanelWidgetView.getMainPanel());
            }
        };
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(selfDimension, 0.1);
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

    /**
     * update view by self options
     */
    private void updateView() {
        titleLabel.setText(title);
        if (options != null && options.size() > 0)
            for (String option : options) {
                jComboBox.addItem(option);
            }
    }

    public void updateOptionsView(List<String> options) {
        assert options != null && options.size() > 0;
        this.options = options;
        jComboBox.removeAllItems();

        for (String option : options) {
            jComboBox.addItem(option);
        }
    }

    public JComboBox<String> getjComboBox() {
        return jComboBox;
    }
}
