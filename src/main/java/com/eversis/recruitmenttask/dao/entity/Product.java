package com.eversis.recruitmenttask.dao.entity;

import com.eversis.recruitmenttask.dao.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String missionName;

    private LocalDate productAcquisitionDate;

    @Embedded
    private ProductFootPrint productFootPrint;

    private Long productPrice;

    private String productUrl;

    private Status status;

    public static Product fluentBuild(){
        return new Product();
    }

    public Product id(Long id) {
        this.id = id;
        return this;
    }

    public Product productFootPrint(ProductFootPrint productFootPrint) {
        this.productFootPrint = productFootPrint;
        return this;
    }

    public Product productPrice(Long productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public Product productUrl(String productUrl) {
        this.productUrl = productUrl;
        return this;
    }

    public Product productAcquisitionDate(LocalDate productAcquisitionDate) {
        this.productAcquisitionDate = productAcquisitionDate;
        return this;
    }


    public Product status(Status status) {
        this.status = status;
        return this;
    }

    public Product missionName(String missionName) {
        this.missionName = missionName;
        return this;
    }
}
