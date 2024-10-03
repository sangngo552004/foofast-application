package com.swingapplication.foofast.views.productFrame;

import javax.swing.*;
import java.awt.*;

public class TopPanel extends JPanel{

    private JLabel menuLabel;

    public TopPanel(){

        setBackground(new Color(3, 3, 252));
        setOpaque(true);
        setPreferredSize(new Dimension(900, 100));
        setLayout(new BorderLayout());
        //thêm menuLabel vào topPanel
        menuLabel = new JLabel("MENU", SwingConstants.CENTER);
        menuLabel.setForeground(new Color(250,250,250));
        menuLabel.setFont(new Font("Segoe UI 16 Plain", Font.BOLD, 35));
        add(menuLabel, BorderLayout.CENTER);
    }
}
