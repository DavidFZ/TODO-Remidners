package edu.square.views.view4;

import edu.square.controller.View1Controller;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.component.LeftSideComponent;
import edu.square.views.component.TomatoTimer;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;

public class Test {
    public Test() {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        LeftSideComponent leftSideComponent = new LeftSideComponent(mainFrame, View1Controller.getGroupTitles());
        Dimension dimension = new Dimension((int)(mainFrame.getWidth()*0.6),(int)(mainFrame.getHeight()*0.8));
        TomatoTimer tomatoTimer = new TomatoTimer(dimension);
        mainFrame.add(leftSideComponent.getLeftPanel());
        mainFrame.add(tomatoTimer.getTomatoTimerJPanel());
        mainFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Test();
    }


}
