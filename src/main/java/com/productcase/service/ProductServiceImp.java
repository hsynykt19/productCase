package com.productcase.service;

import com.productcase.entity.Product;
import com.productcase.exception.ProductNotFoundException;
import com.productcase.model.ProductRequest;
import com.productcase.repository.ProductRepository;
import com.productcase.util.Util;
import org.springframework.stereotype.Service;
import java.sql.Timestamp;
import java.util.List;

@Service
public class ProductServiceImp implements ProductService {
    private  ProductRepository productRepository;

    @Override
    public Product insertProduct(ProductRequest productRequest, String authorization) {
        Product product=new Product();
        product.setProductId(productRequest.getProductId());
        product.setProductName(productRequest.getProductName());
        product.setProductUser(Util.getClient(authorization));
        product.setProductType(productRequest.getProductType());
        product.setProductInsertDate(new Timestamp(System.currentTimeMillis()));
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
     return product;
    }

    @Override
    public List<Product> getProducts( String authorization) {
        return productRepository.findAll();
    }

    @Override
    public Product updateProduct(ProductRequest productRequest, String authorization)  {
        Product product=  getProduct(productRequest.getProductId(), authorization);
        product.setProductType(productRequest.getProductType());
        product.setProductName(productRequest.getProductName());
        product.setProductUpdateDate(new Timestamp(System.currentTimeMillis()));
        productRepository.save(product);
        return  product;
    }

    @Override
    public void  cancelProduct(String productId, String authorization) {
        Product product=  getProduct(productId, authorization);
        productRepository.delete(product);

    }

    public Product getProduct(String productId, String authorization)  {
        return    productRepository.findByProductIdAndProductUser(productId,Util.getClient(authorization))
                .orElseThrow(ProductNotFoundException::new);
    }
    public List<Product> productList(String productId){
        return productRepository.getProducts(productId);
    }
}
