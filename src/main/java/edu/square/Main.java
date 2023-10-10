package edu.square;

import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame frame = JFrameFactory.getDefaultJFrame("TODO LIST");
        frame.setVisible(true);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel listPanel = new JPanel();
        Label label = new Label("TODO LIST");
        listPanel.add(label);
        JPanel todoPanel = new JPanel();
        todoPanel.setLayout(new BoxLayout(todoPanel, BoxLayout.Y_AXIS));

        panel.add(listPanel, BorderLayout.WEST);
        panel.add(todoPanel, BorderLayout.CENTER);



        frame.add(panel);


    }
}