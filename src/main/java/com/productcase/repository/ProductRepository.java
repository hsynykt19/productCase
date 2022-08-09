package com.productcase.repository;


import com.productcase.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("SELECT ap FROM Product ap where ap.productId=:productId and ap.productUser=:productUser")
    Optional<Product> findByProductIdAndProductUser(@Param(value = "productId") String productId, @Param(value = "productUser") String productUser);

    @Query("SELECT v FROM Product v WHERE v.productId = :productId")
    List<Product> getProducts(String productId);


}





