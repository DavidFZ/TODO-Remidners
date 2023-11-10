package edu.square.views.view1.subframe;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.view1.widget.ComboBoxPanelWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class AddReminderConfirmFrameView {
    @Getter
    private final JFrame mainFrame;

    public AddReminderConfirmFrameView(Dimension selfDimension) {
        Font font1 = FontUtil.getBoldFont(selfDimension, 0.05);

        mainFrame = JFrameFactory.buildJFrame(selfDimension, "Please add Reminder");
        mainFrame.setLayout(new BorderLayout());

//        //inputPanel
//        JLabel inputLabel = new JLabel("Reminder Content");
//        inputLabel.setFont(font1);
//        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//
//        inputPanel.setBackground(Color.green);
//        inputPanel.add(inputLabel);
//
//        itemName = new JTextField();
//        itemName.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.9, 0.1));
//
//        BlockPanelWidget blockPanelWidget0 = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.1));
//
//        JLabel tipsLabel = new JLabel("Set Reminder Time");
//        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.1));
//        tipsLabel.setFont(FontUtil.getBoldFont(selfDimension, FontUtil.FONT_SIZE_1));
//
//
//        yearsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "year:", java.util.List.of(years));
//        monthsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "month:", java.util.List.of(months));
//        datesComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "day:", java.util.List.of(days));
//        hoursComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(selfDimension, resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.07), "hour:", List.of(hours));
//        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(selfDimension, resizeDimensionHeightScale(selfDimension, 0.05));
//
//        flagRadio = new JRadioButton("Flagged");
//
//        JPanel detailMessagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
//        detailMessagePanel.add(blockPanelWidget.getMainPanel());
//        detailMessagePanel.add(itemName);
//        detailMessagePanel.add(blockPanelWidget0.getMainPanel());
//        detailMessagePanel.add(tipsLabel);
//        detailMessagePanel.add(yearsComboBoxPanelWidgetView.getMainPanel());
//        detailMessagePanel.add(monthsComboBoxPanelWidgetView.getMainPanel());
//        detailMessagePanel.add(datesComboBoxPanelWidgetView.getMainPanel());
//        detailMessagePanel.add(hoursComboBoxPanelWidgetView.getMainPanel());
//        detailMessagePanel.add(blockPanelWidget.getMainPanel());
//
//        detailMessagePanel.add(flagRadio);
//
//        confirmButton = new JButton("Confirm");
//        JPanel confirmPanel = new JPanel(new BorderLayout());
//        //while input Enter will be same as click confirm button
//        confirmPanel.add(confirmButton);
//
//        //parent frame will not close when sub frame is closed
//        mainFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//        mainFrame.add(BorderLayout.NORTH, inputPanel);
//        mainFrame.add(BorderLayout.CENTER, detailMessagePanel);
//        mainFrame.add(BorderLayout.SOUTH, confirmPanel);
//        mainFrame.setResizable(false);
//        mainFrame.setLocationRelativeTo(null);
//        setTextAsToday();
    }
}
