package edu.square.views.view5;

import javax.swing.*;
import java.awt.*;

public class ExportPanel extends JPanel {
    JPanel mainPanel = new JPanel();
    JPanel comboPanel = new JPanel();
    ExportPanel(int width,int height){
        //select panel at top
        Font f1 = new Font("宋体",Font.BOLD,(int)(0.02*width));
        mainPanel.setPreferredSize(new Dimension(width,height));
        mainPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        comboPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,(int)(0.04*width)));
        comboPanel.setPreferredSize(new Dimension(width,(int)(0.15*height)));
        mainPanel.add(comboPanel);
        String[] list ={"ALL","TASK","STUDY","LIST"};
        String[] status = {"ALL","COMPLETED","INCOMPLETE"};
        String[] sort = {"Manual","Time","Title","List"};
        JPanel listPanel = new ComboBoxPanel((int)(width/3),(int)(0.1*height),"List",list).jp;
        JPanel statusPanel = new ComboBoxPanel((int)(width/3),(int)(0.1*height),"Status",status).jp;
        JPanel sortPanel = new ComboBoxPanel((int)(width/3),(int)(0.1*height),"Sort",sort).jp;
        comboPanel.add(listPanel);
        comboPanel.add(statusPanel);
        comboPanel.add(sortPanel);
        mainPanel.add(comboPanel);


        //
        JPanel reminderPanel = new JPanel();
        reminderPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,(int)(0.02*height)));
        reminderPanel.setBackground(Color.WHITE);
        reminderPanel.setPreferredSize(new Dimension(width,(int)(0.7*height)));
        reminderPanel.setBackground(Color.BLUE);
        mainPanel.add(reminderPanel);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        JLabel tipsLabel = new JLabel("Please choose the data that you want to export");
        JLabel semicolonLabel = new JLabel("/");
        JTextField frontTextFiled = new JTextField(3);
        JTextField behindTextField = new JTextField(3);

        JPanel tipsPanel = new JPanel();
        tipsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tipsPanel.setPreferredSize(new Dimension((int)(0.5*width),(int)(0.1*height)));
        tipsLabel.setFont(f1);
        tipsPanel.add(tipsLabel);


        JPanel numberPanel = new JPanel();
        numberPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        numberPanel.setPreferredSize(new Dimension((int)(0.2*width),(int)(0.1*height)));
        behindTextField.setFont(f1);
        semicolonLabel.setFont(f1);
        frontTextFiled.setFont(f1);
        numberPanel.add(behindTextField);
        numberPanel.add(semicolonLabel);
        numberPanel.add(frontTextFiled);


        JLabel exportLabel = new JLabel("Export");
        JPanel exportPanel = new JPanel();
        exportPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,0,0));
        exportPanel.setPreferredSize(new Dimension((int)(0.3*width),(int)(0.1*height)));
        exportLabel.setFont(f1);
        exportPanel.add(exportLabel);

        bottomPanel.add(tipsPanel);
        bottomPanel.add(numberPanel);
        bottomPanel.add(exportPanel);

        mainPanel.add(bottomPanel);

        mainPanel.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(1000,700);
        JPanel jp = new ExportPanel(1000,700).mainPanel;
        jf.add(jp);
        jf.setVisible(true);
    }
}
