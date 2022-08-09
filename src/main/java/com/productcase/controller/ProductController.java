package com.productcase.controller;

import com.productcase.entity.Product;
import com.productcase.model.ProductRequest;
import com.productcase.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("/product")
@Api
public class ProductController {

    private   final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @ApiOperation("/product/create")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> saveProduct(@Valid @RequestBody ProductRequest productRequest, @RequestHeader("Authorization") String authorization)  {
        Product response =  productService.insertProduct(productRequest,authorization);
        return new ResponseEntity<Product>(response, HttpStatus.OK);

    }

    @ApiOperation(value = "/product/productList")
    @GetMapping(value = "/productList")
    public ResponseEntity<List<Product>> getProduct(
                                                    @RequestHeader("Authorization") String authorization){
        List<Product> response =  productService.getProducts(authorization);
        return new ResponseEntity<List<Product>>(response, HttpStatus.OK);

    }
    @ApiOperation(value = "/product/update")
    @PutMapping(value = "/update")
    public ResponseEntity<Product> editProduct(@RequestBody ProductRequest productRequest, @RequestHeader("Authorization") String authorization) {
        Product response = productService.updateProduct(productRequest, authorization);
        return new ResponseEntity<Product>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "/product/cancel")
    @DeleteMapping(value = "/cancel")
    public ResponseEntity<HttpStatus> cancelProduct(@PathVariable String productId, @RequestHeader("Authorization") String authorization) {
        productService.cancelProduct(productId, authorization);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
