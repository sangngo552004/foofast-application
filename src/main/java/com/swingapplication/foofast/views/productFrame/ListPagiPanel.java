package com.swingapplication.foofast.views.productFrame;

import com.swingapplication.foofast.controllers.ProductController;
import com.swingapplication.foofast.dtos.responses.ListProductResponse;
import com.swingapplication.foofast.dtos.responses.ProductResponse;
import lombok.extern.log4j.Log4j2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;
import lombok.*;

@Getter
@Setter
@Log4j2
public class ListPagiPanel extends JPanel {
    private ProductController productController;
    private ListProductPanel listProductPanel ;
    private PaginationPanel paginationPanel ;

    public ListPagiPanel(String key, int pageSize, String fieldSort, String sorter){
        setBackground(SystemColor.WHITE);
        setForeground(SystemColor.desktop);
        setLayout(new BoxLayout(this ,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(800, 580));
        setMaximumSize(new Dimension(800, 580));

        paginationPanel = new PaginationPanel(key, pageSize);

        Arrays.stream(paginationPanel.getPages()).forEach(b -> {
            b.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int pageClicked = Integer.parseInt(b.getText().strip());
                    if (paginationPanel.getCurrentPage() != pageClicked) {
                        paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(3, 3, 252));
                        b.setBackground(new Color(2, 2, 71));
                        paginationPanel.setCurrentPage(pageClicked);
                        listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
                        log.info("end2");
                    }
                }
            });
        });
        paginationPanel.getPrevButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paginationPanel.getCurrentPage() > 1) {
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(3, 3, 252));
                    paginationPanel.setCurrentPage(paginationPanel.getCurrentPage() - 1);
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(2, 2, 71));
                    listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
                }

            }
        });
        paginationPanel.getNextButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paginationPanel.getCurrentPage() < paginationPanel.getCountPage()) {
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(3, 3, 252));
                    paginationPanel.setCurrentPage(paginationPanel.getCurrentPage() + 1);
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(2, 2, 71));
                    listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
                }

            }
        });
        paginationPanel.getFirstButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paginationPanel.getCurrentPage() != 1) {
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(3, 3, 252));
                    paginationPanel.setCurrentPage(1);
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(2, 2, 71));
                    listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
                }

            }
        });
        paginationPanel.getLastButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (paginationPanel.getCurrentPage() != paginationPanel.getCountPage()) {
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(3, 3, 252));
                    paginationPanel.setCurrentPage(paginationPanel.getCountPage());
                    paginationPanel.getPages()[paginationPanel.getCurrentPage()-1].setBackground(new Color(2, 2, 71));
                    listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
                }

            }
        });

        listProductPanel = new ListProductPanel();
        listProductPanel.loadProduct(key,pageSize, paginationPanel.getCurrentPage(),fieldSort, sorter);
        add(listProductPanel);
        add(paginationPanel);
    }
}
