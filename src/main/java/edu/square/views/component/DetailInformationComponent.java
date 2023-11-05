package edu.square.views.component;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.MyView;
import edu.square.views.widget.BlockPanelWidget;
import edu.square.views.widget.TextFieldPanelWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class DetailInformationComponent extends MComponent {
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

    public DetailInformationComponent(Dimension parentFrameDimension) {
        super(parentFrameDimension, resizeDimensionWidthScale(parentFrameDimension, 0.38));


        //reminderStatusControllerPanel
        JPanel reminderStatusControllerPanel = reminderStatusControllerPanel();
        reminderStatusControllerPanel.setBackground(Color.red);
        mainPanel.add(reminderStatusControllerPanel);


        //TextPanel
        JPanel textPanelDetail = getFlowJpanel(FlowLayout.CENTER, resizeDimensionHeightScale(selfDimension, 0.1));
        textPanelDetail.add(labelBuilder("Detail", font2));
        mainPanel.add(textPanelDetail);

        //nameTextFieldPanelWidget
        nameTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, font2, font3, "Content:", 0.07);
        mainPanel.add(nameTextFieldPanelWidget.getPanel());

        //nameTextFieldPanelWidget
        noteTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, font2, font3, "Note:", 0.07);
        mainPanel.add(noteTextFieldPanelWidget.getPanel());

        //BlockPanel
        BlockPanelWidget blockPanelView = new BlockPanelWidget(selfDimension, 0.1);
        mainPanel.add(blockPanelView.getMainPanel());

//        //TextPanel
//        JPanel textPanelEarlyReminder = getFlowJpanel(FlowLayout.LEFT, resizeDimensionHeightScale(componentPanelDimension, 0.06));
//        textPanelEarlyReminder.add(labelBuilder("Early Reminder:", font2));
//        mainPanel.add(textPanelEarlyReminder);

        setColors();
    }

    public DetailInformationComponent(Dimension parentFrameDimension, MyView myView) {
        this(parentFrameDimension);
        myView.addMComponent(this);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = JPanelUtil.getCenterFlowMainPanel(selfDimension);
    }

    @Override
    protected void initializeFonts() {
        font1 = getBoldFont(parentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentDimension, FONT_SIZE_3);
    }

    @Override
    protected void initializeJComponents() {

    }

    private JButton buttonBuilder(String buttonName) {
        JButton button = new JButton(buttonName);
        button.setPreferredSize(new Dimension((int) (0.2 * selfDimension.width), (int) (0.04 * selfDimension.height)));
        button.setFont(font3);
        button.setBackground(Color.white);

        return button;
    }

    private JLabel labelBuilder(String labelName, Font font) {
        JLabel label = new JLabel(labelName);
        label.setFont(font);

        return label;
    }

    private JPanel reminderStatusControllerPanel() {
        JPanel reminderStatusControllerPanel = getFlowJpanel(FlowLayout.CENTER, resizeDimensionHeightScale(selfDimension, 0.1));

        JPanel deletePanel = getFlowJpanel(FlowLayout.LEFT, new Dimension((int) (0.48 * selfDimension.width), (int) (0.08 * selfDimension.height)), Color.orange);
        backButton = buttonBuilder("Back");
        deleteButton = buttonBuilder("Delete");
        deletePanel.add(backButton);
        deletePanel.add(deleteButton);

        reminderStatusControllerPanel.add(deletePanel);


        JPanel donePanel = getFlowJpanel(FlowLayout.RIGHT, new Dimension((int) (0.48 * selfDimension.width), (int) (0.08 * selfDimension.height)), Color.orange);
        resetButton = buttonBuilder("Rest");
        doneButton = buttonBuilder("Done");
        donePanel.add(resetButton);
        donePanel.add(doneButton);

        reminderStatusControllerPanel.add(donePanel);

        return reminderStatusControllerPanel;
    }

    @Override
    protected void setColors() {
        mainPanel.setBackground(Color.yellow);
    }
}