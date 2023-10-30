package edu.square.views.view;

import edu.square.views.component.MComponent;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public abstract class MView {
    private final JPanel mainPanel;
    private List<MComponent> componentList;

    public MView(LayoutManager layoutManager) {
        mainPanel = new JPanel();
        mainPanel.setLayout(layoutManager);

        for (MComponent component : componentList) {
            mainPanel.add(component.getMainPanel());
        }
    }


}
