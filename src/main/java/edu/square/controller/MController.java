package edu.square.controller;

import edu.square.model.component.MModel;
import edu.square.views.component.MComponent;

public abstract class MController {
    protected MComponent mComponentView;
    protected MModel mModel;

    public MController(MComponent mComponentView, MModel mModel) {
        this.mComponentView = mComponentView;
        this.mModel = mModel;
        initialize();
    }

    public abstract void initialize();
}
