package com.swingapplication.foofast.controllers;


import com.swingapplication.foofast.daos.productDAO.IProductDAO;
import com.swingapplication.foofast.daos.productDAO.ProductDAO;

import com.swingapplication.foofast.dtos.responses.ListProductResponse;
import com.swingapplication.foofast.dtos.responses.ListUserResponse;
import com.swingapplication.foofast.mappers.ProductMapper;
import lombok.extern.log4j.Log4j2;
import java.util.stream.Collectors;

@Log4j2
public class ProductController {
    private final IProductDAO productDao;
    private final ProductMapper productMapper;

    public ProductController() {
        this.productDao = new ProductDAO();
        productMapper = ProductMapper.getInstance();
    }
    public int countPageByKey(String key,int pageSize){
        int numbersOfProduct = productDao.countProductsByKey(key);
        int numbersOfPage = numbersOfProduct / pageSize + (numbersOfProduct % pageSize == 0 ? 0 : 1);
        return numbersOfPage;
    }
    public ListProductResponse getAllProducts(String key, int pageSize, int pageNumber, String fieldSort, String sorter) {
        int totalProducts = productDao.countProductsByKey(key);
        log.info(totalProducts);
        int totalPages = (int) Math.ceil((double) totalProducts / (pageSize == 0 ? 10 : pageSize));

        return ListProductResponse.builder()
                .totalPages(totalPages)
                .productResponses(productDao.findAllByKey(key, pageSize, pageNumber, fieldSort, sorter)
                        .stream()
                        .map(productMapper::mapToProductResponse)
                        .collect(Collectors.toList()))
                .build();
    }
}
