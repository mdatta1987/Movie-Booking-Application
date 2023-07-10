package com.upgrad.course.demo.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class ProductDTO {
    private int productId;
    @NotBlank(message = "Product name cannot be blank")
    @Size(min = 3, max = 100, message = "Product name cannot be less than 3 or greater than 100")
    private String productName;
    @NotBlank(message = "Product description cannot be blank")
    private String productDescription;

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                '}';
    }
}
