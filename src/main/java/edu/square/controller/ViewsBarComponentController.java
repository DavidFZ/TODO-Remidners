package edu.square.controller;


import edu.square.views.ViewsBarComponentView;
import edu.square.views.view.MyView;
import edu.square.views.view1.widget.LabelPanelWidget;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ViewsBarComponentController {
    private static final String[] viewsTitles = {"TODO", "Calender", "TomatoTimer"};
    private final List<MyView> viewList;
    public ViewsBarComponentView viewsBarComponentView;
    private int selectedViewIndex = 0;

    public ViewsBarComponentController(Dimension rootFrameDimension, Dimension selfDimension, MyView... myView) {
        assert myView != null && myView.length > 0;
        assert myView.length == viewsTitles.length;

        //initialize
        viewsBarComponentView = new ViewsBarComponentView(rootFrameDimension, selfDimension, viewsTitles);
        viewList = List.of(myView);

        //set default selected view
        List<LabelPanelWidget> list = viewsBarComponentView.getLabelPanelWidgets();
        list.get(0).setBeSelected();


        for (int i = 0; i < myView.length; i++) {
            int finalI = i;
            list.get(i).getMainPanel().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (selectedViewIndex == finalI)
                        return;

                    setLabelWidgetViewSelection(finalI);
                    setOtherIndexMyViewInVisible(finalI);
                    selectedViewIndex = finalI;
                }
            });
        }

    }

    private void setOtherIndexMyViewInVisible(int index) {
        for (int i = 0; i < viewList.size(); i++) {
            if (i != index)
                viewList.get(i).getMainPanel().setVisible(false);
        }
    }

    private void setLabelWidgetViewSelection(int beSelectedIndex) {
        List<LabelPanelWidget> list = viewsBarComponentView.getLabelPanelWidgets();
        for (int i = 0; i < list.size(); i++) {
            if (i == beSelectedIndex)
                list.get(i).setBeSelected();
            else
                list.get(i).setNotSelected();
        }
    }
}
