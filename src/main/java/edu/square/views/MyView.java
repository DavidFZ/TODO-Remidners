package edu.square.views;

import edu.square.views.component.MComponent;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public abstract class MyView {
    protected Dimension rootFrameDimension;
    @Getter
    protected JPanel mainPanel;

    public MyView(JFrame parentFrame, Dimension dimension) {
        this.rootFrameDimension = parentFrame.getSize();
        mainPanel = new JPanel();
        mainPanel.setSize(dimension);

        parentFrame.add(mainPanel);
    }

    public void setMainPanelLayout(LayoutManager layoutManager) {
        mainPanel.setLayout(layoutManager);
    }

    public Dimension getMainPanelDimension() {
        return mainPanel.getSize();
    }

    public void addMComponent(MComponent mComponent) {
        mainPanel.add(mComponent.getMainPanel());
    }
}
