package edu.square.views.component;

import edu.square.views.MyView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

public abstract class MComponent {
    @Getter
    protected final Dimension parentDimension;
    @Getter
    protected Dimension selfDimension;
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
        calculateSelfDimension();

        initialize();

    }

    public MComponent(MyView myView, Dimension selfDimension) {
        this.parentDimension = myView.getMainPanelDimension();
        this.selfDimension = selfDimension;

        initialize();

        myView.addMComponent(this);
    }

    private void initialize() {
        initializeMainPanel();
        initializeFonts();
        initializeJComponents();
        setColors();
    }

    protected abstract void calculateSelfDimension();

    protected abstract void initializeMainPanel();

    protected abstract void initializeFonts();

    protected abstract void initializeJComponents();

    protected abstract void setColors();
}
