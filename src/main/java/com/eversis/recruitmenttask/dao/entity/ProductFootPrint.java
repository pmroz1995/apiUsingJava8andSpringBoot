package com.eversis.recruitmenttask.dao.entity;


import lombok.Getter;

import javax.persistence.Embeddable;

@Getter
@Embeddable
public class ProductFootPrint {

    private int ax;
    private int ay;
    private int bx;
    private int by;
    private int cx;
    private int cy;
    private int dx;
    private int dy;


    public ProductFootPrint ax(int ax) {
        this.ax = ax;
        return this;
    }

    public ProductFootPrint ay(int ay) {
        this.ay = ay;
        return this;
    }

    public ProductFootPrint bx(int bx) {
        this.bx = bx;
        return this;
    }

    public ProductFootPrint by(int by) {
        this.by = by;
        return this;
    }

    public ProductFootPrint cx(int cx) {
        this.cx = cx;
        return this;
    }

    public ProductFootPrint cy(int cy) {
        this.cy = cy;
        return this;
    }

    public ProductFootPrint dx(int dx) {
        this.dx = dx;
        return this;
    }

    public ProductFootPrint dy(int dy) {
        this.dy = dy;
        return this;
    }
}


