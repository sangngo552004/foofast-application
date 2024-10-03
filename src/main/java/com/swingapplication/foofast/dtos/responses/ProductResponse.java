package com.swingapplication.foofast.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ProductResponse {
    private String name;
    private long price;
    private int quantity_in_stock;
    private String image;
    private int purchase_count;

    @Override
    public String toString() {
        return "\n  [PRODUCT RESPONSE]" + "\n" +
                "       name: " + this.name + "\n" +
                "       price: " + this.price + "\n" +
                "       quantity_in_stock: " + this.quantity_in_stock + "\n" +
                "       image: " + this.image + "\n"+
                "       purcharse_count:" + this.purchase_count;

    }
}
