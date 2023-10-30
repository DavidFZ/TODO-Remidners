package edu.square.views.view3;
import javax.swing.*;
import java.awt.*;

public class fourQuartersMainFrame extends JFrame {
    int width,height;
    JFrame mainFrame = new JFrame();
    JPanel titlePanel;
    JPanel reminderPanel;
    String[] s = {"TODAY","TOMORROW","TWO DAYS LATTER","THREE DAYS LATTER","FOUR DAYS LATTER","FIVE DAYS LATTER","SIX DAYS LATTER"};
    fourQuartersMainFrame(int width,int height){
        this.width = width;
        this.height = height;
        mainFrame.setSize(width,height);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT,0,0));
        titlePanel = new TitlePanel("FOUR QUARTERS",s,width,(int)(0.1*height));
        reminderPanel = new JPanel();
        reminderPanel.setPreferredSize(new Dimension(width,(int)(0.8*height)));
        reminderPanel.setLayout(new FlowLayout(FlowLayout.LEFT,(int)(0.03*width),(int)(0.015*height)));
        reminderPanel.setBackground(Color.RED);
        //更具实际屏幕调整大小
        JPanel importantAndUrgentPanel = new QuarterPanel("important and emergency",(int)(0.5*(width - 0.09*width)),(int)(0.4*(height - 0.06*height)));
        JPanel importantButNotUrgentPanel = new QuarterPanel("important but not urgent",(int)(0.5*(width - 0.09*width)),(int)(0.4*(height - 0.06*height)));
        JPanel notImportantButUrgentPanel = new QuarterPanel("not important but urgent",(int)(0.5*(width - 0.09*width)),(int)(0.4*(height - 0.06*height)));
        JPanel notImportantAndNotUrgentPanel = new QuarterPanel("not urgent and not important",(int)(0.5*(width - 0.09*width)),(int)(0.4*(height - 0.06*height)));
//        importantAndUrgentPanel.setPreferredSize(new Dimension(200,350));
//        importantButNotUrgentPanel.setPreferredSize(new Dimension(200,350));
//        notImportantButUrgentPanel.setPreferredSize(new Dimension(200,350));
//        notImportantAndNotUrgentPanel.setPreferredSize(new Dimension(200,350));
        reminderPanel.add(importantAndUrgentPanel);
        reminderPanel.add(importantButNotUrgentPanel);
        reminderPanel.add(notImportantButUrgentPanel);
        reminderPanel.add(notImportantAndNotUrgentPanel);
        mainFrame.add(titlePanel);
        mainFrame.add(reminderPanel);
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        JFrame jf = new fourQuartersMainFrame(500,1000).mainFrame;
        jf.setVisible(true);
    }
}