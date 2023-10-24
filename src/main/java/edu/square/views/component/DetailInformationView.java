package edu.square.views.component;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.widget.BlockPanelWidget;
import edu.square.views.widget.ComboBoxPanelView;
import edu.square.views.widget.TextFieldPanelView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;

public class DetailInformationView {


    public final Dimension parentJComponentDimension;

    private final Dimension componentPanelDimension;
    Font font1;
    Font font2;
    Font font3;
    private JPanel mainPanel;

    String[] options = {"None", "5 minutes before", "15 minutes before", "30 minutes before", "1 hour before", "2 hours before", "1 day before", "2 days before", "1 week before", "2 weeks before"};

    public DetailInformationView(JFrame parentFrame) {
        parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        componentPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.38);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);

        //set MainPanel
        mainPanel = JPanelUtil.getMainPanel(componentPanelDimension);
        mainPanel.setBackground(Color.yellow);


//        ControlPanelView
        {
            JPanel controlPanel = new JPanel();
            controlPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
            controlPanel.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.1));
            controlPanel.setBackground(Color.green);

            //resetPanel
            {
                JPanel resetPanel = new JPanel();
                resetPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
                resetPanel.setPreferredSize(new Dimension((int) (0.48 * componentPanelDimension.width), (int) (0.08 * componentPanelDimension.height)));
                resetPanel.setBackground(Color.orange);
                JButton resetButton = new JButton("Reset");
                resetButton.setPreferredSize(new Dimension((int) (0.2 * componentPanelDimension.width), (int) (0.04 * componentPanelDimension.height)));
                resetButton.setFont(font3);
                resetButton.setBackground(Color.white);
                resetButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //点击reset事件
                    }
                });
                resetPanel.add(resetButton);

                controlPanel.add(resetPanel);

            }

            //donePanel
            {
                JPanel donePanel = new JPanel();
                donePanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
                donePanel.setPreferredSize(new Dimension((int) (0.48 * componentPanelDimension.width), (int) (0.08 * componentPanelDimension.height)));
                donePanel.setBackground(Color.orange);
                JButton doneButton = new JButton("Done");
                doneButton.setPreferredSize(new Dimension((int) (0.2 * componentPanelDimension.width), (int) (0.04 * componentPanelDimension.height)));
                doneButton.setFont(font3);
                doneButton.setBackground(Color.white);
                doneButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        //TODO do something to deliver some information to DB


                    }
                });
                donePanel.add(doneButton);
                controlPanel.add(donePanel);
            }
            mainPanel.add(controlPanel);

        }
        //TextPanel
        {
            JPanel textPanelDetail = new JPanel();
            textPanelDetail.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.1));
            textPanelDetail.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel detailLabel = new JLabel("Detail");
            detailLabel.setFont(font2);
            textPanelDetail.add(detailLabel);
            mainPanel.add(textPanelDetail);
        }
        //NamePanel
        {
            TextFieldPanelView nameTextFieldPanelView = new TextFieldPanelView(componentPanelDimension, font2, font3, "Name:", 0.07);
            mainPanel.add(nameTextFieldPanelView.getPanel());


        }
//        NotePanel
        {
            TextFieldPanelView noteTextFieldPanelView = new TextFieldPanelView(componentPanelDimension, font2, font3, "Note:", 0.07);
            mainPanel.add(noteTextFieldPanelView.getPanel());

        }
        //BlockPanel
        {
            BlockPanelWidget blockPanelView = new BlockPanelWidget(componentPanelDimension,0.1);
            mainPanel.add(blockPanelView.getBlockPanel());
        }
        //TextPanel
        {
            JPanel textPanelEarlyReminder = new JPanel();
            textPanelEarlyReminder.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.06));
            textPanelEarlyReminder.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel detailLabel = new JLabel("Early Reminder:");
            detailLabel.setFont(font2);
            textPanelEarlyReminder.add(detailLabel);
            mainPanel.add(textPanelEarlyReminder);
        }
        //earlyReminderComboBoxPanel
        {
            ComboBoxPanelView earlyReminderComboBoxPanel = new ComboBoxPanelView(componentPanelDimension, 0.07, font3, options, Color.cyan);
            mainPanel.add(earlyReminderComboBoxPanel.getjPanel());
        }
        //TextPanel
        {
            JPanel textPanelRepeat = new JPanel();
            textPanelRepeat.setPreferredSize(resizeDimensionHeightScale(componentPanelDimension, 0.06));
            textPanelRepeat.setLayout(new FlowLayout(FlowLayout.LEFT));
            JLabel detailLabel = new JLabel("Repeat:");
            detailLabel.setFont(font2);
            textPanelRepeat.add(detailLabel);
            mainPanel.add(textPanelRepeat);
        }
        //repeatPanel
        {
            ComboBoxPanelView repeatComboBoxPanel = new ComboBoxPanelView(componentPanelDimension, 0.07, font3, options, Color.cyan);
            mainPanel.add(repeatComboBoxPanel.getjPanel());
        }

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
}
