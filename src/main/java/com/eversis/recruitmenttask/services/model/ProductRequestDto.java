package com.eversis.recruitmenttask.services.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ProductRequestDto {

    private String missionName;
    private LocalDate productAcquisitionDate;
    private int ax;
    private int ay;
    private int bx;
    private int by;
    private int cx;
    private int cy;
    private int dx;
    private int dy;
    private Long productPrice;
    private String productUrl;

    public ProductRequestDto(){
    }

    public ProductRequestDto mission(String mission) {
        this.missionName = mission;
        return this;
    }

    public ProductRequestDto productAcquisitionDate(LocalDate productAcquisitionDate) {
        this.productAcquisitionDate = productAcquisitionDate;
        return this;
    }

    public ProductRequestDto ax(int ax) {
        this.ax = ax;
        return this;
    }

    public ProductRequestDto ay(int ay) {
        this.ay = ay;
        return this;
    }

    public ProductRequestDto bx(int bx) {
        this.bx = bx;
        return this;
    }

    public ProductRequestDto by(int by) {
        this.by = by;
        return this;
    }

    public ProductRequestDto cx(int cx) {
        this.cx = cx;
        return this;
    }

    public ProductRequestDto cy(int cy) {
        this.cy = cy;
        return this;
    }

    public ProductRequestDto dx(int dx) {
        this.dx = dx;
        return this;
    }

    public ProductRequestDto dy(int dy) {
        this.dy = dy;
        return this;
    }

    public ProductRequestDto productPrice(Long productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public ProductRequestDto productUrl(String productUrl) {
        this.productUrl = productUrl;
        return this;
    }
}
