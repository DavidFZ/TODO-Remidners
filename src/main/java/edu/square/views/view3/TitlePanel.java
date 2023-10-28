package edu.square.views.view3;
import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel{
    JLabel titleLabel = new JLabel();
    int width,height;
    JPanel leftPanel = new JPanel();
    JPanel rightPanel = new JPanel();
    JComboBox dayComboBox = new JComboBox();
    TitlePanel(String title, String[] s,int width,int height){
        this.width = width;
        this.height = height;
        titleLabel.setText(title);
        titleLabel.setFont(new Font("宋体",Font.BOLD,(int)(0.03*width)));
        leftPanel.setPreferredSize(new Dimension((int)(0.48*width),height));
        rightPanel.setPreferredSize(new Dimension((int)(0.48*width),height));
        this.add(leftPanel);
        this.add(rightPanel);
        for(int i = 0; i < s.length; i++){
            dayComboBox.addItem(s[i]);
        }
        leftPanel.add(titleLabel);
        rightPanel.add(dayComboBox);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(1000,1000);
        String[] s ={"TODAY","TOMORROW"};
        TitlePanel tp = new TitlePanel("four-quadrant",s,1000,200);
        jf.add(tp);
        jf.setVisible(true);
    }
}