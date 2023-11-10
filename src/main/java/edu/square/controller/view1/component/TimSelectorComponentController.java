package edu.square.controller.view1.component;

import edu.square.controller.MController;
import edu.square.model.component.MModel;
import edu.square.model.view1.component.TimeSelectorComponentModel;
import edu.square.utils.TimeUtils;
import edu.square.views.component.MComponent;
import edu.square.views.view1.component.TimeSelectorComponentView;

import javax.swing.*;
import java.sql.Timestamp;

import static edu.square.utils.UIUtils.JFrameFactory.getDefaultJFrame;

public class TimSelectorComponentController extends MController {
    private final TimeSelectorComponentView timeSelectorComponentView;
    private final TimeSelectorComponentModel timeSelectorComponentModel;
    private MComponent mComponentView;
    private MModel mModel;

    public TimSelectorComponentController(MComponent mComponentView, MModel mModel) {
        super(mComponentView, mModel);

        timeSelectorComponentModel = (TimeSelectorComponentModel) mModel;
        timeSelectorComponentView = (TimeSelectorComponentView) mComponentView;

        timeSelectorComponentView.getMonthsComboBoxPanelWidgetView().getjComboBox().addActionListener(e -> {
            int year = Integer.parseInt((String) timeSelectorComponentView.getYearsComboBoxPanelWidgetView().getjComboBox().getSelectedItem());
            int month = Integer.parseInt((String) timeSelectorComponentView.getMonthsComboBoxPanelWidgetView().getjComboBox().getSelectedItem());
            System.out.println(year + " " + month + "\n\n\n\n");
            timeSelectorComponentModel.days = TimeSelectorComponentModel.getDaysInMonth(year, month);
            timeSelectorComponentView.getDatesComboBoxPanelWidgetView().updateOptionsView(timeSelectorComponentModel.days);
        });
    }

    public static void main(String[] args) {
        JFrame jFrame = getDefaultJFrame(.8d, "Time Selector");
        TimeSelectorComponentView timeSelectorComponentView = new TimeSelectorComponentView(jFrame.getSize(), jFrame.getSize());
        jFrame.add(timeSelectorComponentView.getMainPanel());

        TimSelectorComponentController timSelectorComponentController = new TimSelectorComponentController(timeSelectorComponentView, new TimeSelectorComponentModel());
        jFrame.setVisible(true);
    }

    @Override
    public void initialize() {

    }

    public void isFlagged() {
        timeSelectorComponentView.getFlaggedRadio().isSelected();
    }

    public Timestamp getTimestamp() {
        //time judge
        String years = (String) timeSelectorComponentView.getYearsComboBoxPanelWidgetView().getjComboBox().getSelectedItem();
        String months = (String) timeSelectorComponentView.getMonthsComboBoxPanelWidgetView().getjComboBox().getSelectedItem();
        String dates = (String) timeSelectorComponentView.getDatesComboBoxPanelWidgetView().getjComboBox().getSelectedItem();
        String hours = (String) timeSelectorComponentView.getHoursComboBoxPanelWidgetView().getjComboBox().getSelectedItem();

        Timestamp timestamp = TimeUtils.convertToTimestamp(years, months, dates, hours);
        if (timestamp == null) {
            JOptionPane.showMessageDialog(null, "Please input correct time");
        }

//        //time should be later than now
//        if (timestamp.before(TimeUtils.getOneHourFormerTimestamp())) {
//            JOptionPane.showMessageDialog(null, "Please input time later than now");
//            return null;
//        }
        return timestamp;
    }
}
