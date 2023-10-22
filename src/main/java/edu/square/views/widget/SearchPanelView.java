package edu.square.views.widget;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class SearchPanelView {
    @Getter
    private JPanel searchPanel;
    @Getter
    private JPanel searchTipsPanel;

    public SearchPanelView(Dimension dimension, Font font2) {
        //        searchTipsPanel
        {
            searchTipsPanel = new JPanel();
            searchTipsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            searchTipsPanel.setPreferredSize(resizeDimensionHeightScale(dimension, 0.07));
            searchTipsPanel.setBackground(Color.yellow);

            JLabel searchTips = new JLabel("Search:");
            searchTips.setFont(font2);
            searchTipsPanel.add(searchTips);

        }

//        searchPanel
        {
            searchPanel = new JPanel();
            searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            searchPanel.setPreferredSize(resizeDimensionHeightScale(dimension, 0.05));
            searchPanel.setBackground(Color.BLACK);

            JTextField searchText = new JTextField();
            searchText.setPreferredSize(resizeDimensionWidthAndHeight(dimension, 0.8, 0.04));
            searchText.setFont(font2);
            searchPanel.add(searchText);
        }
    }
}
