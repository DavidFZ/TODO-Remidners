package edu.square.UIKit;

import javax.swing.*;
import java.awt.*;

public class JFrameFactory {

    public static JFrame buildJFrame(JFrameAttribute jFrameAttribute) {
        JFrame jFrame = new JFrame();

        jFrame.setSize(jFrameAttribute.getWindowWidth(), jFrameAttribute.getWindowHeight());
        jFrame.setTitle(jFrameAttribute.getTitle());
        if (jFrameAttribute.isCenter())
            jFrame.setLocationRelativeTo(null);
        if (jFrameAttribute.isExit())
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return new JFrame();
    }

    public void test() {
        // 获取默认工具包
        Toolkit toolkit = Toolkit.getDefaultToolkit();

        // 获取屏幕的分辨率
        Dimension screenSize = toolkit.getScreenSize();

        // 计算窗口大小，可以根据需要进行调整
        int windowWidth = (int) (screenSize.getWidth() * 0.8); // 使用屏幕宽度的80%
        int windowHeight = (int) (screenSize.getHeight() * 0.8); // 使用屏幕高度的80%

        // 创建一个 JFrame
        JFrame frame = new JFrame("Swing窗口");

        // 设置窗口大小
        frame.setSize(windowWidth, windowHeight);

        // 设置窗口居中
        frame.setLocationRelativeTo(null);

        // 设置关闭操作
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 显示窗口
        frame.setVisible(true);

        // 添加 "Hello World" 标签
        JLabel label = new JLabel("Hello World");
        frame.getContentPane().add(label);
    }
}
