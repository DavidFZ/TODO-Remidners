package edu.square;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

import static edu.square.utils.UIUtils.ComponentResizeUtil.getUniformScalingComponentAdapter;

public class test {
    public static void main(String[] args) throws IOException {
        JFrame jFrame = new JFrame();
        JLabel jLabel = new JLabel("test");
        JLabel jLabel2 = new JLabel("try");

        jLabel.setBackground(Color.RED);
        jLabel2.setBackground(Color.BLUE);

        jFrame.add(new Container());
        jFrame.setLayout(new FlowLayout(FlowLayout.CENTER, 30, 15));

        jFrame.add(jLabel);
        jFrame.add(jLabel2);
        jFrame.setVisible(true);

        jFrame.addComponentListener(getUniformScalingComponentAdapter(Arrays.asList(jFrame.getComponents()), 0.5d));

    }
}
