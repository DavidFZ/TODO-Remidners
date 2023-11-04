package edu.square.views.component;

import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public abstract class MComponent {
    @Getter
    protected final Dimension parentDimension;
    @Getter
    protected final Dimension selfDimension;
    @Getter
    protected JPanel mainPanel;

    public MComponent(Dimension parentDimension, Dimension componentPanelDimension) {
        this.parentDimension = parentDimension;
        selfDimension = componentPanelDimension;

        initializeMainPanel();
        initializeFonts();
    }

    public MComponent(Dimension parentDimension) {
        this.parentDimension = parentDimension;
        selfDimension = null;
    }

    protected abstract void initializeMainPanel();

    protected abstract void initializeFonts();

    protected abstract void initializeJComponents();

    protected abstract void setColors();
}
