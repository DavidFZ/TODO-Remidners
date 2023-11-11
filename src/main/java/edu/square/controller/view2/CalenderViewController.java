package edu.square.controller.view2;

import edu.square.controller.view1.component.GroupedListComponentController;
import edu.square.entity.Reminder;
import edu.square.model.view1.component.GroupedListComponentModel;
import edu.square.model.view1.widget.ReminderModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.view.CalenderView;
import edu.square.views.view2.CalendarDayPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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
                updateCalenderModelAndView();
            }
        });
        calenderView.addListenerOnLastLaberl(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                indexMonth--;
                indexMonth = (indexMonth + 12) % 12;

                updateThisYearListModelAndView();
                updateCalenderModelAndView();
            }
        });
    }

    public void updateCalenderModelAndView() {
        List<CalendarDayPanel> list = calenderView.getCalendarComponentView().getCalenderPanelWidget().getCurrentMonthCalendarDayPanelList();
        int year = Calendar.getInstance().get(Calendar.YEAR);

        for (int i = 0; i < list.size(); i++) {
            int day = i + 1;

            //get reminder list of this day
            Date date = new Date(year - 1900, indexMonth, day);
            LocalDate localDate = date.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDate();

            //query and update model
            List<Reminder> dayList = ReminderModel.queryReminderByDate(localDate);
            list.get(i).setTodayReminderList(dayList);

            //update view
            if (dayList != null && dayList.size() > 0)
                list.get(i).setDayLabel(String.valueOf(dayList.size()));

            //add listener
            list.get(i).getDayPanel().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    //title
                    groupedListComponentController.setGroupedTitle(year + " " + MONTHS[indexMonth] + " " + day);
                    groupedListComponentController.setGroupedTitleFont(FontUtil.getBoldFont(10));
                    groupedListComponentController.updateListModelAndView(dayList);
                }
            });
        }
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
