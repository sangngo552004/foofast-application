package com.swingapplication.foofast.views.productFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BottomPanel extends JPanel {

    private ProductPanel productPanel;
    private SearchOptionsPanel searchOptionsPanel;

    public BottomPanel(){

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        searchOptionsPanel = new SearchOptionsPanel();
        searchOptionsPanel.getSearchButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String key = searchOptionsPanel.getSearchField().getText();

                if(!key.isEmpty()) {
                    productPanel.loadListPagiPanel(key,6,"name","ASC");
                    searchOptionsPanel.getSearchField().setText(key);
                }else{
                    productPanel.loadListPagiPanel("",6,"name","ASC");
                    searchOptionsPanel.getSearchField().setText("");
                }
            }
        });
        searchOptionsPanel.getSubmitButton().addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e) {
                String textOptions1 = (String) searchOptionsPanel.getOptionsSortField().getSelectedItem();
                String textOptions2 = (String) searchOptionsPanel.getOptionsSorter().getSelectedItem();
                String sortField = "";
                String sorter;
                if(textOptions1.equals("Lượt mua")){
                    sortField += "purchase_count";
                }
                else if (textOptions1.equals("Giá")){
                    sortField += "price";
                }
                else{
                    sortField += "name";
                }
                if(textOptions2.equals("A-Z")){
                    sorter = "ASC";
                }else{
                    sorter = "DESC";
                }
                productPanel.loadListPagiPanel("",6,sortField,sorter);
            }
        });

        productPanel = new ProductPanel();
        productPanel.loadListPagiPanel("",6,"name","ASC");
        add(searchOptionsPanel);
        add(productPanel);
    }
}
