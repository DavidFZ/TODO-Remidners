package edu.square.utils;

import java.awt.*;

public class ColorUtil {
    private static Color color1;
    private static Color color2;
    private static Color color3;
    private static Color color4;
    private static Color color5;
    private static Color colorW1;
    private static Color colorW2;
    private static Color colorW3;
    private static Color colorW4;
    ColorUtil(){
        //云峰白
        color1 = new Color(216,227,231);
        //井天蓝
        color2 = new Color(195,215,223);
        //海天蓝
        color3 = new Color(198,230,232);
        //瀑布蓝
         color4 = new Color(81,196,211);
        //碧青
        color5 = new Color(92,179,204);
        //瓦尔登蓝
        colorW1 = new Color(220,238,248);
        colorW2 = new Color(185,227,251);
        colorW3 = new Color(116,227,245);
        colorW4 = new Color(119,195,227);

    }





    public static Color getColor1(){
        return color1;
    }
    public static Color getColor2() {
        return color2;
    }

    public static Color getColor3() {
        return color3;
    }

    public static Color getColor4() {
        return color4;
    }

    public static Color getColor5() {
        return color5;
    }

    public static Color getColorW1() {
        return colorW1;
    }

    public static Color getColorW2() {
        return colorW2;
    }

    public static Color getColorW3() {
        return colorW3;
    }

    public static Color getColorW4() {
        return colorW4;
    }
}
