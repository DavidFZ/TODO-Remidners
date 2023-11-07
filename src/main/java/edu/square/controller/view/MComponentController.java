package edu.square.controller.view;

import edu.square.views.component.MComponent;

public abstract class MComponentController {
    MComponent mComponent;

    public MComponentController() {
        initController();
    }

    public abstract void initController();
}
