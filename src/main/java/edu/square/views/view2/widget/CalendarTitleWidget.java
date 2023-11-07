package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class CalendarTitleWidget extends MWidget {
    Font titleFont;
    private JLabel titleLabel;

    public CalendarTitleWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension, selfDimension);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,0));
    }

    @Override
    protected void initializeFonts() {
        titleFont = FontUtil.getBoldFont(rootFrameDimension,0.05);
    }

    @Override
    protected void initializeJComponents() {
        titleLabel.setFont(titleFont);
        mainPanel.add(titleLabel);
    }

    public void setTitleLabel(String title) {
        titleLabel.setText(title);
    }
}
