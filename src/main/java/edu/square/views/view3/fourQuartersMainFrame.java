package edu.square.views.view3;
import javax.swing.*;
import java.awt.*;

public class fourQuartersMainFrame extends JFrame {
    JFrame mainFrame = new JFrame();
    JPanel titlePanel;
    JPanel reminderPanel;
    String[] s = {"TODAY","TOMORROW","TWO DAYS LATTER","THREE DAYS LATTER","FOUR DAYS LATTER","FIVE DAYS LATTER","SIX DAYS LATTER"};
    fourQuartersMainFrame(){
        mainFrame.setSize(500,1000);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        titlePanel = new TitlePanel("FOUR QUARTERS",s,500,100);
        reminderPanel = new JPanel();
        reminderPanel.setPreferredSize(new Dimension(500,850));
        reminderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        //更具实际屏幕调整大小
        JPanel importantAndUrgentPanel = new QuarterPanel("important and emergency",225,370);
        JPanel importantButNotUrgentPanel = new QuarterPanel("important but not urgent",225,370);
        JPanel notImportantButUrgentPanel = new QuarterPanel("not important but urgent",225,370);
        JPanel notImportantAndNotUrgentPanel = new QuarterPanel("not urgent and not important",225,370);
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
        JFrame jf = new fourQuartersMainFrame().mainFrame;
        jf.setVisible(true);
    }
}
