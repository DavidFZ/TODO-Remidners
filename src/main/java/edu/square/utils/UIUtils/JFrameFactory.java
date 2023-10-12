package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

import edu.square.utils.UIUtils.JFrameAttribute;

import static edu.square.utils.UIUtils.JFrameAttribute.getDefaultAttribute;

public class JFrameFactory {

    /**
     * 使用JFrameAttribute构建JFrame
     * build JFrame with JFrameAttribute
     *
     * @param jFrameAttribute JFrameAttribute 包括窗口大小, 标题等
     *                        JFrameAttributes including window size, title, etc.
     * @return JFrame
     * @throws RuntimeException 如果JFrameAttribute没有设置完成
     *                          if JFrameAttribute is not set done
     */
    public static JFrame buildJFrame(JFrameAttribute jFrameAttribute) {
        //make sure JFrameAttribute is set done
        if (!jFrameAttribute.isAttributeSetDone())
            throw new RuntimeException("JFrameAttribute is not set done");

        JFrame jFrame = new JFrame();

        jFrame.setSize(jFrameAttribute.getWindowWidth(), jFrameAttribute.getWindowHeight());
        jFrame.setTitle(jFrameAttribute.getTitle());
        if (jFrameAttribute.isCenter())
            jFrame.setLocationRelativeTo(null);
        if (jFrameAttribute.isExit())
            jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return jFrame;
    }

    /**
     * 使用默认的JFrameAttribute构建窗口名为空的JFrame对象
     * build JFrame object with default JFrameAttribute and empty title
     *
     * @return JFrame 默认属性的JFrame对象
     * JFrame object with default attributes
     */
    public static JFrame getDefaultJFrame() {
        return buildJFrame(JFrameAttribute.getAnonymousTitleAttribute());
    }

    /**
     * 使用默认的JFrameAttribute构建JFrame对象
     * build JFrame object with default JFrameAttribute
     *
     * @param title 窗口名
     * @return JFrame
     */
    public static JFrame getDefaultJFrame(String title) {
        return buildJFrame(JFrameAttribute.getAttribute(title).build());
    }

    /**
     * 获取按照屏幕百分比设置的JFrame对象
     * get JFrame object with percentage of screen
     *
     * @param percent 屏幕百分比
     *                percentage of screen
     * @param title   窗口名
     * @return JFrame 按照屏幕百分比设置的JFrame对象
     */
    public static JFrame getDefaultFrameWithPercentage(double percent, String title) {
        return buildJFrame(getDefaultAttribute(percent, title).build());
    }

        /**
     * 设置JFrame的布局管理器
     * set JFrame's layout manager
     *
     * @param jFrame        JFrame对象
     * @param layoutManager 布局管理器
     * @return JFrame 内置Container的JFrame对象
     * JFrame object with Container
     */
    public static JFrame setContainerWithLayout(JFrame jFrame, LayoutManager layoutManager) {
        jFrame.setContentPane(new Container());
        jFrame.getContentPane().setLayout(layoutManager);
        return jFrame;
    }

    public static void main(String[] args) {
        // test cases
        JFrame frame = getDefaultJFrame();
        frame = getDefaultJFrame("test");
        frame = buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowWidth(200).setWindowHeight(100).build());
        frame = getDefaultJFrame();

        frame = getDefaultFrameWithPercentage(.6, "test");
        frame.setVisible(true);
    }
}
