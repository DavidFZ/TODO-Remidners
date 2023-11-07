package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

@Getter
public class SearchPanelWidget extends MWidget {

    Font font;

    public SearchPanelWidget(Dimension rootFrameDimension,Dimension selfDimension) {
        super(rootFrameDimension, selfDimension);

    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    @Override
    protected void initializeFonts() {
        font= FontUtil.getBoldFont(rootFrameDimension,FontUtil.FONT_SIZE_2);
    }

    @Override
    protected void initializeJComponents() {
//        searchTipsPanel

        JPanel searchTipsPanel = getFlowJpanel(FlowLayout.LEFT, resizeDimensionHeightScale(selfDimension, 0.07), Color.yellow);

        JLabel searchTips = new JLabel("Search:");
        searchTips.setFont(font);
        searchTipsPanel.add(searchTips);


//        searchPanel
        JPanel searchPanel = getFlowJpanel(FlowLayout.RIGHT, resizeDimensionHeightScale(selfDimension, 0.05), Color.BLACK);

        JTextField searchText = new JTextField();
        searchText.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.04));
        searchText.setFont(font);
        searchPanel.add(searchText);


        mainPanel.add(searchTipsPanel);
        mainPanel.add(searchPanel);
    }
}
