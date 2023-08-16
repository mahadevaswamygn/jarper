package com.example.InvetoryDetailsProject.service;

import com.example.InvetoryDetailsProject.Dto.ProductInventoryDto;
import com.example.InvetoryDetailsProject.Dto.ProductInventoryListDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class InventoryService {

    @Autowired
    RestTemplate restTemplate;

    //    public List<ProductInventoryDto> getLatestInventory() {
//        ProductInventoryListDto responseEntity=restTemplate.getForObject("http://localhost:8081/getLatestInventoryForEachProduct",ProductInventoryListDto.class);
////        ProductInventoryListDto all=responseEntity.
//        List<ProductInventoryDto> allProductDetails=responseEntity.getProductInventoryDtoList();
//        System.out.println(allProductDetails.get(1).getProductName()+ " "+allProductDetails.get(2).getProductName());
//        return allProductDetails;
//    }
//    public List<ProductInventoryDto> getLatestInventory() {
//        ResponseEntity<List<ProductInventoryDto>> responseEntity = restTemplate.exchange(
//                "http://localhost:8081/getLatestInventoryForEachProduct",
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<ProductInventoryDto>>() {
//                }
//        );
//
//        List<ProductInventoryDto> allProductDetails = responseEntity.getBody();
//        return allProductDetails;
//    }

    public ProductInventoryDto inventoryOfTheProduct(Integer productId) {
        ResponseEntity<ProductInventoryDto> responseEntity = restTemplate.getForEntity("http://localhost:8081/getInventoryOfTheProduct/"+productId, ProductInventoryDto.class);
        ProductInventoryDto productInventoryDto = responseEntity.getBody();
        return productInventoryDto;
    }


//    public List<ProductInventoryDto> getLatestInventory() {
//        System.out.println("hiiiiiiiiiiiiiiiiiiiiiiiiiiiiiii");
//        ProductInventoryListDto allResponseEntity=restTemplate.getForObject("http://localhost:8081/getLatestInventoryForEachProduct", ProductInventoryListDto.class);
//        List<ProductInventoryDto> latestInventory=new ArrayList<>();
//        System.out.println("h222222222222222222222222222222222222222222222222");
//        return latestInventory;
//    }

        public List<ProductInventoryDto> getLatestInventory() {
            ResponseEntity<List<ProductInventoryDto>> responseEntity = restTemplate.exchange("http://localhost:8081/getLatestInventoryForEachProduct",
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<ProductInventoryDto>>() {
                    });

            List<ProductInventoryDto> all = responseEntity.getBody();
            for (ProductInventoryDto productInventoryDto : all) {
                System.out.println(productInventoryDto.getProductName());
            }
            return all;
        }


//    public List<ProductInventoryDto> getLatestInventory() {
//        ResponseEntity<Object[]> responseEntity = restTemplate.getForEntity("http://localhost:8081/getLatestInventoryForEachProduct",Object[].class);
//        System.out.println("hiiiiiiiiiiiiiiii");
//        Object[] objects=responseEntity.getBody();
//        for (Object productInventoryDto : objects) {
//            System.out.println(productInventoryDto.toString());
//        }
//        ObjectMapper objectMapper=new ObjectMapper();
//        return Arrays.stream(objects)
//                .map(object -> objectMapper.convertValue(object, ProductInventoryDto.class))
//                .map(ProductInventoryDto::getProductId)
//                .map(ProductInventoryDto::getProductName)
//                .map(ProductInventoryDto::getLatestInventory)
//                .collect(Collectors.toList());
//    }


}
