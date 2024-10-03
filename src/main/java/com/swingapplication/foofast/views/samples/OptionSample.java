package com.swingapplication.foofast.views.samples;

import javax.swing.*;
import java.awt.*;

public class OptionSample extends JComboBox{

    public  OptionSample(String[] arr) {
        super(arr);
        setFont(new Font("Segoe UI", Font.BOLD, 15));
        setForeground(new Color(3, 3, 252));
        setPreferredSize(new Dimension(150, 30));

    }
}
