package com.eversis.recruitmenttask.services.model;

import com.eversis.recruitmenttask.dao.entity.ProductFootPrint;
import com.eversis.recruitmenttask.dao.enums.Status;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductUserGrantsDto{

    private Long id;
    private String missionName;
    private LocalDate productAcquisitionDate;
    private ProductFootPrint productFootPrint;
    private Long productPrice;
    private Status status;

    public ProductUserGrantsDto(){}

    public ProductUserGrantsDto missionName(String missionName) {
        this.missionName = missionName;
        return this;
    }

    public ProductUserGrantsDto productAcquisitionDate(LocalDate productAcquisitionDate) {
        this.productAcquisitionDate = productAcquisitionDate;
        return this;
    }

    public ProductUserGrantsDto productFootPrint(ProductFootPrint productFootPrint) {
        this.productFootPrint = productFootPrint;
        return this;
    }

    public ProductUserGrantsDto productPrice(Long productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductUserGrantsDto id(Long id) {
        this.id = id;
        return this;
    }

    public ProductUserGrantsDto status(Status status) {
        this.status = status;
        return this;
    }
}
