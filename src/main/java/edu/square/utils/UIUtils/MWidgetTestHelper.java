package edu.square.utils.UIUtils;

import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.JFrameFactory.getDefaultJFrame;

public abstract class MWidgetTestHelper {
    public  JFrame jFrame;
    public MWidgetTestHelper() {
        jFrame = getDefaultJFrame(0.8, "Schedule");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        initializeMWidget();

        jFrame.setVisible(true);
    }

    public abstract void initializeMWidget();
}
