package edu.square.utils;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ColorChangeUtil {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("JPanel Color Animation");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 400);

            JPanel panel = new JPanel();
            panel.setBackground(Color.RED); // 初始背景颜色
            frame.add(panel);

            JButton button = new JButton("Change Color");
//            button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
            Color initialColor = panel.getBackground();
            Color targetColor = Color.BLUE; // 目标背景颜色
//                    animateBackgroundColor(panel, initialColor, targetColor, 1000, 1000);
//                }
//            });
            button.addMouseListener(getColorListener(panel, initialColor, targetColor));

            frame.add(button, BorderLayout.SOUTH);
            frame.setVisible(true);
        });
    }

    public static void animateBackgroundColor(JPanel panel, Color initialColor, Color targetColor, int fadeOutDuration, int fadeInDuration) {
        Timer fadeOutTimer = new Timer(20, new ActionListener() {
            private long startTime = -1;

            @Override
            public void actionPerformed(ActionEvent e) {
                if (startTime == -1) {
                    startTime = System.currentTimeMillis();
                }

                long currentTime = System.currentTimeMillis();
                long elapsedTime = currentTime - startTime;

                if (elapsedTime < fadeOutDuration) {
                    float fraction = (float) elapsedTime / fadeOutDuration;
                    int red = (int) (initialColor.getRed() + fraction * (targetColor.getRed() - initialColor.getRed()));
                    int green = (int) (initialColor.getGreen() + fraction * (targetColor.getGreen() - initialColor.getGreen()));
                    int blue = (int) (initialColor.getBlue() + fraction * (targetColor.getBlue() - initialColor.getBlue()));
                    panel.setBackground(new Color(red, green, blue));
                } else {
                    panel.setBackground(targetColor);
                    ((Timer) e.getSource()).stop();

                    Timer fadeInTimer = new Timer(20, new ActionListener() {
                        private long startTime = -1;

                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (startTime == -1) {
                                startTime = System.currentTimeMillis();
                            }

                            long currentTime = System.currentTimeMillis();
                            long elapsedTime = currentTime - startTime;

                            if (elapsedTime < fadeInDuration) {
                                float fraction = (float) elapsedTime / fadeInDuration;
                                int red = (int) (targetColor.getRed() - fraction * (targetColor.getRed() - initialColor.getRed()));
                                int green = (int) (targetColor.getGreen() - fraction * (targetColor.getGreen() - initialColor.getGreen()));
                                int blue = (int) (targetColor.getBlue() - fraction * (targetColor.getBlue() - initialColor.getBlue()));
                                panel.setBackground(new Color(red, green, blue));
                            } else {
                                panel.setBackground(initialColor);
                                ((Timer) e.getSource()).stop();
                            }
                        }
                    });
                    fadeInTimer.start();
                }
            }
        });
        fadeOutTimer.start();
    }

    public static MouseListener getColorListener(JPanel targetPanel, Color initialColor, Color targetColor) {
        return new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                animateBackgroundColor(targetPanel, initialColor, targetColor, 500, 500);
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

//        return new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                animateBackgroundColor(targetPanel, initialColor, targetColor, 1000, 1000);
//            }
//        };
    }
}
