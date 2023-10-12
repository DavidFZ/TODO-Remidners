package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;

import edu.square.utils.UIUtils.JFrameAttribute;

import static edu.square.utils.UIUtils.JFrameAttribute.getDefaultAttribute;

public class JFrameFactory {

    /**
     * build JFrame with JFrameAttribute
     *
     * @param jFrameAttribute JFrameAttributes including window size, title, etc.
     * @return JFrame
     */
    public static JFrame buildJFrame(JFrameAttribute jFrameAttribute) {
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
     * build JFrame with JFrameAttribute and LayoutManager
     *
     * @param jFrameAttribute
     * @param layoutManager
     * @return JFrameAttribute object with LayoutManager
     */
    public static JFrame buildJFrameWithLayout(JFrameAttribute jFrameAttribute, LayoutManager layoutManager) {
        JFrame jFrame = buildJFrame(jFrameAttribute);
        jFrame.setContentPane(new Container());
        jFrame.getContentPane().setLayout(layoutManager);
        return jFrame;
    }


    /**
     * get JFrame object with percentage of screen
     *
     * @param percent percentage of screen
     * @param title   the title of the window
     * @return JFrame
     */
    public static JFrame getDefaultJFrame(double percent, String title) {
        return buildJFrame(getDefaultAttribute(percent, title));
    }

    public static JFrame getDefaultJFrameWithLayout(double percent, String title, LayoutManager layoutManager) {
        return buildJFrameWithLayout(getDefaultAttribute(percent, title), layoutManager);
    }


    public static void main(String[] args) {
        // test cases
        JFrame frame = getDefaultJFrame(.7d,null);
        frame = getDefaultJFrame(.7d,"test");
        frame = buildJFrame(JFrameAttribute.getAttributeBuilder().setWindowWidth(200).setWindowHeight(100).build());
        frame = getDefaultJFrameWithLayout(.7d,"test",new BorderLayout());

        frame.setVisible(true);
    }
}
