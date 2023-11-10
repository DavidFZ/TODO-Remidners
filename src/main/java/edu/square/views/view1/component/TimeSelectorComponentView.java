package edu.square.views.view1.component;

import edu.square.model.view1.subframe.AddReminderConfirmFrameModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view1.widget.ComboBoxPanelWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;


public class TimeSelectorComponentView extends MComponent {
    private final List<String> YEARS = AddReminderConfirmFrameModel.getFutureYears(5);
    private final List<String> MONTHS = AddReminderConfirmFrameModel.getMonths();
    private final List<String> HOURS = AddReminderConfirmFrameModel.getHours();
    List<String> days = AddReminderConfirmFrameModel.getDaysInThisMonth();
    @Getter
    private ComboBoxPanelWidgetView yearsComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView monthsComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView datesComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView hoursComboBoxPanelWidgetView;
    private Font font;

    public TimeSelectorComponentView(Dimension parentDimension, Dimension selfDimension) {
        super(parentDimension, selfDimension);

        initializeJComponents();
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                TimeSelectorComponentView timeSelectorComponentView =
                        new TimeSelectorComponentView(
                                jFrame.getSize(),
                                resizeDimensionScale(jFrame.getSize(), 0.8)
                        );
                jFrame.add(timeSelectorComponentView.getMainPanel());
            }
        };
    }

    @Override
    protected void calculateSelfDimension() {
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = JPanelUtil.getCenterFlowMainPanel(selfDimension);
    }

    @Override
    protected void initializeFonts() {
        Font font = FontUtil.getBoldFont(parentDimension, FontUtil.FONT_SIZE_0);
    }

    @Override
    protected void initializeJComponents() {
        JLabel tipsLabel = new JLabel("Set Reminder Time");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.1));
        tipsLabel.setFont(font);

        Dimension d = resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.1);

        yearsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Year", YEARS);
        monthsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Month", MONTHS);
        datesComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Date", days);
        hoursComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Hour", HOURS);

        JPanel detailMessagePanel = JPanelUtil.getFlowJpanel(FlowLayout.CENTER, selfDimension);
        detailMessagePanel.add(tipsLabel);
        JPanel a = JPanelUtil.getFlowJpanel(FlowLayout.CENTER);
        a.add(yearsComboBoxPanelWidgetView.getMainPanel());
        a.add(monthsComboBoxPanelWidgetView.getMainPanel());
        JPanel b = JPanelUtil.getFlowJpanel(FlowLayout.CENTER);
        b.add(datesComboBoxPanelWidgetView.getMainPanel());
        b.add(hoursComboBoxPanelWidgetView.getMainPanel());
        detailMessagePanel.add(a);
        detailMessagePanel.add(b);

        mainPanel.add(detailMessagePanel);
    }

    @Override
    protected void initializeView() {

    }

}
