package edu.square.views.view;

import edu.square.controller.MController;
import edu.square.views.component.MComponent;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public abstract class MView {
    @Getter
    private final JPanel mainPanel;
    private final MController controller;
    private List<MComponent> componentList;

    public MView(LayoutManager layoutManager, MComponent... components) {
        mainPanel = new JPanel();
        mainPanel.setLayout(layoutManager);
        //controller
        this.controller = new MController();
        //view
        componentList = new ArrayList<>(componentList);

        componentList = new ArrayList<>();
        for (MComponent component : componentList) {
            mainPanel.add(component.getMainPanel());
        }
    }


}
