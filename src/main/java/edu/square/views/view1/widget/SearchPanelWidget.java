package edu.square.views.view1.widget;

import edu.square.utils.HeightPercentageHelper;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MWidgetTestHelper;
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

    public SearchPanelWidget(Dimension rootFrameDimension, Dimension selfDimension) {
        super(rootFrameDimension, selfDimension);
    }

    public static void main(String[] args) {
        MWidgetTestHelper mWidgetTestHelper = new MWidgetTestHelper() {
            @Override
            public void initializeMWidget() {
                SearchPanelWidget searchPanelWidget = new SearchPanelWidget(jFrame.getSize(), resizeDimensionHeightScale(jFrame.getSize(), 0.2));

                JPanel jPanel = new JPanel();
                jPanel.setPreferredSize(jFrame.getSize());
                jPanel.setBackground(Color.black);

                jPanel.add(searchPanelWidget.getMainPanel());
                jFrame.add(jPanel);
            }
        };
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        mainPanel.setBackground(Color.red);
    }

    @Override
    protected void initializeFonts() {
        font = FontUtil.getBoldFont(rootFrameDimension, FontUtil.FONT_SIZE_2);
    }

    @Override
    protected void initializeJComponents() {
//        searchTipsPanel

        JPanel searchTipsPanel = getFlowJpanel(FlowLayout.LEFT, resizeDimensionHeightScale(rootFrameDimension, 0.07), Color.yellow);

        JLabel searchTips = new JLabel("Search:");
        searchTips.setFont(font);
        searchTipsPanel.add(searchTips);


//        searchPanel
        JPanel searchPanel = getFlowJpanel(FlowLayout.RIGHT, resizeDimensionHeightScale(rootFrameDimension, 0.05), Color.BLACK);

        JTextField searchText = new JTextField();
        searchText.setPreferredSize(resizeDimensionWidthAndHeight(rootFrameDimension, 0.8, 0.04));
        searchText.setFont(font);
        searchPanel.add(searchText);


        mainPanel.add(searchTipsPanel);
        mainPanel.add(searchPanel);
    }
}
