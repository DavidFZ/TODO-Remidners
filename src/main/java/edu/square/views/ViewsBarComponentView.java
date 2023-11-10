package edu.square.views;

import edu.square.views.view1.widget.LabelPanelWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.FontUtil.FONT_SIZE_1;
import static edu.square.utils.UIUtils.FontUtil.getBoldFont;

public class ViewsBarComponentView {
    @Getter
    private final List<LabelPanelWidget> labelPanelWidgets;
    private final Dimension parentDimension;
    private final Dimension selfDimension;
    private final Font font;
    @Getter
    private JPanel mainPanel;


    public ViewsBarComponentView(Dimension rootDimension, Dimension selfDimension, String... viewsTitles) {
        this.parentDimension = rootDimension;
        this.selfDimension = selfDimension;
        //initializeMainPanel
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setBackground(Color.black);
        //initializeFonts
        font = getBoldFont(parentDimension, FONT_SIZE_1);


        labelPanelWidgets = new ArrayList<>(viewsTitles.length);
        for (String title : viewsTitles) {
            addLabelPanelWidget(title);
        }
    }

    private void addLabelPanelWidget(String title) {
        LabelPanelWidget labelPanelWidget = new LabelPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 1.0 / labelPanelWidgets.size()), title);

        labelPanelWidget.getMainPanel().setFont(font);
        labelPanelWidget.getMainPanel().setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        labelPanelWidgets.add(labelPanelWidget);
        mainPanel.add(labelPanelWidget.getMainPanel());
    }
}
