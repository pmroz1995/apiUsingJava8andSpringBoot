package com.eversis.recruitmenttask.dao.entity;

import com.eversis.recruitmenttask.dao.enums.ImageryType;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Mission {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    private String missionName;

    @Enumerated(EnumType.STRING)
    private ImageryType imageryType;

    private LocalDate startDate;

    private LocalDate finishDate;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public static Mission fluentBuild(){
        return new Mission();
    }
    public Mission id(Long id) {
        this.id = id;
        return this;
    }

    public Mission missionName(String missionName) {
        this.missionName = missionName;
        return this;
    }

    public Mission imageryType(ImageryType imageryType) {
        this.imageryType = imageryType;
        return this;
    }

    public Mission startDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public Mission finishDate(LocalDate finishDate) {
        this.finishDate = finishDate;
        return this;
    }

    public Mission products(List<Product> products) {
        this.products = products;
        return this;
    }
}
