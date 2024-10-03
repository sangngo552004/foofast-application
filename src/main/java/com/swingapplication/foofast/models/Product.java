package com.swingapplication.foofast.models;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private long id;
    private String name;
    private long price;
    private int quantity_in_stock;
    private String image;
    private int purchase_count;
    private int is_active;
    private int category_id;
    private int discount_id;

    @Override
    public String toString() {
        return "\n  [PRODUCT]" + "\n" +
                "       id: " + this.id + "\n" +
                "       name: " + this.name + "\n" +
                "       price: " + this.price + "\n" +
                "       quantity_in_stock: " + this.quantity_in_stock + "\n" +
                "       image: " + this.image + "\n" +
                "       purchase_count: " + this.purchase_count + "\n" +
                "       is_active: " + this.is_active +"\n" +
                "       category_id: " + this.category_id + "\n" +
                "       discount_id: " + this.discount_id;

    }
}
