package com.swingapplication.foofast.views.productFrame;

import com.swingapplication.foofast.views.samples.ButtonSample;
import com.swingapplication.foofast.views.samples.OptionSample;

import javax.swing.*;
import java.awt.*;
import lombok.*;

@Getter
@Setter
public class SearchOptionsPanel extends JPanel {

    private ButtonSample searchButton;
    private ButtonSample submitButton;
    private JTextField searchField;
    private JPanel searchPanel;
    private OptionSample optionsSortField;
    private OptionSample  optionsSorter;
    private JPanel optionsPanel;

    public SearchOptionsPanel() {
        super(new BorderLayout());
        setPreferredSize(new Dimension(900, 50)); // Chiều cao 70px
        setMaximumSize(new Dimension(1010, 50));
        setOpaque(true);
        setBackground(new Color(250,250,250));

        // searchOptionsPanel gồm có searchPanel và optionPanel
        //searchPanel gồm có searchButton và search Field
        searchButton = new ButtonSample("Search");
        searchField = new JTextField(20);
        searchField.setFont(new Font("Segoe UI", Font.BOLD, 15));
        searchPanel = new JPanel();
        searchPanel.setBackground(new Color(250, 250, 250));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        // optionPanel gồm có submitButton, opstionsCategory và optionsSorter
        submitButton = new ButtonSample("Áp dụng");
        optionsSortField = new OptionSample(new String[]{"Tất cả","Lượt mua","Giá"});
        optionsSorter = new OptionSample(new String[]{"A-Z","Z-A"});
        optionsPanel = new JPanel();
        optionsPanel.setBackground(new Color(250,250,250));
        optionsPanel.add(submitButton);
        optionsPanel.add(optionsSortField);
        optionsPanel.add(optionsSorter);

        add(searchPanel, BorderLayout.WEST); // Bên trái
        add(optionsPanel, BorderLayout.EAST);
    }
}
