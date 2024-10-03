package com.swingapplication.foofast.mappers;


import com.swingapplication.foofast.dtos.requests.UserRequest;
import com.swingapplication.foofast.dtos.responses.ProductResponse;

import com.swingapplication.foofast.models.Product;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    static ProductMapper getInstance() {
        return Mappers.getMapper(ProductMapper.class);
    }

//    Product mapToProduct(UserRequest request);

//    Product updateToUser(UserRequest request, @MappingTarget User user);

    ProductResponse mapToProductResponse(Product user);
}
