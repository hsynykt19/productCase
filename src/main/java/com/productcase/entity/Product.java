package com.productcase.entity;

import com.productcase.model.EnumProductType;
import lombok.Data;
import lombok.Generated;
import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Table(name = "PRODUCT")
@Generated
public class Product {

    @Id
    @GeneratedValue(generator = "SEQ_PRODUCT_USER", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "SEQ_PRODUCT_USER", sequenceName = "SEQ_PRODUCT_USER",allocationSize = 1)
    @Column(name="ID")
    private Long id;

    @Column(name = "PRODUCT_ID",unique = true)
    private String productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_USER")
    private String productUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "PRODUCT_TYPE")
    private EnumProductType productType;

    @Column(name = "PRODUCT_INSERT_DATE")
    private Timestamp productInsertDate;

    @Column(name = "PRODUCT_UPDATE_DATE")
    private Timestamp productUpdateDate;

}
