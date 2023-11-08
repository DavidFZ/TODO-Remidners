package edu.square.utils.UIUtils;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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
    }

    @Test
    public void resizeDimensionWidthScale() {
    }

    @Test
    public void resizeDimensionHeightScale() {
    }

    @Test
    public void resizeDimensionWidthAndHeight() {
    }

    @Test
    public void testResizeDimensionWidthScale() {
    }
    @Test
    public void recursionResize(){

    }
}