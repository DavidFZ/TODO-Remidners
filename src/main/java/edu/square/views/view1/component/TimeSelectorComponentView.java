package edu.square.views.view1.component;

import edu.square.model.view1.component.TimeSelectorComponentModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view1.widget.ComboBoxPanelWidgetView;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

/**
 * This component is a little bit different from other components.
 * Which is, it is not subclass of MComponent.
 */

public class TimeSelectorComponentView extends MComponent {
    private final List<String> YEARS;
    private final List<String> MONTHS;
    private final List<String> HOURS;
    List<String> days;
    private ComboBoxPanelWidgetView yearsComboBoxPanelWidgetView;
    private ComboBoxPanelWidgetView monthsComboBoxPanelWidgetView;
    private ComboBoxPanelWidgetView datesComboBoxPanelWidgetView;
    private ComboBoxPanelWidgetView hoursComboBoxPanelWidgetView;
    private Font font;

    public TimeSelectorComponentView(Dimension parentDimension, Dimension selfDimension, TimeSelectorComponentModel timeSelectorComponentModel) {
        super(parentDimension, selfDimension);
        this.YEARS = timeSelectorComponentModel.YEARS;
        this.MONTHS = TimeSelectorComponentModel.MONTHS;
        this.HOURS = TimeSelectorComponentModel.HOURS;
        this.days = timeSelectorComponentModel.days;

        initializeJComponents();
    }

    public static void main(String[] args) {
        MComponentTestHelper mComponentTestHelper = new MComponentTestHelper() {
            @Override
            public void initializeMComponent() {
                TimeSelectorComponentView timeSelectorComponentView =
                        new TimeSelectorComponentView(
                                jFrame.getSize(),
                                resizeDimensionScale(jFrame.getSize(), 0.8),
                                new TimeSelectorComponentModel()
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
        Font font = FontUtil.getBoldFont(parentDimension, FontUtil.FONT_SIZE_1);
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
        JPanel b= JPanelUtil.getFlowJpanel(FlowLayout.CENTER);
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
