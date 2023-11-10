package edu.square.views.view1.widget;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class BlockPanelWidgetTest {

    @Test
    public void initializeMainPanel() {
        Dimension parentDimension = new Dimension(500,1000);
        Dimension selfDimension = new Dimension(300,600);
        JPanel jPanel = new BlockPanelWidget(parentDimension,selfDimension).getMainPanel();
        assertTrue(jPanel.isVisible());
        assertEquals(selfDimension,jPanel.getPreferredSize());
    }

    @Test
    public void initializeFonts() {
    }

    @Test
    public void initializeJComponents() {
    }
}