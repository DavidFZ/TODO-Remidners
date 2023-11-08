package edu.square.views.view1.component;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.widget.TextFieldPanelWidget;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getFlowJpanel;

public class DetailInformationComponentView extends MComponent {
    Font font1;
    Font font2;
    Font font3;
    @Getter
    private JButton deleteButton;
    @Getter
    private JButton resetButton;
    @Getter
    private JButton doneButton;
    @Getter
    private JButton backButton;

    private TextFieldPanelWidget contentTextFieldPanelWidget;
    private TextFieldPanelWidget noteTextFieldPanelWidget;

    public DetailInformationComponentView(Dimension parentFrameDimension, MyView myView) {
        super(myView, parentFrameDimension);
//        myView.addMComponent(this);
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                DetailInformationComponentView detailInformationComponentView = new DetailInformationComponentView(jFrame.getSize(), myView);
            }
        };
    }

    @Override
    protected void calculateSelfDimension() {
        selfDimension = resizeDimensionWidthScale(parentDimension, 0.38);
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = JPanelUtil.getCenterFlowMainPanel(selfDimension);
        mainPanel.setBackground(Color.yellow);
    }

    @Override
    protected void initializeFonts() {
        font1 = getBoldFont(parentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentDimension, FONT_SIZE_3);
    }

    @Override
    protected void initializeJComponents() {
        //reminderStatusControllerPanel
        JPanel reminderStatusControllerPanel = reminderStatusControllerPanel();
        reminderStatusControllerPanel.setBackground(Color.red);
        mainPanel.add(reminderStatusControllerPanel);


        //TextPanel
        JPanel textPanelDetail = getFlowJpanel(FlowLayout.CENTER, resizeDimensionHeightScale(selfDimension, 0.1));
        textPanelDetail.add(labelBuilder("Detail", font2));
        mainPanel.add(textPanelDetail);

        //nameTextFieldPanelWidget
        contentTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.07), "Content:");
        mainPanel.add(contentTextFieldPanelWidget.getMainPanel());

        //nameTextFieldPanelWidget
        noteTextFieldPanelWidget = new TextFieldPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.07), "Note:");
        mainPanel.add(noteTextFieldPanelWidget.getMainPanel());

        //BlockPanel
        BlockPanelWidget blockPanelView = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.1));
        mainPanel.add(blockPanelView.getMainPanel());
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
    protected void initializeView() {
        //default can not see
        mainPanel.setVisible(false);
    }

    public void setVisibility(boolean visibility) {
        mainPanel.setVisible(visibility);
    }

    public void setContentTextField(String content) {
        contentTextFieldPanelWidget.setTextField(content);
    }
    public void setNoteTextField(String note) {
        noteTextFieldPanelWidget.setTextField(note);
    }

    public String getContentTextField() {
        return contentTextFieldPanelWidget.getTextField().getText();
    }

    public String getNoteTextField() {
        return noteTextFieldPanelWidget.getTextField().getText();
    }
}