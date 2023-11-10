package edu.square.utils.UIUtils;

import edu.square.views.view.MyView;

import javax.swing.*;
import java.awt.*;

public abstract class MComponentTestHelper {
    public JFrame jFrame;
    public MyView myView;

    public MComponentTestHelper() {
        jFrame = JFrameFactory.getDefaultJFrame(0.8d, "GroupedListComponentTest");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER));

        myView = new MyView(jFrame, jFrame.getSize());
        initializeMComponent();

        jFrame.setVisible(true);
    }

    public abstract void initializeMComponent();
}
