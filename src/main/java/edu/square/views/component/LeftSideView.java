package edu.square.views.component;

import edu.square.utils.UIUtils.JFrameFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class LeftSideView {

    JFrame parentFrame;
    JPanel leftGroupView;

    int parentFrameWidth;

    int parentFrameHeight;

    JLabel todayLable;

    JLabel CompletedLabel;

    JLabel allLabel;
    JLabel flaggedLabel;
    Font font1;
    Font font2;
    Font font3;

    public LeftSideView(JFrame parentFrame) {
        this.parentFrame = parentFrame;
        font1 = new Font("宋体", Font.BOLD, (int) (0.03 * parentFrame.getWidth()));
        font2 = new Font("宋体", Font.BOLD, (int) (0.02 * parentFrame.getWidth()));
        font3 = new Font("宋体", Font.BOLD, (int) (0.01 * parentFrame.getWidth()));
        parentFrameWidth = (int) (parentFrame.getWidth() * 0.2);
        parentFrameHeight = parentFrame.getHeight();
        init();
    }

    private void init() {
        //leftGroupView
        leftGroupView = new JPanel();
        leftGroupView.setLayout(new FlowLayout(FlowLayout.CENTER));
        leftGroupView.setPreferredSize(new Dimension(parentFrameWidth, parentFrameHeight));
        leftGroupView.setBackground(Color.green);
//        searchTipsPanel
        {
            JPanel searchTipsPanel = new JPanel();
            searchTipsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            searchTipsPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.07 * parentFrameHeight)));
            searchTipsPanel.setBackground(Color.yellow);

            JLabel searchTips = new JLabel("search:");
            searchTips.setFont(font1);
            searchTipsPanel.add(searchTips);
            leftGroupView.add(searchTipsPanel);

        }
//        searchPanel
        {
            JPanel searchPanel = new JPanel();
            searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            searchPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.05 * parentFrameHeight)));
            searchPanel.setBackground(Color.BLACK);
            leftGroupView.add(searchPanel);

            JTextField searchText = new JTextField();
            searchText.setPreferredSize(new Dimension((int) (0.8 * parentFrameWidth), (int) (0.04 * parentFrameHeight)));
            searchText.setFont(font2);
            searchPanel.add(searchText);


        }
        //blockPanel
        {
            JPanel blockPanel = new JPanel();
            blockPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            blockPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.2 * parentFrameHeight)));
//            blockPanel.setBackground(Color.red);
            leftGroupView.add(blockPanel);
        }

        //todayPanel
        {
            JPanel todayPanel = new JPanel();
            todayPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            todayPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.1 * parentFrameHeight)));
            todayPanel.setBackground(Color.red);
            leftGroupView.add(todayPanel);

            JLabel todayTipsLable = new JLabel("Today");
            todayTipsLable.setFont(font2);
            todayTipsLable.setPreferredSize(new Dimension((int) (0.6 * parentFrameWidth), (int) (0.1 * parentFrameHeight)));
            todayPanel.add(todayTipsLable);

            todayLable = new JLabel("0");
            todayLable.setFont(font2);
            todayPanel.add(todayLable);

            todayPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //TODO 添加today点击的事件
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
        //Completed
        {
            JPanel CompletedPanel = new JPanel();
            CompletedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            CompletedPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.1 * parentFrameHeight)));
            CompletedPanel.setBackground(Color.red);
            leftGroupView.add(CompletedPanel);

            JLabel CompletedTipsLable = new JLabel("Completed");
            CompletedTipsLable.setFont(font2);
            CompletedTipsLable.setPreferredSize(new Dimension((int) (0.6 * parentFrameWidth), (int) (0.1 * parentFrameHeight)));
            CompletedPanel.add(CompletedTipsLable);

            CompletedLabel = new JLabel("0");
            CompletedLabel.setFont(font2);
            CompletedPanel.add(CompletedLabel);

            CompletedPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //TODO 添加Completed点击的事件
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }


        //All
        {
            JPanel allPanel = new JPanel();
            allPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            allPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.1 * parentFrameHeight)));
            allPanel.setBackground(Color.red);
            leftGroupView.add(allPanel);

            JLabel allTipsLable = new JLabel("All");
            allTipsLable.setFont(font2);
            allTipsLable.setPreferredSize(new Dimension((int) (0.6 * parentFrameWidth), (int) (0.1 * parentFrameHeight)));
            allPanel.add(allTipsLable);

            allLabel = new JLabel("0");
            allLabel.setFont(font2);
            allPanel.add(allLabel);

            allPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //TODO 添加All点击的事件
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }
//        Flagged
        {
            JPanel flaggedPanel = new JPanel();
            flaggedPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            flaggedPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.1 * parentFrameHeight)));
            flaggedPanel.setBackground(Color.red);
            leftGroupView.add(flaggedPanel);

            JLabel allTipsLable = new JLabel("flagged");
            allTipsLable.setFont(font2);
            allTipsLable.setPreferredSize(new Dimension((int) (0.6 * parentFrameWidth), (int) (0.1 * parentFrameHeight)));
            flaggedPanel.add(allTipsLable);

            flaggedLabel = new JLabel("0");
            flaggedLabel.setFont(font2);
            flaggedPanel.add(flaggedLabel);

            flaggedPanel.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    //TODO 添加Flagged点击的事件
                }

                @Override
                public void mousePressed(MouseEvent e) {

                }

                @Override
                public void mouseReleased(MouseEvent e) {

                }

                @Override
                public void mouseEntered(MouseEvent e) {

                }

                @Override
                public void mouseExited(MouseEvent e) {

                }
            });
        }


    }



    public JPanel getLeftPanel() {
        return leftGroupView;
    }

    public static void main(String[] args) {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        LeftSideView leftSideView = new LeftSideView(jFrame);
        JPanel panel = leftSideView.getLeftPanel();
        jFrame.add(panel);
        jFrame.setVisible(true);
    }

    //TODO: Encapsulate this class
    public class ListGroupView {
        private JPanel panel;
        private JLabel itemNumberOfGroup;
        private JLabel flaggedItemLabel;
        //TODO: find icon resource
        private JLabel icon;






    }
}
