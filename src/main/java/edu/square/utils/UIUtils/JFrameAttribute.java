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
    /** JFrameAttribute是否构建完成
     * Whether JFrameAttribute is built **/
    private boolean isAttributeSetDone;


    /**
     * private constructor
     */

    private JFrameAttribute() {
        isAttributeSetDone = false;
    }

    /**
     * 获取默认的JFrameAttribute对象
     * Get default JFrame attribute
     * 默认窗口大小为屏幕大小的80%
     * Default window size is 80% of the screen size
     *
     * @param frameTitle 窗口标题
     * @return JFrameAttribute 默认的JFrame属性
     */
    private static JFrameAttribute getDefaultAttribute(String frameTitle) {
        JFrameAttribute jFrameAttribute = new JFrameAttribute();
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        jFrameAttribute.windowWidth = ((int) (screenSize.getWidth() * 0.8));
        jFrameAttribute.windowHeight = ((int) (screenSize.getHeight() * 0.8));
        jFrameAttribute.title = (frameTitle);
        jFrameAttribute.isCenter = (true);
        jFrameAttribute.isExit = (true);
        return jFrameAttribute;
    }

    /**
     * 获取自定义窗口名的默认JFrameAttribute对象
     * Get the default JFrameAttribute with custom window name
     * @param frameTitle 窗口标题
     *                   window name
     * @return JFrameAttribute 自定义窗口名的默认JFrameAttribute
     *                         Default JFrameAttribute with custom window name
     */
    public static JFrameAttribute getAttribute(String frameTitle) {
        JFrameAttribute jFrameAttribute = getDefaultAttribute(frameTitle);
        jFrameAttribute.isAttributeSetDone = true;
        return jFrameAttribute;
    }


    /**
     * 获取窗口名为空的默认JFrameAttribute对象
     * Get the default JFrameAttribute with empty window name
     * @return JFrameAttribute 窗口名为空的默认JFrameAttribute
     *                         Default JFrameAttribute with empty window name
     */
    public static JFrameAttribute getAnonymousTitleAttribute() {
        return getAttribute("");
    }

    /**
     * 获取JFrameAttribute建造者
     * Get JFrameAttribute builder
     * 默认窗口名为空
     * Default window name is empty
     * @return JFrameAttribute 窗口名为空的默认JFrameAttribute
     *                        Default JFrameAttribute with empty window name
     */
    public static JFrameAttribute getAttributeBuilder() {
        return getDefaultAttribute("");
    }

    /**
     * 设置完窗口的所有属性,构建JFrameAttribute
     * After setting all the properties of the window, build JFrameAttribute
     *
     * @return this
     */
    public JFrameAttribute build() {
        this.isAttributeSetDone = true;
        return this;
    }


    /**
     * getter & builder
     */
    public int getWindowWidth() {
        return windowWidth;
    }

    public JFrameAttribute setWindowWidth(int windowWidth) {
        this.windowWidth = windowWidth;
        return this;
    }

    public int getWindowHeight() {
        return windowHeight;
    }

    public JFrameAttribute setWindowHeight(int windowHeight) {
        this.windowHeight = windowHeight;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public JFrameAttribute setTitle(String title) {
        if (title == null)
            throw new NullPointerException("title can not be null");
        this.title = title;
        return this;
    }

    public boolean isCenter() {
        return isCenter;
    }

    public JFrameAttribute setCenter(boolean center) {
        isCenter = center;
        return this;
    }

    public boolean isExit() {
        return isExit;
    }

    public JFrameAttribute setExit(boolean exit) {
        isExit = exit;
        return this;
    }

    public boolean isVisible() {
        return isVisible;
    }

    public JFrameAttribute setVisible(boolean visible) {
        isVisible = visible;
        return this;
    }

    public int getDefaultCloseOperation() {
        return defaultCloseOperation;
    }

    public JFrameAttribute setDefaultCloseOperation(int defaultCloseOperation) {
        this.defaultCloseOperation = defaultCloseOperation;
        return this;
    }

    public boolean isAttributeSetDone() {
        return isAttributeSetDone;
    }
}
