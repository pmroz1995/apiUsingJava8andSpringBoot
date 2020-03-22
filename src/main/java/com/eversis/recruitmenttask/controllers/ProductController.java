package com.eversis.recruitmenttask.controllers;

import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.dao.enums.ImageryType;
import com.eversis.recruitmenttask.exceptions.SupportingRuntimeError;
import com.eversis.recruitmenttask.services.ProductService;
import com.eversis.recruitmenttask.services.model.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.eversis.recruitmenttask.exceptions.MessegeLibrary.*;

@RestController
@RequestMapping("/productController")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/getAll")
    public Iterable<Product> getAllProducts(){
        return productService.findAll();
    }

    @GetMapping("/findProductsByMissionName/{name}")
    public List<Product> productByMissionName(@PathVariable String name){
        try {
            return productService.findProductsByMissionName(name);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_MISSION_NAME.format());
        }
    }

    @GetMapping("/findsProductsByImageryName/{imageryType}")
    public List<Product> productsByImageryName(@PathVariable ImageryType imageryType){
        try {
            return productService.findProductsByImageryType(imageryType);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_MISSION_NAME.format());
        }
    }

    @PostMapping("/postProduct")
    public void addProduct(@RequestBody ProductRequestDto productRequestDto){
        try {
            productService.save(productRequestDto);
        }catch(RuntimeException e){
           throw new SupportingRuntimeError(INVALID_MISSION_NAME.format());
        }
    }

    @DeleteMapping("/deleteProduct/{id}")
    public void deleteProduct(@PathVariable long id){
        try {
            productService.deleteById(id);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_INDEX.format());
        }
    }

    @GetMapping("/getProductsLowerThan/{date}")
    public List<Product> findProductsLowerThan(@PathVariable String date){
        try {
            return productService.findProductsLowerThanDate(date);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_DATE_FORM.format());
        }
    }

    @GetMapping("/getProductsGreaterThan/{date}")
    public List<Product> findProductsGreaterThan(@PathVariable String date){
        try {
            return productService.findProductsGreaterThanDate(date);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_DATE_FORM.format());
        }
    }

    @GetMapping("/getProductsBetweenTwoDates/{firstDate}/{secondDate}")
    public List<Product> findProductsBetweenTwoGivenDates(@PathVariable String firstDate,@PathVariable String secondDate){
        try {
            return productService.findProductsBetweenTwoGivenDates(firstDate,secondDate);
        }catch (RuntimeException e){
            throw new SupportingRuntimeError(INVALID_DATE_FORM.format());
        }
    }





}
