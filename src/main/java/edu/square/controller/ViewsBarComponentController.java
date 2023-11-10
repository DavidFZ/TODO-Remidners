package edu.square.controller;


import edu.square.model.view1.ListModel;
import edu.square.views.view1.view.ListView;

public class ViewsBarComponentController {
    private final ListView listView;
    private final ListModel listModel;

    public ViewsBarComponentController(ListView listView) {
        this.listView = listView;
        this.listModel = new ListModel();

        initialize();
    }
    private void initialize(){




    }
}
