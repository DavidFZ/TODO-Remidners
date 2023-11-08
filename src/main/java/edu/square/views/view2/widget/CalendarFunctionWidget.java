package edu.square.views.view2.widget;

import edu.square.utils.UIUtils.FontUtil;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.widget.MWidget;
import edu.square.utils.UIUtils.ComponentResizeUtil;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;

public class CalendarFunctionWidget extends MWidget {
    Font fontBig;
    Font fontSmall;

    JLabel lastLabel = new JLabel("Last Month");
    JLabel nextLabel = new JLabel("Next Month");

    public CalendarFunctionWidget(Dimension rootFrameDimension, Dimension selfDimension){
        super(rootFrameDimension,selfDimension);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
    }

    @Override
    protected void initializeFonts() {
        fontBig = FontUtil.getBoldFont(rootFrameDimension,0.03);
        fontSmall = FontUtil.getBoldFont(rootFrameDimension,0.008);
    }

    @Override
    protected void initializeJComponents() {
        JPanel backPanel = JPanelUtil.getFlowJpanel(FlowLayout.LEFT,ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,1.0,0.48));
        JPanel lastAndNextPanel = JPanelUtil.getFlowJpanel(FlowLayout.LEFT,ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,1.0,0.48));
        JPanel lastPanel = JPanelUtil.getFlowJpanel(FlowLayout.LEFT,ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,0.48,0.48));
        JPanel nextPanel = JPanelUtil.getFlowJpanel(FlowLayout.RIGHT,ComponentResizeUtil.resizeDimensionWidthAndHeight(selfDimension,0.48,0.48));

        lastLabel.setFont(fontSmall);
        nextLabel.setFont(fontBig);
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextLabel);
        mainPanel.add(backPanel);
        mainPanel.add(lastAndNextPanel);
    }
    public void setNextLabelFunction(MouseListener mouseListener){
        nextLabel.addMouseListener(mouseListener);
    }

    public void setLastLabelFunction(MouseListener mouseListener){
        lastLabel.addMouseListener(mouseListener);
    }
}
