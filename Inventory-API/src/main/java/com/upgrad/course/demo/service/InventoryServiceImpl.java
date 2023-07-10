package com.upgrad.course.demo.service;

import com.upgrad.course.demo.dto.ProductDTO;
import com.upgrad.course.demo.entity.ProductEntity;
import com.upgrad.course.demo.exception.RecordNotFoundException;
import com.upgrad.course.demo.mapper.ProductMapper;
import com.upgrad.course.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private ProductRepo productRepo;

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = ProductMapper.convertDTOToEntity(productDTO);
        productEntity = productRepo.save(productEntity);

        return ProductMapper.convertEntityToDTO(productEntity);
    }

    @Override
    public ProductDTO getProduct(int productId) {
        ProductEntity productEntity = productRepo.findById(productId).orElseThrow(
                ()-> new RecordNotFoundException("No product with id["+productId+"] found"));

        return ProductMapper.convertEntityToDTO(productEntity);
    }

    @Override
    public List<ProductDTO> getAllProducts() throws RecordNotFoundException{
        Iterable<ProductEntity> productEntityIterable = productRepo.findAll();
        List<ProductDTO> productDTOList = StreamSupport.stream(productEntityIterable.spliterator(), false)
                .map(productEntity -> ProductMapper.convertEntityToDTO(productEntity))
                .collect(Collectors.toList());
        return productDTOList;
    }
}
