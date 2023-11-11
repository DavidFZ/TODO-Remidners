package edu.square.views.view1.widget;

import org.junit.Test;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ComboBoxPanelWidgetViewTest {

    @Test
    public void main() {

    }

    @Test
    public void initializeMainPanel() {
    }

    @Test
    public void initializeFonts() {
        Dimension parentDimension = new Dimension(500,1000);
        Dimension dimension = new Dimension(250,500);
        String title = "la la la la";
        List<String> list = new ArrayList<>();
        list.add("ha ha ha ha");
        list.add("hw hw hw hw");
        ComboBoxPanelWidgetView comboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension,dimension,title,list);
        assertTrue(comboBoxPanelWidgetView.getMainPanel().isVisible());

    }

    @Test
    public void initializeJComponents() {
    }

    @Test
    public void updateOptionsView() {
    }

    @Test
    public void getjComboBox() {
    }
}