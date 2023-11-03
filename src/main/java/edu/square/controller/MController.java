package edu.square.controller;

import edu.square.views.component.MComponent;

import java.util.List;

public class MController {
    protected List<MComponent> mComponents;

    public MController(MComponent... components) {
        mComponents = List.of(components);
    }
}
