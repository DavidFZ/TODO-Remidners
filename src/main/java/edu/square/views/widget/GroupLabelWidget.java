package edu.square.views.widget;

import edu.square.utils.UIUtils.FontUtil;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

public class GroupLabelWidget {
    private static final Font DEFAULT_FONT = FontUtil.getBoldFont(20);
    private final JLabel groupTitleLabel;
    private final JLabel countLabel;
    @Getter
    private JPanel mainPanel;


    public GroupLabelWidget(Dimension dimension, String title) {
        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        countLabel = new JLabel("0");

        int parentFrameWidth = (int) dimension.getWidth();
        int parentFrameHeight = (int) dimension.getHeight();

        mainPanel.setPreferredSize(new Dimension(parentFrameWidth, (int) (0.1 * parentFrameHeight)));
        mainPanel.setBackground(Color.red);

        groupTitleLabel = new JLabel(title);
        groupTitleLabel.setFont(DEFAULT_FONT);
        groupTitleLabel.setPreferredSize(new Dimension((int) (0.6 * parentFrameWidth), (int) (0.1 * parentFrameHeight)));
        mainPanel.add(groupTitleLabel);

        countLabel.setFont(DEFAULT_FONT);
        mainPanel.add(countLabel);
    }

    public void setGroupViewCount(int count) {
        countLabel.setText(String.valueOf(count));
    }

    public void setGroupViewTitle(String title) {
        groupTitleLabel.setText(title);
    }


    public void addMouseListener(MouseListener mouseListener) {
        mainPanel.addMouseListener(mouseListener);
    }

    public void repaint() {
        mainPanel.validate();
        mainPanel.repaint();
    }

    public static class ViewBuilder {
        private Dimension parentDimension;

        public ViewBuilder(Dimension parentDimension) {
            this.parentDimension = parentDimension;
        }

        public GroupLabelWidget build(String title) {
            return new GroupLabelWidget(parentDimension, title);
        }

        public List<GroupLabelWidget> build(List<String> titles) {
            List<GroupLabelWidget> list = new ArrayList<>(titles.size());
            for (String title : titles)
                list.add(new GroupLabelWidget(parentDimension, title));
            return list;
        }
    }

}
