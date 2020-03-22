package com.eversis.recruitmenttask.dgSetup;

import com.eversis.recruitmenttask.dao.CustomerRepository;
import com.eversis.recruitmenttask.dao.MissionRepository;
import com.eversis.recruitmenttask.dao.entity.Customer;
import com.eversis.recruitmenttask.dao.entity.Mission;
import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.dao.entity.ProductFootPrint;
import com.eversis.recruitmenttask.dao.enums.ImageryType;
import com.eversis.recruitmenttask.services.MissionService;
import com.eversis.recruitmenttask.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ApplicationContextEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
public class SetUpDb {
    private ProductService productService;
    private MissionService missionService;
    private MissionRepository missionRepository;
    private CustomerRepository customerRepository;
    @Autowired
    public SetUpDb(ProductService productService,
                   MissionRepository missionRepository,
                   MissionService missionService,
                   CustomerRepository customerRepository)
    {
        this.productService = productService;
        this.missionRepository = missionRepository;
        this.missionService = missionService;
        this.customerRepository = customerRepository;
    }

    @EventListener(ApplicationContextEvent.class)
    public void setUpDb(){
        Customer customer = new Customer()
                .id(1L)
                .CustomerName("Piotrek");



        Mission mission = Mission.fluentBuild()
                .missionName("Apollo 13")
                .imageryType(ImageryType.Hyperspectral)
                .startDate(LocalDate.of(2016, Month.NOVEMBER, 12))
                .finishDate(LocalDate.of(2019,Month.DECEMBER,7));

        Mission mission2 = Mission.fluentBuild()
                .id(2L)
                .missionName("Fly me to the moon")
                .imageryType(ImageryType.Multispectral)
                .startDate(LocalDate.of(2016, Month.APRIL, 8))
                .finishDate(LocalDate.of(2017,Month.JANUARY,15));

        Product product =Product.fluentBuild()
                .missionName("Apollo 13")
                .productAcquisitionDate(LocalDate.of(2016, Month.NOVEMBER, 12))
                .productFootPrint(new ProductFootPrint()
                        .ax(1).ay(1).bx(1).by(10).cx(10).cy(1).dx(10).dy(10)

                )
                .productPrice(124L)
                .productUrl("https://www.wikipedia.pl");

        missionService.save(mission);
        missionService.save(mission2);
        customerRepository.save(customer);

//        productService.save(new ProductRequestDto()
//                            .mission("Apollo13")
//                            .productAcquisitionDate(LocalDate.of(2016, Month.NOVEMBER, 12))
//                            .ax(1).ay(1).bx(1).by(10).cx(10).cy(1).dx(10).dy(10)
//                            .productPrice(157L)
//                            .productUrl("www.google.com"));

    }

}
