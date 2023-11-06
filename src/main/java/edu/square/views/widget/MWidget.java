package edu.square.views.widget;

import javax.swing.*;
import java.awt.*;

public abstract class MWidget{
    protected final JPanel mainPanel;

    public MWidget(){
        mainPanel = new JPanel();

    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    protected abstract void setMainPanelFlowLayout(FlowLayout flowLayout);
}
