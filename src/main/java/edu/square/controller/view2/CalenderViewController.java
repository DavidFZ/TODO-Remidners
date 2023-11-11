package edu.square.controller.view2;

import edu.square.controller.view1.component.GroupedListComponentController;
import edu.square.entity.Reminder;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.widget.ReminderModel;
import edu.square.views.view.CalenderView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;

public class CalenderViewController {
    public static final String[] MONTHS = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    private final CalenderView calenderView;
    private final GroupedListComponentController groupedListComponentController;

    private int indexMonth;

    public CalenderViewController(CalenderView calenderView) {
        this.calenderView = calenderView;

        Calendar calendar = Calendar.getInstance();
        indexMonth = Calendar.getInstance().get(Calendar.MONTH);

        groupedListComponentController = new GroupedListComponentController(calenderView.getGroupedListComponentView(), new GroupedListComponentModel());
        //disable add button
        groupedListComponentController.setAddButtonVisibility(false);
        initialize();
    }

    private void initialize() {
        indexMonth = Calendar.getInstance().get(Calendar.MONTH);
        updateThisYearListModelAndView();

        //bind button, refresh ui and model while click
        calenderView.addListenerOnNextLabel(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                indexMonth++;
                indexMonth %= 12;
                updateThisYearListModelAndView();
            }
        });
        calenderView.addListenerOnLastLaberl(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                indexMonth--;
                indexMonth = (indexMonth + 12) % 12;
                updateThisYearListModelAndView();
            }
        });
    }

    public void updateThisYearListModelAndView() {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        //update title
        groupedListComponentController.setGroupedTitle(year + " " + MONTHS[indexMonth]);

        //update list
        List<Reminder> list = ReminderModel.queryReminderByMonth(year, indexMonth + 1);
        groupedListComponentController.updateListModelAndView(list);
    }
}
