package edu.square.utils.UIUtils;

import javax.print.attribute.standard.PrinterName;
import javax.swing.*;
import java.awt.*;

public class JPanelUtil {
    public static JPanel getMainPanel(Dimension mainPanelDimension) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(mainPanelDimension);
        return mainPanel;
    }

    public static JPanel getFlowJpanel(int flowLayout){
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(flowLayout));
        return jPanel;
    }

    public static JPanel getFlowJpanel(int flowLayout,Dimension dimension){
        JPanel jPanel =getFlowJpanel(flowLayout);
        jPanel.setPreferredSize(dimension);
        return jPanel;
    }

}
