package edu.square.views.component;

import edu.square.utils.UIUtils.JFrameAttribute;
import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;

public class LeftSideView {
    public static void main(String[] args) {
        //build a main frame
        JFrame leftMainFrame = JFrameFactory.buildJFrame(JFrameAttribute.getDefaultAttribute(0.2,""));
        leftMainFrame.setSize((int)(leftMainFrame.getWidth()),(int)(4*leftMainFrame.getWidth()));
        leftMainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        //edit panel
        JPanel editPanel;
        JButton editButton;
        {
            editPanel = new JPanel();
            editPanel.setPreferredSize(new Dimension((int)(0.95*leftMainFrame.getWidth()),50));
            editPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            editButton = new JButton("EDIT");
            editButton.setPreferredSize(new Dimension(60,40));
            editButton.setFocusPainted(false);
            //transparent
            editButton.setContentAreaFilled(false);
        }
        editPanel.add(editButton);
        leftMainFrame.add(editPanel);

        //search panel
        JPanel searchPanel;
        JLabel searchTips;
        JTextField searchText;
        {
            searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
            searchPanel.setPreferredSize(new Dimension((int)(0.98*leftMainFrame.getWidth()),60));
            searchTips = new JLabel("search");
            Font font2 = new Font("宋体", Font.BOLD, (int) (0.04 * leftMainFrame.getWidth()));
            searchTips.setFont(font2);
            searchText = new JTextField(20);
            searchPanel.add(searchTips);
            searchPanel.add(searchText);

        }
        leftMainFrame.add(searchPanel);

        //the manager of items
        JPanel itemManager;

        JPanel todayPanel;
        JButton searchTodayButton;
        JTextField numberOfTodayItem;
        JLabel todayItemLabel;

        JPanel completedPanel;
        JButton searchCompletedButton;
        JTextField numberOfCompletedItem;
        JLabel completedItemLabel;

        JPanel allPanel;
        JButton searchAllButton;
        JTextField numberOfAllItem;
        JLabel allItemLabel;

        JPanel flaggedPanel;
        JButton searchFlaggedItem;
        JTextField numberOfFlagged;
        JLabel flaggedItemLabel;

        Font fnTitle = new Font("宋体",Font.BOLD,20);
        Font fnButton = new Font("宋体",Font.BOLD,15);



        {
            itemManager = new JPanel(new FlowLayout());
            itemManager.setPreferredSize(new Dimension((int)(1* leftMainFrame.getWidth()),(int)(1.4 * leftMainFrame.getWidth())));
            //itemManager.setBackground(Color.WHITE);
            //four blocks of items

            //today
            todayPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            todayPanel.setBackground(Color.WHITE);
            todayPanel.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.45 * leftMainFrame.getWidth())));
            todayItemLabel = new JLabel("Today");
            todayItemLabel.setFont(fnTitle);

            numberOfTodayItem = new JTextField(3);

            Panel meanlessT = new Panel();
            meanlessT.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.2 * leftMainFrame.getWidth())));

            searchTodayButton = new JButton("search");
            searchTodayButton.setFont(fnButton);

            todayPanel.add(todayItemLabel);
            todayPanel.add(numberOfTodayItem);
            todayPanel.add(meanlessT);
            todayPanel.add(searchTodayButton);


            //completed
            completedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            completedPanel.setBackground(Color.WHITE);
            completedPanel.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.45 * leftMainFrame.getWidth())));
            completedItemLabel = new JLabel("Completed");
            completedItemLabel.setFont(fnTitle);

            Panel meanlessC = new Panel();
            meanlessC.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.2 * leftMainFrame.getWidth())));

            numberOfCompletedItem = new JTextField(3);

            searchCompletedButton = new JButton("search");
            searchCompletedButton.setFont(fnButton);

            completedPanel.add(completedItemLabel);
            completedPanel.add(numberOfCompletedItem);
            completedPanel.add(meanlessC);
            completedPanel.add(searchCompletedButton);

            //All
            allPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            allPanel.setBackground(Color.WHITE);
            allPanel.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.45 * leftMainFrame.getWidth())));
            allItemLabel = new JLabel("All");
            allItemLabel.setFont(fnTitle);

            Panel meanlessA = new Panel();
            meanlessA.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.2 * leftMainFrame.getWidth())));

            numberOfAllItem = new JTextField(3);

            searchAllButton = new JButton("search");
            searchAllButton.setFont(fnButton);

            allPanel.add(allItemLabel);
            allPanel.add(numberOfAllItem);
            allPanel.add(meanlessA);
            allPanel.add(searchAllButton);

            //flagged
            flaggedPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
            flaggedPanel.setBackground(Color.WHITE);
            flaggedPanel.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.45 * leftMainFrame.getWidth())));

            flaggedItemLabel = new JLabel("Flagged");
            flaggedItemLabel.setFont(fnTitle);

            numberOfFlagged = new JTextField(3);

            Panel meanlessF = new Panel();
            meanlessF.setPreferredSize(new Dimension((int)(0.45 * leftMainFrame.getWidth()),(int)(0.2 * leftMainFrame.getWidth())));

            searchFlaggedItem = new JButton("search");
            searchFlaggedItem.setFont(fnButton);

            flaggedPanel.add(flaggedItemLabel);
            flaggedPanel.add(numberOfFlagged);
            flaggedPanel.add(meanlessF);
            flaggedPanel.add(searchFlaggedItem);



        }
        itemManager.add(todayPanel);
        itemManager.add(completedPanel);
        itemManager.add(allPanel);
        itemManager.add(flaggedPanel);
        leftMainFrame.add(itemManager);








        leftMainFrame.setVisible(true);


    }
}
