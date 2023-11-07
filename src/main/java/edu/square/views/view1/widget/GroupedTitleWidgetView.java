package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class GroupedTitleWidgetView extends MWidget {
    private final static double scaling = 0.4;
    Font font1;
    Font font2;
    Font font3;
    @Getter
    @Setter
    private JLabel titleLabel;
    @Getter
    @Setter
    private JButton addButton;

    public GroupedTitleWidgetView(Dimension rootFrameDimension, Dimension selfDimension) {
        super(rootFrameDimension, selfDimension);
    }

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(1000, 1000);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(jFrame.getSize(), jFrame.getSize());
        jFrame.add(groupedTitleWidgetView.getMainPanel());

        jFrame.setVisible(true);
    }

    @Override
    protected void setMainPanelFlowLayout(FlowLayout flowLayout) {
        mainPanel.setPreferredSize(selfDimension);

        flowLayout.setAlignment(FlowLayout.CENTER);
        flowLayout.setHgap(0);
        flowLayout.setVgap(0);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setPreferredSize(new Dimension((int) (scaling * rootFrameDimension.getWidth()), (int) (0.12 * rootFrameDimension.getHeight())));
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(rootFrameDimension, 0.05);
        font2 = FontUtil.getBoldFont(rootFrameDimension, 0.03);
        font3 = FontUtil.getBoldFont(rootFrameDimension, 0.008);
    }

    //TODO: 重构这坨答辩
    @Override
    protected void initializeJComponents() {
        //titlePanel_title
        JPanel titlePanel_title = new JPanel();
        titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
        titlePanel_title.setPreferredSize(new Dimension((int) (scaling * 0.48 * rootFrameDimension.getWidth()), (int) (0.11 * rootFrameDimension.getHeight())));
        titlePanel_title.setBackground(Color.blue);
        mainPanel.add(titlePanel_title);

        titleLabel = new JLabel("All");
        titleLabel.setFont(font1);
        titlePanel_title.add(titleLabel);

        //titlePanel_button
        JPanel titlePanel_button = new JPanel();
        titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
        titlePanel_button.setPreferredSize(new Dimension((int) (scaling * 0.48 * rootFrameDimension.getWidth()), (int) (0.11 * rootFrameDimension.getHeight())));
        titlePanel_button.setBackground(Color.yellow);
        mainPanel.add(titlePanel_button);


        addButton = new JButton("+");
        addButton.setFont(font2);
        addButton.setBackground(Color.white);
        addButton.setPreferredSize(new Dimension((int) (0.05 * rootFrameDimension.getWidth()), (int) (0.05 * rootFrameDimension.getWidth())));
        addButton.setVisible(true);
        titlePanel_button.add(addButton);
    }


}
