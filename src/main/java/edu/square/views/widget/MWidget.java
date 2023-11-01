package edu.square.views.widget;

import javax.swing.*;

public abstract class MWidget{
    protected final JPanel mainPanel;

    public MWidget(){
        mainPanel = new JPanel();
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
