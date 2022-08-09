package com.productcase.service;

import com.productcase.entity.Product;
import com.productcase.model.ProductRequest;
import java.util.List;

public interface ProductService {
    Product insertProduct(ProductRequest productRequest, String authorization);

    List<Product> getProducts( String authorization);

    Product updateProduct(ProductRequest productRequest, String authorization);

    void cancelProduct(String productId, String authorization);
}
