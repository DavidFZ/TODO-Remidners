package edu.square.views.component;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.widget.GroupLabelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;

public class LeftSideView {

    JFrame mainFrame;
    JPanel leftGroupView;

    int mainFrameWidth;

    int mainFrameHeight;

    JLabel todayLabel;

    JLabel CompletedLabel;

    JLabel allLabel;
    JLabel flaggedLabel;
    Font font1;
    Font font2;
    Font font3;

    public LeftSideView(JFrame mainFrame) {
        this.mainFrame = mainFrame;
        font1 = new Font("宋体", Font.BOLD, (int) (0.03 * mainFrame.getWidth()));
        font2 = new Font("宋体", Font.BOLD, (int) (0.02 * mainFrame.getWidth()));
        font3 = new Font("宋体", Font.BOLD, (int) (0.01 * mainFrame.getWidth()));
        mainFrameWidth = (int) (mainFrame.getWidth() * 0.2);
        mainFrameHeight = mainFrame.getHeight();
        init();
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

    private void init() {
        //leftGroupView
        leftGroupView = new JPanel();
        leftGroupView.setLayout(new FlowLayout(FlowLayout.CENTER));
        leftGroupView.setPreferredSize(new Dimension(mainFrameWidth, mainFrameHeight));
        leftGroupView.setBackground(Color.green);

        //        searchTipsPanel
        {
            JPanel searchTipsPanel = new JPanel();
            searchTipsPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
            searchTipsPanel.setPreferredSize(new Dimension(mainFrameWidth, (int) (0.07 * mainFrameHeight)));
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
            searchPanel.setPreferredSize(new Dimension(mainFrameWidth, (int) (0.05 * mainFrameHeight)));
            searchPanel.setBackground(Color.BLACK);
            leftGroupView.add(searchPanel);

            JTextField searchText = new JTextField();
            searchText.setPreferredSize(new Dimension((int) (0.8 * mainFrameWidth), (int) (0.04 * mainFrameHeight)));
            searchText.setFont(font2);
            searchPanel.add(searchText);


        }
        //blockPanel
        {
            JPanel blockPanel = new JPanel();
            blockPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
            blockPanel.setPreferredSize(new Dimension(mainFrameWidth, (int) (0.2 * mainFrameHeight)));
//            blockPanel.setBackground(Color.red);
            leftGroupView.add(blockPanel);
        }

        //TODO: use Encapsulated class

        GroupLabelView groupLabelViewAll = new GroupLabelView(resizeDimensionWidthScale(mainFrame.getSize(), 0.2), "All");
        leftGroupView.add(groupLabelViewAll.getGroupView());

        GroupLabelView groupLabelViewToday = new GroupLabelView(resizeDimensionWidthScale(mainFrame.getSize(), 0.2), "Today");
        leftGroupView.add(groupLabelViewToday.getGroupView());

        GroupLabelView groupLabelViewCompleted = new GroupLabelView(resizeDimensionWidthScale(mainFrame.getSize(), 0.2), "Completed");
        leftGroupView.add(groupLabelViewCompleted.getGroupView());

        GroupLabelView groupLabelViewFlagged = new GroupLabelView(resizeDimensionWidthScale(mainFrame.getSize(), 0.2), "Flagged");
        leftGroupView.add(groupLabelViewFlagged.getGroupView());
    }

    public JPanel getLeftPanel() {
        return leftGroupView;
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
