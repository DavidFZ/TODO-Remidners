package edu.square.views.view1.component;

import edu.square.model.view1.component.TimeSelectorComponentModel;
import edu.square.utils.UIUtils.FontUtil;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.utils.UIUtils.MComponentTestHelper;
import edu.square.views.component.MComponent;
import edu.square.views.view1.widget.BlockPanelWidget;
import edu.square.views.view1.widget.ComboBoxPanelWidgetView;
import lombok.Getter;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

import static edu.square.utils.UIUtils.ComponentResizeUtil.*;


public class TimeSelectorComponentView extends MComponent {
    @Getter
    private ComboBoxPanelWidgetView yearsComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView monthsComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView datesComboBoxPanelWidgetView;
    @Getter
    private ComboBoxPanelWidgetView hoursComboBoxPanelWidgetView;
    private Font font;
    @Getter
    private JRadioButton flaggedRadio;

    public TimeSelectorComponentView(Dimension parentDimension, Dimension selfDimension) {
        super(parentDimension, selfDimension);
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
        font = FontUtil.getBoldFont(parentDimension, FontUtil.FONT_SIZE_2);
    }

    @Override
    protected void initializeJComponents() {
        JLabel tipsLabel = new JLabel("Set Reminder Time");
        tipsLabel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.8, 0.1));
        tipsLabel.setFont(font);

        Dimension d = resizeDimensionWidthAndHeight(selfDimension, 0.4, 0.1);

        yearsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Year", null);
        monthsComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Month", null);
        datesComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Date", null);
        hoursComboBoxPanelWidgetView = new ComboBoxPanelWidgetView(parentDimension, d, "Hour", null);

        flaggedRadio = new JRadioButton("Flagged");
        flaggedRadio.setFont(FontUtil.getBoldFont(parentDimension, FontUtil.FONT_SIZE_2));

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
        BlockPanelWidget blockPanelWidget = new BlockPanelWidget(parentDimension, resizeDimensionHeightScale(parentDimension, 0.05));
        detailMessagePanel.add(blockPanelWidget.getMainPanel());
        detailMessagePanel.add(flaggedRadio);

        mainPanel.add(detailMessagePanel);
    }

    @Override
    protected void initializeView() {
        updateViews();
        setSelectedDefaultItem();
    }

    private void updateViews() {
        yearsComboBoxPanelWidgetView.updateOptionsView(TimeSelectorComponentModel.getFutureYears(5));
        monthsComboBoxPanelWidgetView.updateOptionsView(TimeSelectorComponentModel.getMonths());
        datesComboBoxPanelWidgetView.updateOptionsView(TimeSelectorComponentModel.getDaysInThisMonth());
        hoursComboBoxPanelWidgetView.updateOptionsView(TimeSelectorComponentModel.getHours());
    }

    private void setSelectedDefaultItem(int y, int m, int d, int h) {
        yearsComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(y));
        monthsComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(m));
        datesComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(d));
        hoursComboBoxPanelWidgetView.getjComboBox().setSelectedItem(String.valueOf(h));
    }

    private void setSelectedDefaultItem() {
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH) + 1;
        int date = calendar.get(Calendar.DATE);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);

        setSelectedDefaultItem(year, month, date, hour);
    }


}
