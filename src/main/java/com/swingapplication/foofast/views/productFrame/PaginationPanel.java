package com.swingapplication.foofast.views.productFrame;
import com.swingapplication.foofast.controllers.ProductController;
import com.swingapplication.foofast.views.samples.ButtonSample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import lombok.*;

@Getter
@Setter
public class PaginationPanel extends JPanel{
    private JButton prevButton;
    private JButton lastButton;
    private JButton nextButton;
    private JButton firstButton;
    private  int currentPage;
    private int countPage;
    private JButton[] pages;

    private ProductController productController ;

    public PaginationPanel(String key, int pageSize){

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(900, 50)); // Chiều cao 70px
        setMaximumSize(new Dimension(1010, 50));// Căn giữa các nút
        setBackground(new Color(250,250,250));
        currentPage = 1;
        firstButton = new ButtonSample("<<");
        add(firstButton);
        prevButton = new ButtonSample("<");// Thêm nút "Previous"
        add(prevButton);
        productController = new ProductController();
        countPage = productController.countPageByKey(key, pageSize) ;
        pages = new JButton[countPage];
        for (int i = 0; i < countPage; i++) {
            JButton pageButton = new ButtonSample( " "+ (int)(i + 1) +" ");
            if(i==0){
                pageButton.setBackground(new Color(2, 2, 71));
            }
            pages[i]=pageButton;
            add(pageButton);
        }


        nextButton = new ButtonSample(">");// Thêm nút "Next"
        add(nextButton);

        lastButton = new ButtonSample(">>");// Thêm nút "Last" cho trang cuối
        add(lastButton);
    }
}
