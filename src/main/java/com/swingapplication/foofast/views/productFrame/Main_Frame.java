package com.swingapplication.foofast.views.productFrame;

import com.swingapplication.foofast.controllers.ProductController;
import com.swingapplication.foofast.dtos.responses.ListProductResponse;
import com.swingapplication.foofast.dtos.responses.ProductResponse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static java.lang.Math.min;

public class Main_Frame extends JFrame {


    private TopPanel topPanel;
    private BottomPanel bottomPanel;




    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(
                            UIManager.getSystemLookAndFeelClassName());
                    Main_Frame frame = new Main_Frame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    // create the frame
    public Main_Frame() {
        setResizable(false);

        getContentPane().setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1010, 730);
        setLocationRelativeTo(null);

        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/image/invoice.png")).getImage());


        topPanel = new TopPanel();
        bottomPanel = new BottomPanel();

        getContentPane().add(topPanel, BorderLayout.NORTH);
        getContentPane().add(bottomPanel, BorderLayout.CENTER);
    }


    

    









}
