package edu.square.views.component;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.widget.TextFieldPanelWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class DetailInformationComponent {


    public final Dimension parentJComponentDimension;

    private final Dimension componentPanelDimension;
    private final JPanel mainPanel;
    Font font1;
    Font font2;
    Font font3;
    String[] options = {"None", "5 minutes before", "15 minutes before", "30 minutes before", "1 hour before", "2 hours before", "1 day before", "2 days before", "1 week before", "2 weeks before"};
    @Getter
    private JButton deleteButton;
    @Getter
    private JButton resetButton;
    @Getter
    private JButton doneButton;
    @Getter
    private JButton backButton;

    @Getter
    private TextFieldPanelWidget nameTextFieldPanelWidget;
    @Getter
    private TextFieldPanelWidget noteTextFieldPanelWidget;

    public DetailInformationComponent(JFrame parentFrame) {
        parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        componentPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.38);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);

        //set MainPanel
        mainPanel = JPanelUtil.getMainPanel(componentPanelDimension);
        mainPanel.setBackground(Color.yellow);

        //reminderStatusControllerPanel
        mainPanel.add(reminderStatusControllerPanel());


        //TextPanel

        JPanel textPanelDetail = getFlowJpanel(FlowLayout.CENTER, resizeDimensionHeightScale(componentPanelDimension, 0.1));
        JLabel detailLabel = new JLabel("Detail");
        detailLabel.setFont(font2);
        textPanelDetail.add(detailLabel);
        mainPanel.add(textPanelDetail);

        //nameTextFieldPanelWidget
        nameTextFieldPanelWidget = new TextFieldPanelWidget(componentPanelDimension, font2, font3, "Content:", 0.07);
        mainPanel.add(nameTextFieldPanelWidget.getPanel());

        //nameTextFieldPanelWidget
        noteTextFieldPanelWidget = new TextFieldPanelWidget(componentPanelDimension, font2, font3, "Note:", 0.07);
        mainPanel.add(noteTextFieldPanelWidget.getPanel());


//        //BlockPanel
//        {
//            BlockPanelWidget blockPanelView = new BlockPanelWidget(componentPanelDimension, 0.1);
//            mainPanel.add(blockPanelView.getBlockPanel());
//        }
//        //TextPanel
//        {
//            JPanel textPanelEarlyReminder = new JPanel();
//            textPanelEarlyReminder.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.06));
//            textPanelEarlyReminder.setLayout(new FlowLayout(FlowLayout.LEFT));
//            JLabel detailLabel = new JLabel("Early Reminder:");
//            detailLabel.setFont(font2);
//            textPanelEarlyReminder.add(detailLabel);
//            mainPanel.add(textPanelEarlyReminder);
//        }
//        //earlyReminderComboBoxPanel
//        {
//            ComboBoxPanelView earlyReminderComboBoxPanel = new ComboBoxPanelView(componentPanelDimension, 0.07, font3, options, Color.cyan);
//            mainPanel.add(earlyReminderComboBoxPanel.getjPanel());
//        }
//        //TextPanel
//        {
//            JPanel textPanelRepeat = new JPanel();
//            textPanelRepeat.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.06));
//            textPanelRepeat.setLayout(new FlowLayout(FlowLayout.LEFT));
//            JLabel detailLabel = new JLabel("Repeat:");
//            detailLabel.setFont(font2);
//            textPanelRepeat.add(detailLabel);
//            mainPanel.add(textPanelRepeat);
//        }
//        //repeatPanel
//        {
//            ComboBoxPanelView repeatComboBoxPanel = new ComboBoxPanelView(componentPanelDimension, 0.07, font3, options, Color.cyan);
//            mainPanel.add(repeatComboBoxPanel.getjPanel());
//        }

    }

    //清空输入内容
    public void clear() {

    }

    public void pushInformation() {
        //TODO do something to deliver information to DB
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }

    private JButton buttonBuilder(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setPreferredSize(new Dimension((int) (0.2 * componentPanelDimension.width), (int) (0.04 * componentPanelDimension.height)));
        button.setFont(font3);
        button.setBackground(Color.white);

        return button;
    }

    private JPanel reminderStatusControllerPanel() {
        JPanel reminderStatusControllerPanel = new JPanel();
        reminderStatusControllerPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        reminderStatusControllerPanel.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.1));
        reminderStatusControllerPanel.setBackground(Color.green);


        JPanel deletePanel = getFlowJpanel(FlowLayout.LEFT, new Dimension((int) (0.48 * componentPanelDimension.width), (int) (0.08 * componentPanelDimension.height)), Color.orange);
        backButton = buttonBuilder("Back");
        backButton.addActionListener(e -> {
            mainPanel.setVisible(false);
        });
        deleteButton = buttonBuilder("Delete");
        deletePanel.add(backButton);
        deletePanel.add(deleteButton);

        reminderStatusControllerPanel.add(deletePanel);


        JPanel donePanel = getFlowJpanel(FlowLayout.RIGHT, new Dimension((int) (0.48 * componentPanelDimension.width), (int) (0.08 * componentPanelDimension.height)), Color.orange);
        resetButton = buttonBuilder("Rest");
        doneButton = buttonBuilder("Done");
        donePanel.add(resetButton);
        donePanel.add(doneButton);

        reminderStatusControllerPanel.add(donePanel);

        return reminderStatusControllerPanel;
    }

}