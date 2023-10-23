package edu.square.views.component;

import edu.square.utils.UIUtils.JPanelUtil;
import edu.square.views.widget.ControlPanelView;
import edu.square.views.widget.TextFieldPanelView;

import javax.swing.*;
import java.awt.*;

import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionHeightScale;
import static edu.square.utils.UIUtils.ComponentResizeUtil.resizeDimensionWidthScale;
import static edu.square.utils.UIUtils.FontUtil.*;
import static edu.square.utils.UIUtils.JPanelUtil.getMainPanel;

public class DetailInformationView {


    public final Dimension parentJComponentDimension;

    private final Dimension mainPanelDimension;
    Font font1;
    Font font2;
    Font font3;
    private JPanel mainPanel;

    public DetailInformationView(JFrame parentFrame) {
        parentJComponentDimension = new Dimension(parentFrame.getWidth(), parentFrame.getHeight());
        mainPanelDimension = resizeDimensionWidthScale(parentJComponentDimension, 0.35);

        font1 = getBoldFont(parentJComponentDimension, FONT_SIZE_1);
        font2 = getBoldFont(parentJComponentDimension, FONT_SIZE_2);
        font3 = getBoldFont(parentJComponentDimension, FONT_SIZE_3);

        //set MainPanel
        mainPanel = JPanelUtil.getMainPanel(mainPanelDimension);
        mainPanel.setBackground(Color.yellow);


//        ControlPanelView
        {
            ControlPanelView controlPanelView = new ControlPanelView(mainPanelDimension, font3);
            mainPanel.add(controlPanelView.getControlPanel());

        }
        //TextPanel
        {
            JPanel textPanelDetail = new JPanel();
            textPanelDetail.setPreferredSize(resizeDimensionHeightScale(mainPanelDimension, 0.1));
            textPanelDetail.setLayout(new FlowLayout(FlowLayout.CENTER));
            JLabel detailLabel = new JLabel("Detail");
            detailLabel.setFont(font2);
            textPanelDetail.add(detailLabel);
            mainPanel.add(textPanelDetail);
        }
        //NamePanel
        {
            TextFieldPanelView nameTextFieldPanelView = new TextFieldPanelView(mainPanelDimension, font2, font3, "Name:");
            mainPanel.add(nameTextFieldPanelView.getPanel());


        }
//        NotePanel
        {
            TextFieldPanelView noteTextFieldPanelView = new TextFieldPanelView(mainPanelDimension, font2, font3, "Note:");
            mainPanel.add(noteTextFieldPanelView.getPanel());

        }
        //TextPanel
        {

        }
        //earlyReminderView
        {

        }
        //TextPanel
        {

        }
        //repeatPanel
        {

        }

    }


    public JPanel getMainPanel() {
        return mainPanel;
    }
}
