package com.upgrad.course.demo.controller;

import com.upgrad.course.demo.dto.ProductDTO;
import com.upgrad.course.demo.service.InventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/inventoryApi")
public class InventoryController {

    private static Logger LOGGER = LoggerFactory.getLogger(InventoryController.class);

    @Autowired
    private InventoryService inventoryService;

    @GetMapping("/live")
    public Object checkStatus() {
        return ResponseEntity.ok("Inventory service is up and running");
    }

    @PostMapping("/v1/product")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody @Valid ProductDTO productDTO) {
        ProductDTO response = inventoryService.createProduct(productDTO);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/product/{productId}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Integer productId) {
        ProductDTO response = inventoryService.getProduct(productId);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/v1/product/all")
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        List<ProductDTO> response = inventoryService.getAllProducts();
        return ResponseEntity.ok(response);
    }
}
