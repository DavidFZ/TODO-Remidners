package edu.square.utils.UIUtils;

import org.apache.logging.log4j.core.Layout;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class RemindItem {
    RemindItem(String s){
        Toolkit t = Toolkit.getDefaultToolkit();
        JPanel remindPanel = new JPanel();
        JLabel remindLabel = new JLabel(s);
        remindPanel.setBorder(new LineBorder(Color.PINK));
        Font remindFont = new Font("宋体",Font.BOLD,(int)(0.05*t.getScreenSize().getWidth()));
        remindPanel.add(remindLabel);
    }
}
