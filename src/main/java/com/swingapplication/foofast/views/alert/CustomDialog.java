package com.swingapplication.foofast.views.alert;

import com.swingapplication.foofast.views.samples.ButtonSample;

import javax.swing.*;
import java.awt.*;

public class CustomDialog extends JDialog {

    public CustomDialog(JFrame parent, String title, String message, boolean isSuccess, int autoCloseTime) {
        super(parent, title, true);

        // Tạo Panel chứa thông báo
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Tạo Label cho thông báo
        JLabel label = new JLabel(message, SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Đặt màu nền theo trạng thái
        if (isSuccess) {
            panel.setBackground(new Color(144, 238, 144)); // Màu xanh lục nhạt cho thành công
        } else {
            panel.setBackground(new Color(255, 182, 193)); // Màu hồng nhạt cho lỗi
        }

        // Thêm label vào panel
        panel.add(label, BorderLayout.CENTER);

        // Tạo nút OK để đóng dialog
        JButton okButton = new ButtonSample("OK");
        okButton.addActionListener(e -> dispose());  // Đóng dialog khi nhấn nút

        // Thêm nút vào panel
        panel.add(okButton, BorderLayout.SOUTH);

        // Cấu hình dialog
        add(panel);
        setSize(300, 150);  // Kích thước của dialog
        setLocationRelativeTo(parent);  // Canh giữa màn hình

        // Thiết lập Timer để tự động đóng sau autoCloseTime (miliseconds)
        Timer timer = new Timer(autoCloseTime, e -> dispose());
        timer.setRepeats(false);  // Chỉ chạy một lần
        timer.start();
    }

}
