package edu.square.views.view2.view;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class CalenderPanelWidget extends MWidget {
    JPanel titlePanel = new JPanel();
    JPanel lastAndNextPanel = new JPanel();
    JPanel lastPanel = new JPanel();
    JPanel nextPanel = new JPanel();
    JLabel lastLabel = new JLabel("Last Month");
    JLabel nextLabel = new JLabel("Next Month");

    JLabel backLabel = new JLabel("back");

    public static int month;

    public static JPanel eachDayPanel = new JPanel();

    public JPanel dayPanel = new JPanel();

    Font font1;
    Font font2;
    Font font3;

    public CalenderPanelWidget(Dimension parentDimension, Dimension selfDimension) {
        super(parentDimension, selfDimension);
        //can change size
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(selfDimension);
        //title
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(resizeDimensionHeightScale(selfDimension, 0.05));
        JLabel titleLabel = new JLabel("Calender");
        titleLabel.setFont(font1);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(Color.black);
        mainPanel.add(titlePanel);

        //last month and next month
        lastAndNextPanel.setPreferredSize(resizeDimensionHeightScale(selfDimension, 0.05));
        lastAndNextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.05));
        nextPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.05));
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextPanel);
        lastAndNextPanel.setBackground(Color.yellow);
        mainPanel.add(lastAndNextPanel);


        //panel of days
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dayPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.99, 0.6));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay() - 1;
        month = this.GetMonth();
        Dimension dimension = resizeDimensionWidthAndHeight(selfDimension, 0.99, 0.6);
        eachDayPanel = new MonthPanel(month, dimension.width, dimension.height, dayOfWeek).monthPanel;
//      eachDayPanel.setBackground(Color.GREEN);
        dayPanel.add(eachDayPanel);
        dayPanel.setBackground(Color.green);
        mainPanel.add(dayPanel);
//        backLabel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                calenderFrame.dispose();
//            }
//        });

        lastLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month--;
                eachDayPanel.setVisible(false);
                Calendar calendar = Calendar.getInstance();
                int day;
                if (month >= 1) {
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                } else {
                    month = 12;
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }
            }
        });
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month++;
                eachDayPanel.setVisible(false);
                Calendar calendar = Calendar.getInstance();
                int day;
                if (month <= 12) {
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                } else {
                    month = 1;
                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
                    day = calendar.get(Calendar.DAY_OF_WEEK);
                    eachDayPanel = new MonthPanel(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).monthPanel;
                    eachDayPanel.setVisible(true);
                    dayPanel.add(eachDayPanel);
                }

            }
        });


    }

    public int GetThisMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public int GetMonth() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MONTH) + 1;
    }

    public JLabel GetBackButton() {
        return this.backLabel;
    }

    public JLabel GetLastButton() {
        return this.lastLabel;
    }

    public JLabel GetNextButton() {
        return this.nextLabel;
    }

    public JPanel getmainPanel() {
        return mainPanel;
    }

    @Override
    protected void initializeMainPanel() {
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
    }

    @Override
    protected void initializeFonts() {
        font1 = FontUtil.getBoldFont(rootFrameDimension, 0.04);
        font2 = FontUtil.getBoldFont(rootFrameDimension, 0.03);
        font3 = FontUtil.getBoldFont(rootFrameDimension, 0.008);
    }

    @Override
    protected void initializeJComponents() {

    }
}
