package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.util.List;

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

    /**
     * Calculate the scale ratio of the dimension
     *
     * @param dimension Dimension
     * @return scale ratio
     */
    public static double calculateAspectRatio(Dimension dimension) {
        return (double) dimension.width / dimension.height;
    }


    /**
     * Get the component adapter for uniform scaling, which is used to resize the component while frame size changess
     *
     * @param formerDimension
     * @param newDimension
     * @return
     */
    public static Dimension maintainsFormerAspectRatio(Dimension formerDimension, Dimension newDimension) {
        double aspectRatio = calculateAspectRatio(formerDimension);
        int newWidth = (int) newDimension.getWidth();
        int newHeight = (int) newDimension.getHeight();

        if ((double) newDimension.width / newDimension.height > aspectRatio) {
            newWidth = (int) ((double) newDimension.height * aspectRatio);
        } else {
            newHeight = (int) ((double) newDimension.width / aspectRatio);
        }

        return new Dimension(newWidth, newHeight);
    }

    /**
     * Scaled resize the dimension with the ratio
     *
     * @param dimension    former dimension
     * @param scalingRatio scale ratio
     * @return dimension being resized
     */
    public static Dimension resizeDimensionScale(Dimension dimension, double scalingRatio) {
        assert scalingRatio > 0;
        return new Dimension((int) (dimension.width * scalingRatio), (int) (dimension.height * scalingRatio));
    }

    public static Dimension resizeDimensionWidthScale(Dimension dimension, double scalingRatio) {
        assert scalingRatio > 0;
        return new Dimension((int) (dimension.width * scalingRatio), dimension.height);
    }

    public static Dimension resizeDimensionHeightScale(Dimension dimension, double scalingRatio) {
        assert scalingRatio > 0;
        return new Dimension(dimension.width, (int) (dimension.height * scalingRatio));
    }

    public static Dimension resizeDimensionWidthAndHeight(Dimension dimension, double widthScalingRatio, double heightScalingRatio) {
        assert widthScalingRatio > 0 && heightScalingRatio > 0;
        return new Dimension((int) (dimension.width * widthScalingRatio), (int) (dimension.height * heightScalingRatio));
    }

    public static Dimension resizeDimensionWidthScale(JFrame jFrame, double scalingRatio) {
        assert scalingRatio > 0;
        return resizeDimensionWidthScale(jFrame.getSize(), scalingRatio);
    }

    private static void recursionResize(List<Component> componentList, double ratio) {
        if (componentList.isEmpty()) return;
        for (Component c : componentList) {
            Dimension dimension = c.getSize();
            c.setSize(resizeDimensionScale(dimension, ratio));
            JComponent jc = (JComponent) c;
            List<Component> components = List.of(jc.getComponents());
            if (components != null && !components.isEmpty())
                return;
            for (Component c1 : components)
                recursionResize(List.of(c1), ratio);
            c.revalidate();
        }
    }

    public static Dimension addDimensionHeight(Dimension dimension, int height) {
        return new Dimension(dimension.width, dimension.height + height);
    }

    public static Dimension addDimensionHeight(Dimension dimension, Dimension addDimension) {
        return new Dimension(dimension.width, (int) (dimension.height + addDimension.getHeight()));
    }
}
