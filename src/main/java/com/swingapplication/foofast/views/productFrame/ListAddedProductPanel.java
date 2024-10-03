package com.swingapplication.foofast.views.productFrame;

import com.swingapplication.foofast.views.samples.ButtonSample;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ListAddedProductPanel extends JPanel {

    private JPanel listAddedPanel;
    private JPanel totalPanel;
    private JLabel totalLabel;
    private JPanel labelPanel;
    private JPanel buttonPanel;

    public ListAddedProductPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(210, 580));
        setMaximumSize(new Dimension(210, 580));
        setBackground(new Color(250, 250, 250));

        labelPanel = new JPanel();
        labelPanel.setPreferredSize(new Dimension(210, 30));
        labelPanel.setMaximumSize(new Dimension(210, 30));
        labelPanel.setBackground(new Color(3, 3, 252));


        listAddedPanel = new JPanel();
        listAddedPanel.setLayout(new GridLayout(0,1));
        listAddedPanel.setBackground(new Color(200, 200, 200));
//        listAddedPanel.setAlignmentX(Component.LEFT_ALIGNMENT); // Căn trái cho các thành phần bên trong
        listAddedPanel.setPreferredSize(new Dimension(210, 450));
        listAddedPanel.setMaximumSize(new Dimension(210, 450));

        totalPanel = new JPanel();
        totalPanel.setPreferredSize(new Dimension(210, 70));
        totalPanel.setMaximumSize(new Dimension(210, 70));
        totalPanel.setBackground(new Color(3, 3, 252));
        totalLabel = new JLabel("TỔNG : 0$");
        totalLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        totalLabel.setForeground(new Color(250,250,250));
        totalPanel.add(totalLabel, SwingConstants.CENTER);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize(new Dimension(210, 30));
        buttonPanel.setMaximumSize(new Dimension(210, 30));
        JButton printButton = new ButtonSample("Xuất");
        JButton exitButton = new ButtonSample("Hủy");
        buttonPanel.add(exitButton);
        buttonPanel.add(printButton);

        // Thêm vào panel theo hàng dọc
        add(labelPanel);
        add(Box.createVerticalStrut(10)); // Tạo khoảng cách giữa các panel
        add(listAddedPanel);
        add(Box.createVerticalStrut(10));
        add(totalPanel);
        add(Box.createVerticalStrut(10));
        add(buttonPanel);
    }

    public void loadInfoProduct(String infoProduct) {
        String str = totalLabel.getText().split(" : ")[1];

        long sum = Long.parseLong(str.substring(0,str.length()-1));
        String[] infoArray = infoProduct.split("/");
        String name = infoArray[0];
        long price = Long.parseLong(infoArray[1]);
        long quantity = Long.parseLong(infoArray[2]);
        System.out.println(price + " " + quantity);
        sum += price * quantity;
        JLabel info = new JLabel(quantity + " x " + name + " : " + (price * quantity) +"$");
        info.setFont(new Font("Segoe UI", Font.BOLD, 10));
        info.setForeground(Color.BLACK);
        listAddedPanel.add(info);
        listAddedPanel.revalidate();
        listAddedPanel.repaint();
        totalLabel.setText("TỔNG : " + sum +"$");
    }
}
