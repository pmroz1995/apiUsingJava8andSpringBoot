package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.CustomerRepository;
import com.eversis.recruitmenttask.dao.entity.Customer;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.eversis.recruitmenttask.dao.entity.Customer.customer;
import static org.junit.jupiter.api.Assertions.assertEquals;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CustomerServiceImplTest {

    @Autowired
    private CustomerRepository customerRepository;



    @Before
    public void setUp(){
        customerRepository.save(
                customer()
                    .CustomerName("Piotrek"));
        customerRepository.save(
                customer()
                        .CustomerName("Mirek"));
        customerRepository.save(
                customer()
                    .CustomerName("Halina"));

    }

    @Test
    public void checkIfCustomerAmountReturnProperValue(){
        assertEquals(3,customerRepository.findAll().size());
    }

    @Test
    public void checkIfThirdCustomerNameEqualsHalina(){
        Customer customer = customerRepository.findAll()
                                .stream()
                                .filter(e -> e.getCustomerName() == "Halina")
                                .findAny()
                                .get();
        Customer customer1 = customerRepository.findById(3l).get();

        assertEquals("Halina",customer.getCustomerName());
        assertEquals("Halina",customer1.getCustomerName());
    }



}
