package com.swingapplication.foofast.daos.productDAO;

import com.swingapplication.foofast.daos.IBaseDAO;
import com.swingapplication.foofast.models.Product;
import com.swingapplication.foofast.models.User;

import java.util.List;

public interface IProductDAO extends IBaseDAO<Product, Long> {

    List<Product> findAllByKey(String key, int pageSize, int pageNumber, String fieldSort, String sorter);
    int countAllProducts();

    int countProductsByKey(String key);
}
