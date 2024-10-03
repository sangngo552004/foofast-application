package com.swingapplication.foofast.daos.productDAO;

import com.swingapplication.foofast.models.Product;
import com.swingapplication.foofast.models.User;
import com.swingapplication.foofast.utils.DatabaseUtil;
import lombok.extern.log4j.Log4j2;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public class ProductDAO implements IProductDAO{


    @Override
    public List<Product> findAll(){
        String sql = "SELECT * FROM Products;";

        List<Product> products = new ArrayList<>();

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery())
        {
            while (resultSet.next()) {
                products.add(buildProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Product save(Product entity) {
        return null;
    }

    @Override
    public Product update(Product entity) {
        return null;
    }

    @Override
    public List<Product> findAllByKey(String key, int pageSize, int pageNumber, String fieldSort, String sorter) {
        int offset = (pageNumber - 1) * (pageSize == 0 ? 10 : pageSize);
        List<Product> products = new ArrayList<>();

        String sql = "SELECT * FROM Products";

        if (!key.isEmpty()) {
            sql += " WHERE (`name` LIKE '%" + key +"%')";
        }
        if (!fieldSort.isEmpty() && !sorter.isEmpty()) {
            sql += " ORDER BY " + fieldSort + " " + sorter;
        }
        sql += " LIMIT " + (pageSize == 0 ? 10 : pageSize) + " OFFSET " + (offset) + ";";


        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql))
        {
            log.info(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                products.add(buildProductFromResultSet(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        log.info("end1");
        return products;
    }

    @Override
    public int countAllProducts() {
        String sql = "SELECT COUNT(*) FROM Products";

        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public int countProductsByKey(String key) {
        String sql = "SELECT COUNT(*) FROM Products";

        if (!key.isEmpty()) {
            sql += " WHERE (`name` LIKE ? )";
        }
        try (Connection connection = DatabaseUtil.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            if (!key.isEmpty()) {
                preparedStatement.setString(1, "%" + key + "%");
            }

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    @Override
    public Product setActiveOrInactive(Long id) {
        return null;
    }
    private Product buildProductFromResultSet(ResultSet resultSet) throws SQLException {
        return Product.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .price(resultSet.getInt("price"))
                .quantity_in_stock(resultSet.getInt("quantity_in_stock"))
                .image(resultSet.getString("image"))
                .purchase_count(resultSet.getInt("purchase_count"))
                .is_active(resultSet.getInt("is_active"))
                .category_id(resultSet.getInt("category_id"))
                .discount_id(resultSet.getInt("discount_id"))
                .build();
    }


}
