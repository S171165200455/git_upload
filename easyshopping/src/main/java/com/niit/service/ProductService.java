package com.niit.service;

import java.util.List;

import com.niit.model.Product;

public interface ProductService {
Product saveProduct(Product product);
List<Product> getAllProducts();
Product getProductById(String pId);
void deleteProduct(String id);
void updateProduct(Product product);
}