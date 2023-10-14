package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;

public class ComponentResizeUtil {
    public static ComponentAdapter getFontResizeUtil(JLabel label, JFrame parentFrame) {
        return new ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                int newFontSize = Math.max(10, (int) (parentFrame.getWidth() * 0.05));
                // Adjust the factor as needed
                Font currentFont = label.getFont();
                Font newFont = currentFont.deriveFont((float) newFontSize);
                label.setFont(newFont);
            }
        };
    }
}
