package edu.square.views.widget;

import lombok.Getter;


import javax.swing.*;
import java.awt.*;

public abstract class MWidget {
    @Getter
    protected final JPanel mainPanel;
    protected Dimension selfDimension;
    protected Dimension rootFrameDimension;

    public MWidget(Dimension rootFrameDimension, Dimension selfDimension) {
        mainPanel = new JPanel();
        mainPanel.setPreferredSize(selfDimension);
        this.selfDimension = selfDimension;
        this.rootFrameDimension = rootFrameDimension;

        initialize();
    }

    private void initialize() {
        initializeFonts();
        initializeMainPanel();
        initializeJComponents();
    }

    protected abstract void initializeMainPanel();

    protected abstract void initializeFonts();

    protected abstract void initializeJComponents();
}
