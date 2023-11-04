package edu.square.views;

import edu.square.views.component.LeftSideComponent;

import javax.swing.*;
import java.awt.*;

public class ListView extends MyView {
    private static final String[] titles = {"test,test"};
    private final JFrame parentFrame;
    LeftSideComponent leftSideComponent;

    public ListView(JFrame parentFrame, Dimension dimension) {
        super(dimension);
        this.parentFrame=parentFrame;

        leftSideComponent = new LeftSideComponent(parentFrame, titles);
        mainPanel.add(leftSideComponent.getMainPanel());
    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}


