package com.example.InvetoryDetailsProject.Dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Setter
@Getter
@AllArgsConstructor

public class ProductInventoryListDto {
    private List<ProductInventoryDto> productInventoryDtoList;
    public ProductInventoryListDto(){
        productInventoryDtoList=new ArrayList<>();
    }
}
