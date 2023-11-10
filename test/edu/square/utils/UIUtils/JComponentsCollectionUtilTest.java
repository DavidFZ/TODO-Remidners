package edu.square.utils.UIUtils;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class JComponentsCollectionUtilTest {
    @Test
    public void resizeAllFrames(){
        JComponentsCollectionUtil collectionUtil = new JComponentsCollectionUtil();

        // Create two frames for testing
        Frame frame1 = new Frame("Frame 1");
        Frame frame2 = new Frame("Frame 2");
        frame1.setSize(400, 300);
        frame2.setSize(800, 600);
        // Add frames to the collection
        collectionUtil.addComponent(frame1);
        collectionUtil.addComponent(frame2);
        double resizePercent = 0.5;
        collectionUtil.resizeAllFrames(resizePercent);


        assertEquals(200, frame1.getWidth());
        assertEquals(150, frame1.getHeight());
        assertEquals(400, frame2.getWidth());
        assertEquals(300, frame2.getHeight());
    }
}