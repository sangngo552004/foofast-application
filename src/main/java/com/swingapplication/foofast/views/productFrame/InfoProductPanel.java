package com.swingapplication.foofast.views.productFrame;
import com.swingapplication.foofast.views.alert.CustomDialog;
import com.swingapplication.foofast.views.samples.ButtonSample;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import lombok.*;

@Getter
@Setter
public class InfoProductPanel extends JPanel{

    private JLabel imgLabel;
    private JPanel infoPanel;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JPanel buttonPanel;
    private JButton addButton;
    private JLabel purchaseCountLabel;
    private JSpinner Quantity;
    private String infoProduct;
    private ListAddedProductPanel listAddedProductPanel;

    public InfoProductPanel(String name, long price, int quantity, String img, int purcharseCount){
        setLayout(new BorderLayout());
        setBackground(new Color(200, 200, 200));
        setFont(new Font("Segoe UI", Font.BOLD, 15));

        // Ảnh sản phẩm
        imgLabel = new JLabel(loadImg(img,100,100));
        imgLabel.setBackground(new Color(200, 200, 200));
        add(imgLabel, BorderLayout.NORTH);

        // Thông tin sản phẩm
        infoPanel = new JPanel(new GridLayout(2, 1));
        nameLabel = new JLabel(name,SwingConstants.CENTER );
        priceLabel = new JLabel("Price: $" + price,SwingConstants.CENTER);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
        priceLabel.setFont(new Font("Segoe UI", Font.BOLD, 15));
        priceLabel.setForeground(new Color(3, 3, 252));
        nameLabel.setForeground(new Color(3, 3, 252));

        infoPanel.add(nameLabel);
        infoPanel.add(priceLabel);
        infoPanel.setBackground(new Color(200, 200, 200));
        add(infoPanel, BorderLayout.CENTER);

        buttonPanel = new JPanel();
        addButton = new ButtonSample("Add");
        purchaseCountLabel = new JLabel("Đã bán " + purcharseCount, SwingConstants.LEFT);
        purchaseCountLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, quantity + 1, 1); // Sử dụng int
        Quantity = new JSpinner(model);

        Quantity.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                // Lấy giá trị hiện tại của JSpinner
                int currentQuantity = (int) Quantity.getValue(); // Chuyển đổi về int
                System.out.println("Current Quantity: " + currentQuantity); // In giá trị hiện tại
                if (currentQuantity > quantity) {

                    CustomDialog successDialog = new CustomDialog(null, "Error", "Not enough " + name + ". Have only " + quantity, false,5000);
                    successDialog.setVisible(true);
                    Quantity.setValue(quantity);
                }
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listAddedProductPanel = new ListAddedProductPanel();
                listAddedProductPanel.loadInfoProduct(name+"/"+price+"/"+Quantity.getValue());
            }
        });
        buttonPanel.add(purchaseCountLabel);
        buttonPanel.add(Quantity);
        buttonPanel.add(addButton);

        infoProduct = name +"/"+price+"/";
        buttonPanel.setBackground(new Color(200, 200, 200));
        add(buttonPanel, BorderLayout.SOUTH);


    }
    private ImageIcon loadImg(String path, int width, int height)
    {

        if(path.charAt(0)== '/')
        {
            try {
                InputStream inputStream = getClass().getResourceAsStream(path);
                if (inputStream != null) {
                    BufferedImage originalImg = ImageIO.read(inputStream);

                    Image scaledImg = originalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                    BufferedImage bufferedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

                    Graphics2D g2d = bufferedImg.createGraphics();
                    g2d.drawImage(scaledImg, 0, 0, null);
                    g2d.dispose();

                    return new ImageIcon(bufferedImg);
                } else {

                    System.out.println("Input stream is null!");
                    return null;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
        else
        {
            try{

                BufferedImage originalImg = ImageIO.read(new File(path));
                Image scaledImg = originalImg.getScaledInstance(width, height, Image.SCALE_SMOOTH);

                BufferedImage bufferedImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                Graphics2D g2d = bufferedImg.createGraphics();
                g2d.drawImage(scaledImg, 0, 0, null);
                g2d.dispose();

                return new ImageIcon(bufferedImg);
            }
            catch (IOException e)
            {
                e.printStackTrace();
                return null;
            }
        }

    }
}
