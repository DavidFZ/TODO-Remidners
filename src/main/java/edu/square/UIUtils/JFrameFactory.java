package edu.square.UIUtils;

import javax.swing.*;

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
        return buildJFrame(JFrameAttribute.getAttribute(title));
    }


    public static void main(String[] args) {
        // test cases
        JFrame frame = getDefaultJFrame();
        frame =getDefaultJFrame("test");
        frame = buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowWidth(200).setWindowHeight(100).build());
        frame = getDefaultJFrame();
        frame.setVisible(true);
    }
}
