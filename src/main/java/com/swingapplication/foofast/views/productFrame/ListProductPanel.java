package com.swingapplication.foofast.views.productFrame;

import com.swingapplication.foofast.controllers.ProductController;
import com.swingapplication.foofast.dtos.responses.ListProductResponse;
import com.swingapplication.foofast.dtos.responses.ProductResponse;
import com.swingapplication.foofast.views.alert.CustomDialog;
import com.swingapplication.foofast.views.samples.ButtonSample;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

import lombok.*;

@Getter
@Setter
public class ListProductPanel extends JPanel {

    private InfoProductPanel[] productPanels;
    private ProductController productController;

    public ListProductPanel() {
        setLayout(new GridLayout(2, 3, 10, 10));
        setBorder(new EmptyBorder(10, 10, 10, 10));
        setPreferredSize(new Dimension(800, 600));
        setMaximumSize(new Dimension(800, 600));
        productController = new ProductController();
    }
    public void loadProduct(String key, int pageSize, int pageNumber,String fieldSort, String sorter) {
        this.removeAll();
        this.revalidate();
        this.repaint();

        ListProductResponse listProductResponse = productController.getAllProducts(key, pageSize, pageNumber,fieldSort, sorter);
        List<ProductResponse> products = listProductResponse.getProductResponses();
        int i;
        productPanels = new InfoProductPanel[min(products.size() ,pageSize)];
        for ( i = 0; i < min(products.size() ,pageSize); i++) {
            InfoProductPanel product = new InfoProductPanel(products.get(i).getName(), products.get(i).getPrice(), products.get(i).getQuantity_in_stock(), products.get(i).getImage(), products.get(i).getPurchase_count());
            add(product);
            productPanels[i] = product;
        }
        while (i < 6){
            add(new JPanel());
            i++;
        }
    }


}
