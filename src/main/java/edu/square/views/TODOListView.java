package edu.square.views;

import javax.swing.*;

public class TODOListView {
    private JPanel mainPanel;
    private JPanel ListsPanel;
    private JPanel RemindersPanel;
    private JLabel dateLabel;

    public static void main(String[] args) {
        JFrame frame = new JFrame("TODOListView");
        frame.setContentPane(new TODOListView().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,300);
        frame.setVisible(true);
    }
}
