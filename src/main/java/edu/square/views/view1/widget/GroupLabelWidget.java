package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.*;

public class GroupLabelWidget extends MWidget {
    private static final Font DEFAULT_FONT = FontUtil.getBoldFont(20);
    private JLabel groupTitleLabel;
    private JLabel countLabel;

    private String title;

    public GroupLabelWidget(Dimension parentDimension, Dimension selfDimension, String title) {
        super(parentDimension, selfDimension);
        this.title = title;
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

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setBackground(Color.red);
    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {
        groupTitleLabel = new JLabel(title);
        groupTitleLabel.setFont(DEFAULT_FONT);
        groupTitleLabel.setBackground(Color.black);
        groupTitleLabel.setPreferredSize(resizeDimensionWidthScale(selfDimension, 0.6));
        mainPanel.add(groupTitleLabel);

        countLabel = new JLabel("0");
        countLabel.setPreferredSize(resizeDimensionWidthScale(selfDimension, 0.2));
        countLabel.setFont(DEFAULT_FONT);
        mainPanel.add(countLabel);
    }

    public static class ViewBuilder {
        private Dimension selfDimension;

        public ViewBuilder(Dimension selfDimension) {
            this.selfDimension = selfDimension;
        }

        public GroupLabelWidget build(String title) {
            return new GroupLabelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.22), title);//设置高度
        }

        public List<GroupLabelWidget> build(List<String> titles) {
            List<GroupLabelWidget> list = new ArrayList<>(titles.size());
            for (String title : titles)
                list.add(new GroupLabelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.22), title));
            return list;
        }
    }

}
