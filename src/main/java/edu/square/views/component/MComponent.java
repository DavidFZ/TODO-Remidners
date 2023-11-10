package edu.square.views.component;

import edu.square.views.view.MyView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;

@Getter
public abstract class MComponent {
    protected final Dimension parentDimension;
    protected Dimension selfDimension;
    protected JPanel mainPanel;

    public MComponent(Dimension parentDimension, Dimension componentPanelDimension) {
        this.parentDimension = parentDimension;
        selfDimension = componentPanelDimension;

        initializeMainPanel();
        initializeFonts();
    }

    public MComponent(MyView myView, Dimension selfDimension) {
        this.parentDimension = myView.getMainPanelDimension();
        this.selfDimension = selfDimension;

        initialize();

        myView.addMComponent(this);
    }

    private void initialize() {
        calculateSelfDimension();
        initializeMainPanel();
        initializeFonts();
        initializeJComponents();
        initializeView();
    }

    protected abstract void calculateSelfDimension();

    protected abstract void initializeMainPanel();

    protected abstract void initializeFonts();

    protected abstract void initializeJComponents();

    protected abstract void initializeView();
}
