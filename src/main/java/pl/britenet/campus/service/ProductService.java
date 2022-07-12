package pl.britenet.campus.service;

import pl.britenet.campus.database.DatabaseService;
import pl.britenet.campus.object.Category;
import pl.britenet.campus.object.Product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) {
        this.databaseService = databaseService;
    }

    public List<Product> getProducts() {
        return this.databaseService.performSQL("SELECT p.id AS productId, p.name AS productName, p.description, p.price, c.id AS categoryId, c.name AS categoryName FROM product p INNER JOIN category c ON p.category = c.id",
                resultSet -> {

            List<Product> productList = new ArrayList<>();
            try {
                while (resultSet.next()) {
                    Category category = new Category(resultSet.getInt("categoryId"));
                    category.setName(resultSet.getString("categoryName"));

                    Product product = new Product(resultSet.getInt("productId"));
                    product.setName(resultSet.getString("productName"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    product.setCategory(category);
                    productList.add(product);
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return productList;
        });
    }

    public Optional<Product> getProduct(int id) {
        Product retrievedProduct = this.databaseService.performSQL(String.format("SELECT * FROM product WHERE id = %d", id), resultSet -> {
            try {
                if (resultSet.next()) {
                    Product product = new Product(resultSet.getInt("id"));
                    product.setName(resultSet.getString("name"));
                    product.setDescription(resultSet.getString("description"));
                    product.setPrice(resultSet.getDouble("price"));
                    return product;
                }
            } catch (SQLException exception) {
                throw new IllegalStateException(exception);
            }
            return null;
        });

        return Optional.of(retrievedProduct);
    }
}
