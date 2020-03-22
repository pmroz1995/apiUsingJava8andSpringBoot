package com.eversis.recruitmenttask.services;

import com.eversis.recruitmenttask.dao.MissionRepository;
import com.eversis.recruitmenttask.dao.ProductRepository;
import com.eversis.recruitmenttask.dao.entity.Mission;
import com.eversis.recruitmenttask.dao.entity.Product;
import com.eversis.recruitmenttask.dao.entity.ProductFootPrint;
import com.eversis.recruitmenttask.dao.enums.ImageryType;
import com.eversis.recruitmenttask.dao.enums.Status;
import com.eversis.recruitmenttask.services.model.ProductRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private MissionRepository missionRepository;
    private MissionService missionService;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository,
                              MissionRepository missionRepository,
                              MissionService missionService){
        this.productRepository = productRepository;
        this.missionRepository = missionRepository;
        this.missionService = missionService;
    }

    @Override
    public List<Product> findProductsByMissionName(String missionName) {

     return missionRepository.findMissionByName(missionName)
                .orElseThrow(RuntimeException::new)
                .getProducts();
    }

    @Override
    public List<Product> findProductsByImageryType(ImageryType imageryType) {

        return missionRepository.findMissionByImargeryType(imageryType)
                .stream()
                .flatMap(e -> e.getProducts().stream())
                .collect(Collectors.toList());
    }


    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(ProductRequestDto productRequestDto) {
        ProductFootPrint productFootPrint = new ProductFootPrint()
                    .ax(productRequestDto.getAx())
                    .ay(productRequestDto.getAy())
                    .bx(productRequestDto.getBx())
                    .by(productRequestDto.getBy())
                    .cx(productRequestDto.getCx())
                    .cy(productRequestDto.getCy())
                    .dx(productRequestDto.getDx())
                    .dy(productRequestDto.getDy());

        Mission mission = missionRepository.findMissionByName(productRequestDto.getMissionName())
                .orElseThrow(RuntimeException::new);

        Product product = new Product()
                .missionName(productRequestDto.getMissionName())
                .productAcquisitionDate(productRequestDto.getProductAcquisitionDate())
                .productFootPrint(productFootPrint)
                .productPrice(productRequestDto.getProductPrice())
                .productUrl(productRequestDto.getProductUrl())
                .status(Status.AVAILABLE);

        mission.getProducts().add(product);
        missionService.editMission(mission,mission.getId());
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findProductsLowerThanDate(String date){
        return productRepository.findAll()
                .stream()
                .filter(e -> e.getProductAcquisitionDate().isBefore(parseStringToDate(date)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsGreaterThanDate(String date) {
        return productRepository.findAll()
                .stream()
                .filter(e -> e.getProductAcquisitionDate().isAfter(parseStringToDate(date)))
                .collect(Collectors.toList());
    }

    @Override
    public List<Product> findProductsBetweenTwoGivenDates(String firstDate, String secondDate) {
        return productRepository.findAll()
                .stream()
                .filter(e -> e.getProductAcquisitionDate().isAfter(parseStringToDate(firstDate)))
                .filter(e -> e.getProductAcquisitionDate().isBefore(parseStringToDate(secondDate)))
                .collect(Collectors.toList());
    }

    public LocalDate parseStringToDate(String date){
        return LocalDate.parse(date);
    }


}
