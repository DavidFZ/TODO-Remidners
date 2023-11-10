package edu.square.views.view;

import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view3.TomatoTimer;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class TomatoTimerView extends MyView {
    public final TomatoTimer tomatoTimer;

    public TomatoTimerView(JFrame parentFrame, Dimension dimension) {
        super(parentFrame, dimension);
        tomatoTimer = new TomatoTimer(resizeDimensionHeightScale(rootFrameDimension.getSize(), 0.9), this);
    }


    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        MyView myView = new MyView(mainFrame, mainFrame.getSize());
        TomatoTimerView tomatoTimerView = new TomatoTimerView(mainFrame, mainFrame.getSize());
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(tomatoTimerView.getMainPanel());
        mainFrame.setVisible(true);
    }
}
