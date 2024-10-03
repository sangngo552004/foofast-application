package com.swingapplication.foofast.views.samples;

import javax.swing.*;
import java.awt.*;

public class ButtonSample extends JButton {

    public ButtonSample(String ten) {
        super(ten);

        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        setFont(new Font("Segoe UI", Font.BOLD, 12));
        setOpaque(false); // Để bo góc hoạt động tốt
        setBackground(new Color(3, 3, 252));
        setForeground(new Color(250, 250, 250));
        setBorderPainted(false);



//        sample.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                sample.setBackground(new Color(250, 250, 250));
//                sample.setForeground(new Color(3, 3, 252));
//            }
//
//            @Override
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                sample.setBackground(new Color(3, 3, 252));
//                sample.setForeground(new Color(250, 250, 250));
//            }
//        });

    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ nền với góc bo tròn
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

        // Vẽ văn bản của nút
        g2.setColor(getForeground());
        FontMetrics fm = g2.getFontMetrics();
        Rectangle stringBounds = fm.getStringBounds(getText(), g2).getBounds();
        int textX = (getWidth() - stringBounds.width) / 2;
        int textY = (getHeight() - stringBounds.height) / 2 + fm.getAscent();
        g2.drawString(getText(), textX, textY);

        g2.dispose();
        super.paintComponent(g); // Gọi sau để không đè lên phần vẽ custom
    }
}
