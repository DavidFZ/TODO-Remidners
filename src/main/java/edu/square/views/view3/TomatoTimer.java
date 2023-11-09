package edu.square.views.view3;


import edu.square.utils.UIUtils.JFrameFactory;
import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.component.MComponent;
import edu.square.views.view.MyView;
import edu.square.views.view2.component.CalendarComponent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;

public class TomatoTimer extends MComponent {
    private int initialHours = 0;
    private int initialMinutes = 25;
    private int initialSeconds = 0;
    private int hours = initialHours;
    private int minutes = initialMinutes;
    private int seconds = initialSeconds;
    private Timer timer;
    private JLabel timerLabel;
    private JSpinner hourSpinner;
    private JSpinner minuteSpinner;
    private JButton setButton;
    private JButton startButton;
    private JButton stopButton;
    private JButton resetButton;

    public TomatoTimer(MyView myView, Dimension selfDimension) {
        super(myView, selfDimension);
    }

    private String getTime() {
        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    private void drawClockHand(Graphics2D g2d, int centerX, int centerY, int length, int angle, Color color, int thickness) {
        double radians = Math.toRadians(angle);
        int x = (int) (centerX + length * Math.cos(radians));
        int y = (int) (centerY + length * Math.sin(radians));
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness)); // 设置指针粗细
        g2d.drawLine(centerX, centerY, x, y);
    }


    public JPanel getTomatoTimerJPanel() {
        return mainPanel;
    }

    @Override
    protected void calculateSelfDimension() {

    }

    @Override
    protected void initializeMainPanel() {
        mainPanel = JPanelUtil.getCenterFlowMainPanel(selfDimension);
        mainPanel.setLayout(new BorderLayout());
    }

    @Override
    protected void initializeFonts() {

    }

    @Override
    protected void initializeJComponents() {
        JPanel timerPanel = new JPanel(new BorderLayout());
        timerLabel = new JLabel(getTime(), SwingConstants.CENTER);
        timerLabel.setFont(new Font("Arial", Font.BOLD, 36));
        timerPanel.add(timerLabel, BorderLayout.NORTH);

        JPanel clockPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                int centerX = getWidth() / 2;
                int centerY = getHeight() / 2;
                int radius = Math.min(centerX, centerY) - 10;
                Graphics2D g2d = (Graphics2D) g;
                g2d.setColor(Color.BLACK);

                // 绘制时钟圆
                Ellipse2D clockCircle = new Ellipse2D.Double(centerX - radius, centerY - radius, 2 * radius, 2 * radius);
                g2d.setStroke(new BasicStroke(3)); // 设置圆的粗细
                g2d.draw(clockCircle);

                // 绘制时钟数字
                Font numbersFont = new Font("Arial", Font.PLAIN, 20);
                g2d.setFont(numbersFont);
                g2d.setColor(Color.BLACK);
                for (int i = 1; i <= 12; i++) {
                    double angle = Math.toRadians(i * 30 - 90);
                    int x = (int) (centerX + (radius - 25) * Math.cos(angle));
                    int y = (int) (centerY + (radius - 25) * Math.sin(angle));
                    g2d.drawString(Integer.toString(i), x - 5, y + 5);
                }

                // 绘制时钟指针
                drawClockHand(g2d, centerX, centerY, radius - 50, (hours % 12) * 30 - 90, Color.BLUE, 6);//时钟
                drawClockHand(g2d, centerX, centerY, radius - 30, minutes * 6 - 90, Color.RED, 4);//分针
                drawClockHand(g2d, centerX, centerY, radius - 10, seconds * 6 - 90, Color.GREEN, 2);//秒针
            }
        };

        timerPanel.add(clockPanel, BorderLayout.CENTER);
        mainPanel.add(timerPanel, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel(new FlowLayout());

        hourSpinner = new JSpinner(new SpinnerNumberModel(initialHours, 0, 99, 1));
        minuteSpinner = new JSpinner(new SpinnerNumberModel(initialMinutes, 0, 59, 1));
        setButton = new JButton("Set Timer");
        startButton = new JButton("Start");
        stopButton = new JButton("Stop");
        resetButton = new JButton("Reset");

        setButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hours = (int) hourSpinner.getValue();
                minutes = (int) minuteSpinner.getValue();
                seconds = 0;
                timerLabel.setText(getTime());
                timer.stop();
                clockPanel.repaint();
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.start();
            }
        });

        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hours = initialHours;
                minutes = initialMinutes;
                seconds = initialSeconds;
                timerLabel.setText(getTime());
                timer.stop();
                hourSpinner.setValue(initialHours);
                minuteSpinner.setValue(initialMinutes);
                clockPanel.repaint();
            }
        });

        controlPanel.add(new JLabel("Set Timer:"));
        controlPanel.add(hourSpinner);
        controlPanel.add(new JLabel("h"));
        controlPanel.add(minuteSpinner);
        controlPanel.add(new JLabel("m"));
        controlPanel.add(setButton);
        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(resetButton);
        mainPanel.add(controlPanel, BorderLayout.SOUTH);

        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (hours == 0 && minutes == 0 && seconds == 0) {
                    timer.stop();
                    // 在这里可以添加提醒或其他操作
                } else if (seconds == 0) {
                    if (minutes == 0) {
                        hours--;
                        minutes = 59;
                    } else {
                        minutes--;
                    }
                    seconds = 59;
                } else {
                    seconds--;
                }
                timerLabel.setText(getTime());
                clockPanel.repaint();
            }
        });

//        tomatoTimerJPanel

//        SwingUtilities.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                TomatoTimer timer = new TomatoTimer();
//                timer.setVisible(true);
//            }
//        });
    }

    @Override
    protected void initializeView() {

    }

    public static void main(String[] args) {
        JFrame mainFrame = JFrameFactory.getDefaultJFrame(.8d, "Schedule");
        MyView myView = new MyView(mainFrame, mainFrame.getSize());
        TomatoTimer tomatoTimer = new TomatoTimer(myView, resizeDimensionHeightScale(mainFrame.getSize(), 0.9));
        mainFrame.setLayout(new FlowLayout(FlowLayout.LEFT));
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.add(tomatoTimer.getTomatoTimerJPanel());
        mainFrame.setVisible(true);
    }
}
