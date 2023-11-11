package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import static edu.square.utils.ColorChangeUtil.getColorListener;
import static edu.square.utils.UIUtils.ComponentResizeUtil.*;

public class GroupLabelWidget extends MWidget {
    private static final Font DEFAULT_FONT = FontUtil.getBoldFont(20);
    private JLabel groupTitleLabel;
    private JLabel countLabel;


    public GroupLabelWidget(Dimension parentDimension, Dimension selfDimension, String title) {
        super(parentDimension, selfDimension);
        groupTitleLabel.setText(title);
    }

    public String getGroupLabelText(){
        return groupTitleLabel.getText();
    }

    public void setGroupViewCount(int count) {
        countLabel.setText(String.valueOf(count));
    }

    public void setGroupViewTitle(String title) {
        groupTitleLabel.setText(title);
    }


    public void addMouseListener(MouseListener mouseListener) {
        mainPanel.addMouseListener(mouseListener);
        mainPanel.addMouseListener(getColorListener(mainPanel,mainPanel.getBackground(), new Color(81,196,211)));
    }

    public void repaint() {
        mainPanel.validate();
        mainPanel.repaint();
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(selfDimension);
        mainPanel.setBackground(new Color(198,230,232));
    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {
        groupTitleLabel = new JLabel();
        groupTitleLabel.setFont(DEFAULT_FONT);
        groupTitleLabel.setBackground(new Color(81,196,211));
        groupTitleLabel.setPreferredSize(resizeDimensionWidthScale(selfDimension, 0.6));

        countLabel = new JLabel("0");
        countLabel.setPreferredSize(resizeDimensionWidthScale(selfDimension, 0.2));
        countLabel.setFont(DEFAULT_FONT);
        mainPanel.add(groupTitleLabel);
        mainPanel.add(countLabel);
        repaint();
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
