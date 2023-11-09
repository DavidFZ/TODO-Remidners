package edu.square.controller.view1;

import edu.square.controller.view1.component.DetailInformationComponentController;
import edu.square.controller.view1.component.GroupedListComponentController;
import edu.square.controller.view1.component.LeftSideComponentController;
import edu.square.entity.Reminder;
import edu.square.model.view1.ListModel;
import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.views.view1.view.ListView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class ListController {
    private final ListView listView;
    private final ListModel listModel;

    private final LeftSideComponentController leftSideComponentController;
    private final GroupedListComponentController groupedListComponentController;
    private final DetailInformationComponentController detailInformationComponentController;


    public ListController(ListView listView) {
        this.listView = listView;
        this.listModel = new ListModel();

        this.leftSideComponentController = new LeftSideComponentController(listView.leftSideComponent, listModel.leftSideComponentModel);
        this.groupedListComponentController = new GroupedListComponentController(listView.groupedListComponentView, listModel.groupedListComponentModel);
        this.detailInformationComponentController = new DetailInformationComponentController(listView.detailInformationComponent, listModel.detailInformationModel);

        initialize();
    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));

        ListView listView = new ListView(mainFrame, mainFrame.getSize());
        ListController listController = new ListController(listView);

        mainFrame.add(listView.getMainPanel());
        mainFrame.setVisible(true);
    }

    private void initialize() {
        //controller layer
        addListenersOnGroupedTitle();
        addListenersOnDoneStatusButtons();
    }

    /**
     * Add mouse listener on group title JPanel
     */
    private void addListenersOnGroupedTitle() {
        int groupCount = listModel.leftSideComponentModel.getGroupModels().size();

        for (int i = 0; i < groupCount; i++) {
            int finalI = i;
            leftSideComponentController.setMouseListenerOnGroupLabel(i, new MouseAdapter() {
                final String groupTitle = listModel.leftSideComponentModel.getGroupLabelText(finalI);

                @Override
                public void mouseClicked(MouseEvent e) {
                    /* model layer */
                    //update groupedListComponentModel
                    List<Reminder> reminderList = listModel.leftSideComponentModel.getGroupModels().get(finalI).getReminderModels();
                    listModel.groupedListComponentModel.setList(reminderList);

                    /* view layer */
                    //update group title
                    groupedListComponentController.setGroupedTitle(groupTitle);
                    //update groupedListComponent's model and view
                    groupedListComponentController.updateListModelAndView(reminderList);

                    /* controller layer */
                    addListenersOnDoneStatusButtons();
                }
            });
        }
    }

    private void addListenersOnDoneStatusButtons() {
        groupedListComponentController.addListenerOnDoneStatusButtons(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Model
                listModel.updateModelGlobally();

                //View
                leftSideComponentController.updateGroupCounterByModel();
            }
        });
    }

    /**
     * Refresh view
     * This method is called when exchange Views
     */
    public void refreshView() {
        addListenersOnDoneStatusButtons();
    }

    /**
     * Update list view & model
     * This method is called when component internal data is changed
     */
    public void updateModelAndView() {
        //Model
        listModel.updateModelGlobally();

        //View
        leftSideComponentController.updateGroupCounterByModel();
        groupedListComponentController.updateListViewByModel();
        detailInformationComponentController.updateViewByModel();
    }


}
