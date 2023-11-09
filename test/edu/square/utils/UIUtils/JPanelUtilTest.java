package edu.square.utils.UIUtils;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class JPanelUtilTest {

    @Test
    public void getCenterFlowMainPanel() {
        Dimension dimension = new Dimension(100,200);
        JPanel jPanel = JPanelUtil.getCenterFlowMainPanel(dimension);
        assertEquals("dimension different",dimension,jPanel.getPreferredSize());
        LayoutManager layout = jPanel.getLayout();
        assertTrue(layout instanceof FlowLayout);
        assertEquals(FlowLayout.CENTER, ((FlowLayout) layout).getAlignment());
    }

    @Test
    public void getFlowJpanel() {
        LayoutManager layoutManager = new FlowLayout(FlowLayout.LEFT);
        int i = ((FlowLayout)layoutManager).getAlignment();
        JPanel jPanel = JPanelUtil.getFlowJpanel(i);
        assertEquals("layout different",i,((FlowLayout)jPanel.getLayout()).getAlignment());
        assertTrue("is not exist",jPanel.isVisible());
    }

    @Test
    public void testGetFlowJpanel() {
        Dimension dimension = new Dimension(100,200);
        JPanel jPanel = JPanelUtil.getFlowJpanel(1,dimension);
        assertTrue("is not exist",jPanel.isVisible());
        assertEquals("size is different",dimension,jPanel.getPreferredSize());
        assertEquals("layout is different",1,((FlowLayout)jPanel.getLayout()).getAlignment());
    }

    @Test
    public void testGetFlowJpanel1() {
        Dimension dimension = new Dimension(100,200);
        Color color = new Color(255,255,255);
        JPanel jPanel = JPanelUtil.getFlowJpanel(1,dimension,color);
        assertTrue("is not exist",jPanel.isVisible());
        assertEquals("size is different",dimension,jPanel.getPreferredSize());
        assertEquals("layout is different",1,((FlowLayout)jPanel.getLayout()).getAlignment());
        assertEquals("color is different",color,jPanel.getBackground());

    }

    @Test
    public void testGetFlowJpanel2() {
        Dimension dimension = new Dimension(100,200);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        JPanel jPanel = JPanelUtil.getFlowJpanel(flowLayout,dimension);
        assertTrue("is not exist",jPanel.isVisible());
        assertEquals("size is different",dimension,jPanel.getPreferredSize());
        assertEquals("layout is different",flowLayout,jPanel.getLayout());
    }

    @Test
    public void testGetFlowJpanel3() {
        Dimension dimension = new Dimension(100,200);
        FlowLayout flowLayout = new FlowLayout(FlowLayout.LEFT);
        Color color = new Color(255,255,255);
        JPanel jPanel = JPanelUtil.getFlowJpanel(flowLayout,dimension);
        assertTrue("is not exist",jPanel.isVisible());
        assertEquals("size is different",dimension,jPanel.getPreferredSize());
        assertEquals("layout is different",flowLayout,jPanel.getLayout());
    }
}