package edu.square.utils.UIUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
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

    public static Font getFontResizeUtil(JFrame parentFrame, double factor) {
        int newFontSize = Math.max(10, (int) (parentFrame.getWidth() * factor));
        // Adjust the factor as needed
        Font currentFont = parentFrame.getFont();
        Font newFont = currentFont.deriveFont((float) newFontSize);
        return newFont;
    }

    /**
     * Get Uniform Scaling Component Adapter
     * Keep the aspect ratio of the component while resizing
     *
     * @param formerDimension former dimension
     * @return ComponentAdapter
     */
    public static ComponentAdapter getSelfAspectMaintainer(Dimension formerDimension) {
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                Dimension newDimension = e.getComponent().getSize();
                e.getComponent().setSize(maintainsFormerAspectRatio(formerDimension, newDimension));
            }
        };
    }

    /**
     * Get the component adapter for uniform scaling, which is used to resize the component while frame size changes
     * Injected into the component to be resized
     *
     * @param componentList List of components to be resized
     * @return ComponentAdapter
     */
    public static ComponentAdapter getUniformScalingComponentAdapter(List<Component> componentList, double ratio) {
        assert componentList != null;
        return new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (componentList.isEmpty()) return;
                for (Component c : componentList) {
                    recursionResize(componentList, ratio);
                }
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

    public static double calculateWidthScaledRatio(double formerWidth, double newWidth) {
        return (double) newWidth / formerWidth;
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
    public static Dimension getScaleResizedDimension(Dimension dimension, double scalingRatio) {
        assert scalingRatio > 0;
        return new Dimension((int) (dimension.width * scalingRatio), (int) (dimension.height * scalingRatio));
    }

    private static void recursionResize(List<Component> componentList, double ratio) {
        if (componentList.isEmpty()) return;
        for (Component c : componentList) {
            Dimension dimension = c.getSize();
            c.setSize(getScaleResizedDimension(dimension, ratio));
            JComponent jc = (JComponent) c;
            List<Component> components = List.of(jc.getComponents());
            if (components != null && !components.isEmpty())
                return;
            for (Component c1 : components)
                recursionResize(List.of(c1), ratio);
            c.revalidate();
        }
    }


}
