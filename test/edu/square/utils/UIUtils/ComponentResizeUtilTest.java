package edu.square.utils.UIUtils;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComponentResizeUtilTest {

    @Test
    public void getFontResizeUtil() {
        JFrame frame = new JFrame();
        JLabel label = new JLabel();
        ComponentAdapter adapter = ComponentResizeUtil.getFontResizeUtil(label, frame);
        frame.setSize(200,200);
        adapter.componentResized(new ComponentEvent(frame,ComponentEvent.COMPONENT_RESIZED));
        Font font = label.getFont();
        assertEquals("Font size do not change",font,label.getFont());

    }

    @Test
    public void calculateAspectRatio() {
    }

    @Test
    public void maintainsFormerAspectRatio() {
        Dimension formerDimension = new Dimension(300,100);
        Dimension newDimension = new Dimension(100,100);
        Dimension dimension = ComponentResizeUtil.maintainsFormerAspectRatio(formerDimension,newDimension);
        assertEquals(new Dimension(100,100/3),dimension);

    }


    @Test
    public void resizeDimensionScale() {
        Dimension testDimension = new Dimension(200,400);
        double scalingRatio = 0.5;
        Dimension dimension = ComponentResizeUtil.resizeDimensionScale(testDimension,scalingRatio);
        assertEquals("dimension is different",dimension,new Dimension(100,200));
    }

    @Test
    public void resizeDimensionWidthScale() {
        Dimension testDimension = new Dimension(200,400);
        double scalingRatio = 0.5;
        Dimension dimension = ComponentResizeUtil.resizeDimensionWidthScale(testDimension,scalingRatio);
        assertEquals("dimension is different",dimension,new Dimension(100,400));
    }

    @Test
    public void resizeDimensionHeightScale() {
        Dimension testDimension = new Dimension(200,400);
        double scalingRatio = 0.5;
        Dimension dimension = ComponentResizeUtil.resizeDimensionHeightScale(testDimension,scalingRatio);
        assertEquals("dimension is different",dimension,new Dimension(200,200));
    }

    @Test
    public void resizeDimensionWidthAndHeight() {
        Dimension testDimension = new Dimension(200,400);
        double heightRatio = 0.5;
        double widthRatio = 0.25;
        Dimension dimension = ComponentResizeUtil.resizeDimensionWidthAndHeight(testDimension,widthRatio,heightRatio);
        assertEquals("dimension is different",dimension,new Dimension(50,200));
    }

    @Test
    public void testResizeDimensionWidthScale() {
        JFrame jFrame = new JFrame();
        jFrame.setSize(200,400);
        double scalingRatio = 0.5;
        Dimension dimension = ComponentResizeUtil.resizeDimensionWidthScale(jFrame,scalingRatio);
        assertEquals("dimension is different",dimension,new Dimension(100,400));
    }
//    @Test
//    public void recursionResize(){
//        double ratio = 0.5;
//        List<Component> list1 = new ArrayList<>();
//
//    }
}