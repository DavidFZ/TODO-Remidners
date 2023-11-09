package edu.square.utils.UIUtils;

import org.junit.Test;

import javax.swing.*;

import java.awt.*;

import static org.junit.Assert.*;

public class JFrameFactoryTest {

    @Test
    public void buildJFrame() {
        JFrameAttribute jFrameAttribute = new JFrameAttribute();
        JFrame jf = JFrameFactory.buildJFrame(jFrameAttribute);
        assertEquals("width different",jFrameAttribute.getWindowWidth(),jf.getWidth());
        assertEquals("height different",jFrameAttribute.getWindowWidth(),jf.getHeight());
        assertEquals("close method",1,jf.getDefaultCloseOperation());
    }

    @Test
    public void buildJFrameWithLayout() {
        JFrameAttribute jFrameAttribute = new JFrameAttribute();
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        JFrame jFrame = JFrameFactory.buildJFrameWithLayout(jFrameAttribute, layoutManager);
        assertEquals("layout different", layoutManager,jFrame.getContentPane().getLayout());
    }

    @Test
    public void getDefaultJFrame() {
        JFrame jFrame = JFrameFactory.getDefaultJFrame(0.8,"Wow");
        assertEquals("width different",2048,jFrame.getWidth());
        assertEquals("height different",1152,jFrame.getHeight());
        assertEquals("close method",3,jFrame.getDefaultCloseOperation());
    }

    @Test
    public void getDefaultJFrameWithLayout() {
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        JFrame jFrame = JFrameFactory.getDefaultJFrameWithLayout(0.8,"Wow",layoutManager);
        assertEquals("layout different",layoutManager,jFrame.getContentPane().getLayout());
    }

    @Test
    public void testBuildJFrame() {
        Dimension dimension = new Dimension(100,200);
        String title = "Wow";
        JFrame jFrame = JFrameFactory.buildJFrame(dimension,title);
        assertEquals("title different",title,jFrame.getTitle());
        assertTrue(dimension.getWidth()==jFrame.getWidth());
        assertTrue(dimension.getHeight()==jFrame.getHeight());
    }
}