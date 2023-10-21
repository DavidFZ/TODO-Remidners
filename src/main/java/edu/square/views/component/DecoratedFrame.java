package edu.square.views.component;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DecoratedFrame extends JFrame {
    JFrame detailFrame = new JFrame();

    //        this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    public DecoratedFrame() {
        //includes cancel  done
        detailFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        detailFrame.setUndecorated(true);
        detailFrame.setSize(200,620);
        JPanel firstPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        firstPanel.setPreferredSize(new Dimension(190,40));

        JPanel cancelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        cancelPanel.setPreferredSize(new Dimension(89,20));
        JLabel cancelLabel = new JLabel("Cancel");
        cancelLabel.setFont(new Font("宋体",Font.BOLD,10));
        cancelPanel.add(cancelLabel);

        JPanel donePanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        donePanel.setPreferredSize(new Dimension(89,20));
        JLabel doneLabel = new JLabel("Done");
        doneLabel.setFont(new Font("宋体",Font.BOLD,10));
        donePanel.add(doneLabel);

        firstPanel.add(cancelPanel);
        firstPanel.add(donePanel);
        //include title
        JPanel detailPanel = new JPanel();
        JLabel detailLabel = new JLabel("Detail");
        detailLabel.setFont(new Font("宋体",Font.BOLD,20));
        detailPanel.setPreferredSize(new Dimension(190,80));
        detailPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        detailPanel.add(detailLabel);
        //name
        JPanel namePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField nameTextField = new JTextField(10);
        nameTextField.setBorder(null);
        JLabel nameLabel = new JLabel("Name:");
        namePanel.setPreferredSize(new Dimension(190,30));
        namePanel.setBackground(Color.WHITE);
        namePanel.add(nameLabel);
        namePanel.add(nameTextField);
        //note
        JPanel notePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField noteTextField = new JTextField(10);
        noteTextField.setBorder(null);
        JLabel noteLabel = new JLabel("Notes:");
        notePanel.setPreferredSize(new Dimension(190,30));
        notePanel.setBackground(Color.WHITE);
        notePanel.add(noteLabel);
        notePanel.add(noteTextField);
        //Date
        JPanel datePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //DateLabel
        JPanel dateLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        dateLabelPanel.setPreferredSize(new Dimension(89,30));
        JLabel dateLabel = new JLabel("Date");
        dateLabelPanel.add(dateLabel);
        //Date radio button
        JPanel dateButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        dateButtonPanel.setPreferredSize(new Dimension(89,30));
        JRadioButton dateRadioButton = new JRadioButton();
        dateButtonPanel.add(dateRadioButton);
        datePanel.add(dateLabelPanel);
        datePanel.add(dateButtonPanel);


        //Date
        JPanel timePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        //DateLabel
        JPanel timeLabelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        timeLabelPanel.setPreferredSize(new Dimension(89,30));
        JLabel timeLabel = new JLabel("Time");
        timeLabelPanel.add(timeLabel);
        //Date radio button
        JPanel timeButtonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        timeButtonPanel.setPreferredSize(new Dimension(89,30));
        JRadioButton timeRadioButton = new JRadioButton();
        timeButtonPanel.add(timeRadioButton);
        timePanel.add(timeLabelPanel);
        timePanel.add(timeButtonPanel);




        //early reminder
        JPanel earlyReminderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel earlyReminderTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel earlyReminderTitle = new JLabel("Early Reminder");
        earlyReminderTitle.setFont(new Font("宋体",Font.BOLD,10));
        earlyReminderPanel.setPreferredSize(new Dimension(190,90));
        earlyReminderTitlePanel.setPreferredSize(new Dimension(190,30));
        earlyReminderTitlePanel.add(earlyReminderTitle);

        JPanel earlyComboBoxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        earlyComboBoxPanel.setPreferredSize(new Dimension(190,30));
        JComboBox earilyReminder = new JComboBox<>();
        String[] options = {"None","5 minutes before","15 minutes before","30 minutes before","1 hour before","2 hours before","1 day before","2 days before","1 week before","2 weeks before"};
        for(String item : options){
            earilyReminder.addItem(item);
        }
        earlyComboBoxPanel.add(earilyReminder);
        earlyReminderPanel.add(earlyReminderTitlePanel);
        earlyReminderPanel.add(earlyComboBoxPanel);

        //early reminder
        JPanel repeatPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel repeatTitlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel repeatTitle = new JLabel("Repeat");
        repeatTitle.setFont(new Font("宋体",Font.BOLD,10));
        repeatPanel.setPreferredSize(new Dimension(190,90));
        repeatTitlePanel.setPreferredSize(new Dimension(190,30));
        repeatTitlePanel.add(repeatTitle);

        JPanel repeatComboBoxPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        repeatComboBoxPanel.setPreferredSize(new Dimension(190,30));
        JComboBox repeatCombox = new JComboBox<>();
        String[] options2 = {"None","5 minutes before","15 minutes before","30 minutes before","1 hour before","2 hours before","1 day before","2 days before","1 week before","2 weeks before"};
        for(String item : options2){
            repeatCombox.addItem(item);
        }
        repeatComboBoxPanel.add(repeatCombox);
        repeatPanel.add(repeatTitlePanel);
        repeatPanel.add(repeatComboBoxPanel);

        //when click cancel
        cancelLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detailFrame.dispose();
                //数据库方法
            }
        });
        //when click done
        doneLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                detailFrame.dispose();
            }
        });


        detailFrame.add(firstPanel);
        detailFrame.add(detailPanel);
        detailFrame.add(namePanel);
        detailFrame.add(notePanel);
        detailFrame.add(datePanel);
//        this.add(timePanel);
        detailFrame.add(earlyReminderPanel);
        detailFrame.add(repeatPanel);


    }




    public static void main(String[] args) {
        JFrame frame = new DecoratedFrame().detailFrame;
        frame.setVisible(true);
        System.out.println();
    }
}