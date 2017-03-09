package com.niit.dao;

import java.util.List;

import com.niit.model.Product;

public interface ProductDao {
Product saveProduct(Product product);
List<Product> getAllProducts();
Product getProductById(String id);
void deleteProduct(String id);
void updateProduct(Product product);
}