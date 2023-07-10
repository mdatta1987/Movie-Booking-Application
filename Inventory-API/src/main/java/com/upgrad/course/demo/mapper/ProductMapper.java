package com.upgrad.course.demo.mapper;

import com.upgrad.course.demo.dto.ProductDTO;
import com.upgrad.course.demo.entity.ProductEntity;

public class ProductMapper {

    public static ProductEntity convertDTOToEntity(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductName(productDTO.getProductName());
        productEntity.setProductDescription(productDTO.getProductDescription());

        return productEntity;
    }

    public static ProductDTO convertEntityToDTO(ProductEntity productEntity) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(productEntity.getProductId());
        productDTO.setProductName(productEntity.getProductName());
        productDTO.setProductDescription(productEntity.getProductDescription());

        return productDTO;
    }
}
