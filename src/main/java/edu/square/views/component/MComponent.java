package edu.square.views.component;

import javax.swing.*;

public class MComponent {
    private JPanel mainPanel;
    private JFrame parentFame;

    public JPanel getMainPanel(){
        return mainPanel;
    }

    public MComponent(JFrame parentFame){
        this.parentFame =parentFame;
    }
}
