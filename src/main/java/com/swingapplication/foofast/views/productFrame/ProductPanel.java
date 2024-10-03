package com.swingapplication.foofast.views.productFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductPanel extends JPanel {

    private ListAddedProductPanel listAddedProductPanel;
    private ListPagiPanel listPagiPanel;

    public ProductPanel() {

        setBackground(SystemColor.WHITE);
        setForeground(SystemColor.desktop);
        setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        setPreferredSize(new Dimension(1010, 580));// Đảm bảo kích thước lớn hơn để chứa các sản phẩm
        setMaximumSize(new Dimension(1010, 580));


    }
    public void loadListPagiPanel(String key, int pageSize , String fieldSort, String sorter){
        this.removeAll();
        this.revalidate();
        this.repaint();
        listPagiPanel = new ListPagiPanel(key,pageSize,fieldSort, sorter);
        listAddedProductPanel = new ListAddedProductPanel();

//        Arrays.stream(listPagiPanel.getListProductPanel().getProductPanels()).forEach(b -> {
//            b.getAddButton().addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    int quantity = (int) b.getQuantity().getValue();
//                    if (quantity > 0) {
//                        String infoProduct = b.getInfoProduct() + quantity;
//                        listAddedProductPanel.loadInfoProduct(infoProduct);
//                        b.getQuantity().setValue(0);
//                    }
//
//                }
//            });
//        });


        add(listPagiPanel);
        add(listAddedProductPanel);

    }

}
