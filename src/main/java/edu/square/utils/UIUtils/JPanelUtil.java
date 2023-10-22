package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

public class JPanelUtil {
    public static JPanel getMainPanel(Dimension mainPanelDimension) {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setPreferredSize(mainPanelDimension);
        return mainPanel;
    }
}
