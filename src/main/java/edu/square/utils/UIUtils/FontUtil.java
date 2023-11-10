package edu.square.utils.UIUtils;

import java.awt.*;

public class FontUtil {
    public static final double FONT_SIZE_0 = 0.04;
    public static final double FONT_SIZE_1 = 0.03;
    public static final double FONT_SIZE_2 = 0.02;
    public static final double FONT_SIZE_3 = 0.015;
    public static final double FONT_SIZE_4 = 0.01;

    public static Font getBoldFont(int fontSize) {
        return new Font("Trebuchet MS", Font.BOLD, fontSize);
    }

    public static Font getBoldFont(Dimension parentFrameDimension, double scalingSize) {
        return new Font("Trebuchet MS", Font.BOLD, (int) (parentFrameDimension.getWidth() * scalingSize));
    }

}