package edu.square.utils.UIUtils;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.*;

public class FontUtilTest {

    @Test
    public void getBoldFont() {
        int fontSize = 10;
        Font font = FontUtil.getBoldFont(10);
        assertEquals("font is not same",font,new Font("Trebuchet MS",Font.BOLD,10));
    }

    @Test
    public void testGetBoldFont() {
        Dimension dimension = new Dimension(100,100);
        Font font = FontUtil.getBoldFont(dimension,0.1);
        assertEquals("font is not same",font,new Font("Trebuchet MS",Font.BOLD,10));
    }
}