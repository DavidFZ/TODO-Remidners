package edu.square.views.loginview;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoginPanel {
    JPanel lPanel = new JPanel();
    JLabel nameLabel = new JLabel();
    int height,width;
    JPanel userNamePanel = new JPanel();
    JPanel passwordPanel = new JPanel();
    JButton loginButton = new JButton("Login");
    LoginPanel(int width,int height,String name){
        //two size of font
        Font smallFont = new Font("宋体",Font.BOLD,(int)(0.05*width));
        Font bigFont = new Font("宋体",Font.BOLD,(int)(0.1*width));
        //main panel

        lPanel.setPreferredSize(new Dimension(width,height));
        lPanel.setLayout(new FlowLayout(FlowLayout.LEFT,(int)(0.01*width),(int)(0.01*height)));
        //blanket panel
        JPanel highPanel = new JPanel();
        highPanel.setPreferredSize(new Dimension(width,(int)(0.05*height)));
        //name panel
        JPanel namePanel = new JPanel();
        namePanel.setPreferredSize(new Dimension(width,(int)(0.3*height)));
        nameLabel.setText(name);
        nameLabel.setFont(bigFont);
        namePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        namePanel.add(nameLabel);
        //username input here
        userNamePanel.setPreferredSize(new Dimension(width,(int)(0.1*height)));
        userNamePanel.setLayout(new FlowLayout(FlowLayout.LEFT,(int)(0.05*width),0));
        JPanel userNameLabelPanel = new JPanel();
        userNameLabelPanel.setPreferredSize(new Dimension((int)(0.4*width),(int)(0.2*height)));
        JPanel userNameTextFieldPanel = new JPanel();
        userNameTextFieldPanel.setPreferredSize(new Dimension((int)(0.4*width),(int)(0.2*height)));
        JLabel userNameLabel = new JLabel("UserName:");
        userNameLabel.setFont(smallFont);
        userNameLabelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        userNameLabelPanel.add(userNameLabel);
        JTextField userNameTextField = new JTextField(10);
        userNameTextField.setFont(smallFont);
        userNameTextFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        userNameTextFieldPanel.add(userNameTextField);
        userNamePanel.add(userNameLabelPanel);
        userNamePanel.add(userNameTextFieldPanel);
        //password input here
        passwordPanel.setPreferredSize(new Dimension(width,(int)(0.1*height)));
        passwordPanel.setLayout(new FlowLayout(FlowLayout.LEFT,(int)(0.05*width),0));
        JPanel passwordLabelPanel = new JPanel();
        passwordLabelPanel.setPreferredSize(new Dimension((int)(0.4*width),(int)(0.3*height)));
        JPanel passwordTextFieldPanel = new JPanel();
        passwordTextFieldPanel.setPreferredSize(new Dimension((int)(0.4*width),(int)(0.3*height)));
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setFont(smallFont);
        passwordLabelPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        passwordLabelPanel.add(passwordLabel);
        JTextField passwordTextField = new JTextField(10);
        passwordTextField.setFont(smallFont);
        passwordTextFieldPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        passwordTextFieldPanel.add(passwordTextField);
        passwordPanel.add(passwordLabelPanel);
        passwordPanel.add(passwordTextFieldPanel);
        //confirm panel
        JPanel loginButtonPanel = new JPanel();
        loginButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,(int)(0.2*width),0));
        loginButtonPanel.setPreferredSize(new Dimension(width,(int)(0.2*height)));
        loginButton.setPreferredSize(new Dimension((int)(0.2*width),(int)(0.1*height)));
        loginButton.setFont(smallFont);
        loginButtonPanel.add(loginButton);

        loginButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
            }
        });

        lPanel.add(highPanel);
        lPanel.add(namePanel);
        lPanel.add(userNamePanel);
        lPanel.add(passwordPanel);
        lPanel.add(loginButtonPanel);

        lPanel.setVisible(true);

    }

    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(1000,800);
        JPanel jp = new LoginPanel(1000,800,"Demo").lPanel;
        jf.add(jp);
        jf.setVisible(true);
    }
}
