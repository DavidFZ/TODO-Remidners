package edu.square.views.component;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view.MyView;
import edu.square.views.widget.GroupedTitleWidgetView;
import edu.square.views.widget.ReminderListWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class GroupedListComponent extends MComponent {
    private final double scaling = 0.4;
    //font定义
    Font font1;
    Font font2;
    Font font3;
    @Getter
    JButton addButton;
    @Getter
    private ReminderListWidgetView reminderListWidgetView;
    //root Frame
    @Getter
    private JPanel mainPanel;
    @Getter
    private JLabel titleLabel;
    @Getter
    private JFrame printFrame;
    @Getter
    private JButton confirmButton;


    public GroupedListComponent(Dimension rootFrameDimension, MyView myView) {
        super(myView,rootFrameDimension);
    }

    public static void main(String[] args) {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(0.8d, "GroupedListComponentTest");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        MyView myView = new MyView(jFrame,jFrame.getSize());
        GroupedListComponent groupedListComponent = new GroupedListComponent(jFrame.getSize(),myView);

//        jFrame.add(groupedListComponent.getMainPanel());
        jFrame.setVisible(true);

    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, scaling);
    }

    @Override
    protected void initializeMainPanel() {
        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER, 0, 0);
        mainPanel = getFlowJpanel(flowLayout, selfDimension);
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(parentDimension, 0.05);
        font2 = FontUtil.getBoldFont(parentDimension, 0.03);
        font3 = FontUtil.getBoldFont(parentDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {
        //GROUP TITLE
        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(parentDimension, selfDimension);
        mainPanel.add(groupedTitleWidgetView.getMainPanel());

        //GROUP LABEL
        reminderListWidgetView = new ReminderListWidgetView(parentDimension,selfDimension);
        mainPanel.add(reminderListWidgetView.getScrollPane());
    }

    //TODO: encapsulate this method as a widget
    public void init() {
        mainPanel = new JPanel();
        confirmButton = new JButton("confirm");
        // Instantiate a button in advance
        // Void null pointer exception when add reminder insert confirm listener


        //对齐方式
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        mainPanel.setPreferredSize(new Dimension((int) (scaling * parentDimension.getWidth()), (int) parentDimension.getHeight()));

        //titlePanel
        {
            JPanel titlePanel = new JPanel();
            titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
            titlePanel.setPreferredSize(new Dimension((int) (scaling * parentDimension.getWidth()), (int) (0.12 * parentDimension.getHeight())));
//            titlePanel.setBackground(Color.black);
            mainPanel.add(titlePanel);
            //titlePanel_title
            JPanel titlePanel_title = new JPanel();
            titlePanel_title.setLayout(new FlowLayout(FlowLayout.LEFT));
            titlePanel_title.setPreferredSize(new Dimension((int) (scaling * 0.48 * parentDimension.getWidth()), (int) (0.11 * parentDimension.getHeight())));
            titlePanel_title.setBackground(Color.blue);
            titlePanel.add(titlePanel_title);

            titleLabel = new JLabel("All");
            titleLabel.setFont(font1);
            titlePanel_title.add(titleLabel);

            //titlePanel_button
            JPanel titlePanel_button = new JPanel();
            titlePanel_button.setLayout(new FlowLayout(FlowLayout.RIGHT));
            titlePanel_button.setPreferredSize(new Dimension((int) (scaling * 0.48 * parentDimension.getWidth()), (int) (0.11 * parentDimension.getHeight())));
            titlePanel_button.setBackground(Color.yellow);
            titlePanel.add(titlePanel_button);

            addButton = new JButton("+");
            addButton.setFont(font2);
            addButton.setBackground(Color.white);
            addButton.setPreferredSize(new Dimension((int) (0.05 * parentDimension.getWidth()), (int) (0.05 * parentDimension.getWidth())));
            addButton.setVisible(true);
            titlePanel_button.add(addButton);

        }

    }

    @Override
    protected void setColors() {

    }
}
