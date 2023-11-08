package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.widget.MWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class GroupedTitleWidgetView extends MWidget {
    Font font1;
    Font font2;
    Font font3;
    private JLabel titleLabel;
    @Getter
    private JButton addButton;

    public GroupedTitleWidgetView(Dimension rootFrameDimension, Dimension selfDimension) {
        super(rootFrameDimension, selfDimension);
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(jFrame.getSize(), jFrame.getSize());
                jFrame.add(groupedTitleWidgetView.getMainPanel());
            }
        };
    }


    @Override
    protected void initializeMainPanel() {
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(rootFrameDimension, 0.04);
        font2 = FontUtil.getBoldFont(rootFrameDimension, 0.03);
        font3 = FontUtil.getBoldFont(rootFrameDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        //left sub panel
        JPanel groupTitlePanel = getFlowJpanel(FlowLayout.LEFT, resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.9));
        //right sub panel
        JPanel buttonPanel = getFlowJpanel(FlowLayout.RIGHT, resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.9));

        //set background color
        groupTitlePanel.setBackground(Color.blue);
        buttonPanel.setBackground(Color.yellow);

        //left side label
        titleLabel = new JLabel("All");
        titleLabel.setFont(font1);
        groupTitlePanel.add(titleLabel);

        //right side button
        addButton = new JButton("+");
        addButton.setFont(font2);
        addButton.setBackground(Color.white);
        addButton.setPreferredSize(resizeDimensionWidthAndHeight(rootFrameDimension, 0.05, 0.05));
        addButton.setVisible(true);
        buttonPanel.add(addButton);

        //add sub panel to main panel
        mainPanel.add(groupTitlePanel);
        mainPanel.add(buttonPanel);
    }


    public void setTitleLabel(String title) {
        titleLabel.setText(title);
    }

    public void setAddButtonListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
    }
}
