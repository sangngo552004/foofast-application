package com.swingapplication.foofast.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class ListProductResponse {
    private int totalPages;
    List<ProductResponse> productResponses;

    @Override
    public String toString(){
        return "\n  [LIST PRODUCT RESPONSE]" + "\n" +
                "       totalPages: " + this.totalPages + "\n" +
                "       listUserResponse: \n" + this.productResponses + "\n";
    }

}
