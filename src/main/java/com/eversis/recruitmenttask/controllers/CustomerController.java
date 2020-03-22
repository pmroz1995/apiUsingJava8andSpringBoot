package com.eversis.recruitmenttask.controllers;

import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.exceptions.SupportingRuntimeError;
import com.eversis.recruitmenttask.services.CustomerService;
import com.eversis.recruitmenttask.services.model.ProductUserGrantsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eversis.recruitmenttask.exceptions.MessegeLibrary.INVALID_CUSTOMER_ID;
import static com.eversis.recruitmenttask.exceptions.MessegeLibrary.INVALID_CUSTOMER_OR_PRODUCT_ID;

@RestController
@RequestMapping("/customerController")
public class CustomerController{

    private CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService = customerService;
    }

    @PostMapping("/orderProduct/{productId}/{customerId}")
    public void orderProduct(@PathVariable Long productId,@PathVariable Long customerId){
        try {
            customerService.orderProduct(productId,customerId);
        }catch (Exception e) {
            throw new SupportingRuntimeError(INVALID_CUSTOMER_OR_PRODUCT_ID.format());
        }
    }

    @GetMapping("/orderedProductsByCustomer/{customerId}")
    public List<Product> orderedProducts(@PathVariable Long customerId){
        try {
            return customerService.orderedProducts(customerId);
        }catch (Exception e){
            throw new SupportingRuntimeError(INVALID_CUSTOMER_ID.format());
        }
    }

    @GetMapping("/displayAllProductsWithCustomerGrants")
    public List<ProductUserGrantsDto> allProductsWithCustomerGrants(){
        try {
            return customerService.findAllProductsWithGrantsForCustomer();
        }catch (Exception e){
            throw new SupportingRuntimeError("sdf");
        }
    }







}
