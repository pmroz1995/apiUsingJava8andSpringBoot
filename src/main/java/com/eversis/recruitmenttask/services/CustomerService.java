package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.services.model.ProductUserGrantsDto;

import java.util.List;

public interface CustomerService {

    void orderProduct(Long productId, Long customerId);

    List<Product> orderedProducts(Long customerId);

    List<ProductUserGrantsDto> findAllProductsWithGrantsForCustomer();

}
