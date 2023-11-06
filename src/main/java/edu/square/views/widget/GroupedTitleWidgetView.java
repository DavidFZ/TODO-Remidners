package edu.square.views.widget;

import edu.square.utils.UIUtils.FontUtil;

import javax.swing.*;
import java.awt.*;

public class GroupedTitleWidgetView extends MWidget {
    private final static double scaling = 0.4;
    Font font1;
    Font font2;
    Font font3;

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

    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(rootFrameDimension, 0.05);
        font2 = FontUtil.getBoldFont(rootFrameDimension, 0.03);
        font3 = FontUtil.getBoldFont(rootFrameDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        titlePanel.setPreferredSize(new Dimension((int) (scaling * rootFrameDimension.getWidth()), (int) (0.12 * rootFrameDimension.getHeight())));
        mainPanel.add(titlePanel);

        //titlePanel_title
        JPanel titlePanel_title = new JPanel();
        titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
        titlePanel_title.setPreferredSize(new Dimension((int) (scaling * 0.48 * rootFrameDimension.getWidth()), (int) (0.11 * rootFrameDimension.getHeight())));
        titlePanel_title.setBackground(Color.blue);
        titlePanel.add(titlePanel_title);

        JLabel titleLabel = new JLabel("All");
        titleLabel.setFont(font1);
        titlePanel_title.add(titleLabel);

        //titlePanel_button
        JPanel titlePanel_button = new JPanel();
        titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
        titlePanel_button.setPreferredSize(new Dimension((int) (scaling * 0.48 * rootFrameDimension.getWidth()), (int) (0.11 * rootFrameDimension.getHeight())));
        titlePanel_button.setBackground(Color.yellow);
        titlePanel.add(titlePanel_button);


        JButton addButton = new JButton("+");
        addButton.setFont(font2);
        addButton.setBackground(Color.white);
        addButton.setPreferredSize(new Dimension((int) (0.05 * rootFrameDimension.getWidth()), (int) (0.05 * rootFrameDimension.getWidth())));
        addButton.setVisible(true);
        titlePanel_button.add(addButton);
    }
}
