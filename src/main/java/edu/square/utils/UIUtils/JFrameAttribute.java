package edu.square.utils.UIUtils;

import java.awt.*;

public class JFrameAttribute {

    private int windowWidth;
    private int windowHeight;
    private String title;
    private boolean isCenter;
    private boolean isExit;
    private boolean isVisible;
    private int defaultCloseOperation;


    /**
     * Get default JFrame attribute
     * Default window size is 80% of the screen size
     *
     * @param frameTitle the title of the window
     * @return JFrameAttribute default JFrame attribute
     */
    private static JFrameAttribute getDefaultAttribute(String frameTitle) {
        return getDefaultAttribute(0.8, frameTitle);
    }

    /**
     * Get default JFrame attribute with percent
     *
     * @param percent    the percent of the screen size
     * @param frameTitle the title of the window
     * @return JFrameAttribute
     */
    public static JFrameAttribute getDefaultAttribute(double percent, String frameTitle) {
        if (percent < 0 || percent > 1)
            throw new IllegalArgumentException("percent must be between 0 and 1");

        JFrameAttribute jFrameAttribute = new JFrameAttribute();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        jFrameAttribute.windowWidth = ((int) (screenSize.getWidth() * percent));
        jFrameAttribute.windowHeight = ((int) (screenSize.getHeight() * percent));
        if (frameTitle == null)
            frameTitle = "";
        jFrameAttribute.title = (frameTitle);
        jFrameAttribute.isCenter = (true);
        jFrameAttribute.isExit = (true);
        return jFrameAttribute;
    }

    /**
     *  Get JFrameAttributeBuilder
     * @return JFrameAttributeBuilder
     */
    public static JFrameAttributeBuilder getAttributeBuilder() {
        return new JFrameAttributeBuilder();
    }

    /**
     * getters
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCenter() {
        return isCenter;
    }

    public boolean isExit() {
        return isExit;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }

    /**
     * nested builder class
     */
    public static class JFrameAttributeBuilder {
        private final JFrameAttribute jFrameAttribute;

        public JFrameAttributeBuilder() {
            jFrameAttribute = getDefaultAttribute("");
        }


        /**
         * set window size with percentage of screen
         *
         * @param percentageOfScreen percentage of screen
         *                           0 <= percentageOfScreen <= 1
         * @return JFrameAttributeBuilder
         */
        public JFrameAttributeBuilder setWindowSizeWithPercentageOfScreen(double percentageOfScreen) {
            assert percentageOfScreen >= 0 && percentageOfScreen <= 1;
            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            jFrameAttribute.windowWidth = (int) (screenSize.getWidth() * percentageOfScreen);
            jFrameAttribute.windowHeight = (int) (screenSize.getHeight() * percentageOfScreen);
            return this;
        }

        /**
         * builder methods
         */
        public JFrameAttributeBuilder setWindowWidth(int windowWidth) {
            jFrameAttribute.windowWidth = windowWidth;
            return this;
        }

        public JFrameAttributeBuilder setWindowHeight(int windowHeight) {
            jFrameAttribute.windowHeight = windowHeight;
            return this;
        }

        public JFrameAttributeBuilder setTitle(String title) {
            if (title == null)
                title = "";
            jFrameAttribute.title = title;
            return this;
        }

        public JFrameAttributeBuilder setCenter(boolean center) {
            jFrameAttribute.isCenter = center;
            return this;
        }

        public JFrameAttributeBuilder setExit(boolean exit) {
            jFrameAttribute.isExit = exit;
            return this;
        }

        public JFrameAttributeBuilder setVisible(boolean visible) {
            jFrameAttribute.isVisible = visible;
            return this;
        }

        public JFrameAttributeBuilder setDefaultCloseOperation(int defaultCloseOperation) {
            jFrameAttribute.defaultCloseOperation = defaultCloseOperation;
            return this;
        }

        /**
         * After setting all the properties of the window, build JFrameAttribute
         *
         * @return JFrameAttribute
         */
        public JFrameAttribute build() {
            return jFrameAttribute;
        }
    }
}
