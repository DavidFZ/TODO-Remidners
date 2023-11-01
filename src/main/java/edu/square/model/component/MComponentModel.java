package edu.square.model.component;

import edu.square.views.component.MComponent;

public abstract class MComponentModel {
    private final MComponent mComponent;
    public MComponentModel(MComponent mComponent){
        this.mComponent = mComponent;
    }
}
