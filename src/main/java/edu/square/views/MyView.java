package edu.square.views;

import javax.swing.*;
import java.awt.*;

public abstract class MyView {
    protected JPanel mainPanel;

    public MyView(Dimension dimension) {
        mainPanel = new JPanel((LayoutManager) dimension);
    }

    public void setMainPanelLayout(LayoutManager layoutManager) {
        mainPanel.setLayout(layoutManager);
    }
}
