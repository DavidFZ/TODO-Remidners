package edu.square.views.view2;

import edu.square.utils.UIUtils.FontUtil;
import edu.square.views.widget.MWidget;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.List;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthAndHeight;

public class CalenderPanelWidget extends MWidget {
    JPanel titlePanel = new JPanel();
    JPanel lastAndNextPanel = new JPanel();
    JPanel lastPanel = new JPanel();
    JPanel nextPanel = new JPanel();
    JLabel lastLabel = new JLabel("<<Last Month");
    JLabel nextLabel = new JLabel("Next Month>>");

    JLabel backLabel = new JLabel("back");

    public static int month;

    public static MonthPanelWidget currentMonthPanelWidget;
    public static JPanel currentMonthPanel = new JPanel();

    public JPanel dayPanel = new JPanel();

    Font font1;
    Font font2;
    Font font3;

    public CalenderPanelWidget(Dimension parentDimension, Dimension selfDimension) {
        super(parentDimension, selfDimension);
        //can change size
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setSize(selfDimension);
        mainPanel.setBackground(new Color(195, 215, 223));
        //title
        titlePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setPreferredSize(resizeDimensionHeightScale(selfDimension, 0.05));
        JLabel titleLabel = new JLabel("This Year Calender");
        titleLabel.setFont(font1);
        titlePanel.add(titleLabel);
        titlePanel.setBackground(new Color(195, 215, 223));
        mainPanel.add(titlePanel);

        //last month and next month
        lastAndNextPanel.setPreferredSize(resizeDimensionHeightScale(selfDimension, 0.05));
        lastAndNextPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        lastLabel.setForeground(new Color(92,179,204));
        lastPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        lastPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.05));
        lastPanel.setBackground(new Color(195, 215, 223));
        nextLabel.setForeground(new Color(92,179,204));
        nextPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        nextPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.48, 0.05));
        nextPanel.setBackground(new Color(195, 215, 223));
        lastPanel.add(lastLabel);
        nextPanel.add(nextLabel);
        lastAndNextPanel.add(lastPanel);
        lastAndNextPanel.add(nextPanel);
        lastAndNextPanel.setBackground(new Color(195, 215, 223));
        mainPanel.add(lastAndNextPanel);


        //panel of days
        dayPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        dayPanel.setPreferredSize(resizeDimensionWidthAndHeight(selfDimension, 0.99, 0.77));
//      dayPanel.setBackground(Color.BLUE);
        int dayOfWeek = this.GetThisMonthFirstDay() - 1;
        month = this.getMonth();
        Dimension dimension = resizeDimensionWidthAndHeight(selfDimension, 0.99, 0.77);
        currentMonthPanelWidget = new MonthPanelWidget(month, dimension.width, dimension.height, dayOfWeek);
        currentMonthPanel = currentMonthPanelWidget.getMonthDayPanel();
        currentMonthPanel.setBackground(new Color(198, 230, 232));
        dayPanel.add(currentMonthPanel);
        dayPanel.setBackground(new Color(198, 230, 232));
//        dayPanel.setBackground(Color.BLACK);
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
                if (month == 0) {
                    month = 12;
                }
                changeCurrentMonthPanel();
//                if (month >= 1) {
//                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
//                    day = calendar.get(Calendar.DAY_OF_WEEK);
//                    currentMonthPanel = new MonthPanelWidget(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).getMonthDayPanel();
//                    currentMonthPanel.setVisible(true);
//                    dayPanel.add(currentMonthPanel);
//                } else {
//                    month = 12;
//                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
//                    day = calendar.get(Calendar.DAY_OF_WEEK);
//                    currentMonthPanel = new MonthPanelWidget(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).getMonthDayPanel();
//                    currentMonthPanel.setVisible(true);
//                    dayPanel.add(currentMonthPanel);
//                }
            }
        });
        nextLabel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                month++;
                if (month > 12) {
                    month = 1;
                }
                changeCurrentMonthPanel();
//                currentMonthPanel.setVisible(false);
//                Calendar calendar = Calendar.getInstance();
//                int day;
//                if (month <= 12) {
//                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
//                    day = calendar.get(Calendar.DAY_OF_WEEK);
//                    currentMonthPanel = new MonthPanelWidget(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).getMonthDayPanel();
//                    currentMonthPanel.setVisible(true);
//                    dayPanel.add(currentMonthPanel);
//                } else {
//                    month = 1;
//                    calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
//                    day = calendar.get(Calendar.DAY_OF_WEEK);
//                    currentMonthPanel = new MonthPanelWidget(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).getMonthDayPanel();
//                    currentMonthPanel.setVisible(true);
//                    dayPanel.add(currentMonthPanel);
//                }

            }
        });


    }

    private void changeCurrentMonthPanel() {
        currentMonthPanel.setVisible(false);
        Calendar calendar = Calendar.getInstance();
        int day;
        calendar.set(calendar.get(Calendar.YEAR), month - 1, 1);
        day = calendar.get(Calendar.DAY_OF_WEEK);
        currentMonthPanel = new MonthPanelWidget(month, (int) (0.98 * mainPanel.getWidth()), (int) (0.8 * mainPanel.getHeight()), day - 1).getMonthDayPanel();
        currentMonthPanel.setVisible(true);
        dayPanel.add(currentMonthPanel);
    }

    public List<CalendarDayPanel> getCurrentMonthCalendarDayPanelList() {
        return currentMonthPanelWidget.getCalendarDayPanelList();
    }

    public int GetThisMonthFirstDay() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return dayOfWeek;
    }

    public int getMonth() {
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

    public void addListenerOnNextLabel(MouseAdapter mouseAdapter) {
        nextLabel.addMouseListener(mouseAdapter);
    }

    public void addListenerOnLastLabel(MouseAdapter mouseAdapter) {
        lastLabel.addMouseListener(mouseAdapter);
    }
}
