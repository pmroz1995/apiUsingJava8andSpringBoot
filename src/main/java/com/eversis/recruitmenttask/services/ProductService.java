package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.dao.enums.ImageryType;
import com.eversis.recruitmenttask.services.model.ProductRequestDto;

import java.util.List;


public interface ProductService {
    List<Product> findProductsByMissionName(String missionName);

    List<Product> findProductsByImageryType(ImageryType imageryType);

    Iterable<Product> findAll();

    void save(ProductRequestDto productRequestDto);

    void deleteById(Long id);

    List<Product> findProductsLowerThanDate(String date);

    List<Product> findProductsGreaterThanDate(String date);

    List<Product> findProductsBetweenTwoGivenDates(String firstDate, String secondDate);

}
