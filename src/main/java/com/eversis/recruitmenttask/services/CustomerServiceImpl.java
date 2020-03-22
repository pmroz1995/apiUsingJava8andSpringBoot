package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.CustomerRepository;
import com.eversis.recruitmenttask.dao.ProductRepository;
import com.eversis.recruitmenttask.dao.entity.Customer;
import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.dao.enums.Status;
import com.eversis.recruitmenttask.services.model.ProductUserGrantsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {

    private ProductRepository productRepository;
    private CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ProductRepository productRepository,
                               CustomerRepository customerRepository){
        this.productRepository = productRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void orderProduct(Long productId, Long customerId) {
        Product product = productRepository.findById(productId).orElseThrow(RuntimeException::new).status(Status.UNDER_PROCESSING);
        Customer customer = customerRepository.findById(customerId).orElseThrow(RuntimeException::new);
        customer.getProducts().add(product);

        customerRepository.save(customer);

    }

    @Override
    public List<Product> orderedProducts(Long customerId){
        return customerRepository.findById(customerId).orElseThrow(RuntimeException::new)
                .getProducts();
    }

    @Override
    public List<ProductUserGrantsDto> findAllProductsWithGrantsForCustomer() {
      return productRepository.findAll()
              .stream()
              .filter(e -> e.getStatus().equals(Status.AVAILABLE))
              .map(x -> new  ProductUserGrantsDto()
                      .id(x.getId())
                      .missionName(x.getMissionName())
                      .productAcquisitionDate(x.getProductAcquisitionDate())
                      .productFootPrint(x.getProductFootPrint())
                      .productPrice(x.getProductPrice())
                      .status(x.getStatus()))
              .collect(Collectors.toList());
    }


}
