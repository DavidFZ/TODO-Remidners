package edu.square.views.view1.widget;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;

import static org.junit.Assert.*;

public class GroupedTitleWidgetViewTest {

    @Test
    public void main() {

    }

    @Test
    public void initializeMainPanel() {
        Dimension parentDimension = new Dimension(1000,1000);
        Dimension selfDimension = new Dimension(500,500);
        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(parentDimension,selfDimension);
        assertEquals("Size is not equal", groupedTitleWidgetView.getMainPanel().getPreferredSize(),selfDimension);
    }

    @Test
    public void initializeFonts() {
        Dimension rootFrameDimension = new Dimension(1000,1000);
        Dimension selfDimension = new Dimension(500,500);
        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(rootFrameDimension,selfDimension);
        Font fontBig = FontUtil.getBoldFont(rootFrameDimension, 0.04);
        Font fontMid = FontUtil.getBoldFont(rootFrameDimension,0.03);
        Font fontSmall = FontUtil.getBoldFont(rootFrameDimension,0.008);
        assertEquals("Font1 size is not equal",fontBig,groupedTitleWidgetView.font1);
        assertEquals("Font2 size is not equal",fontMid,groupedTitleWidgetView.font2);
        assertEquals("Font3 size is not equal",fontSmall,groupedTitleWidgetView.font3);
    }

    @Test
    public void initializeJComponents() {
        Dimension rootFrameDimension = new Dimension(1000,1000);
        Dimension selfDimension = new Dimension(500,500);
        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(rootFrameDimension,selfDimension);

    }

    @Test
    public void setTitleLabel() {
        Dimension rootFrameDimension = new Dimension(1000,1000);
        Dimension selfDimension = new Dimension(500,500);
        GroupedTitleWidgetView groupedTitleWidgetView = new GroupedTitleWidgetView(rootFrameDimension,selfDimension);
        groupedTitleWidgetView.setTitleLabel("wow so rich");
        assertEquals("Title is not equal",groupedTitleWidgetView.getTitleLabel().getText(),"wow so rich");
    }

    @Test
    public void setAddButtonListener() {

    }

    @Test
    public void setAddButtonEnable() {
    }
}