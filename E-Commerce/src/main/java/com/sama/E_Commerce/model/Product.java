package com.sama.E_Commerce.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int stockQuantity;
    private Boolean productAvailable;
    private BigDecimal price;
    private String name;
    private String description;
    private String brand;
    private String category;

    @JsonFormat(shape = JsonFormat.Shape.STRING , pattern="dd-mm-yyyy")
    private Date releaseDate;
    private String imageName;
    private String imageType;
    @Lob
    @Column(columnDefinition = "BYTEA")
    private byte[] imageData;

    public Product(int id)
    {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public Boolean getProductAvailable() {
        return productAvailable;
    }

    public void setProductAvailable(Boolean productAvailable) {
        this.productAvailable = productAvailable;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }

    public byte[] getImageData() {
        return imageData;
    }

    public void setImageData(byte[] imageData) {
        this.imageData = imageData;
    }

    public Product(int id, int stockQuantity, Boolean productAvailable, BigDecimal price, String name, String description, String brand, String category, String imageName, String imageType, byte[] imageData) {
        this.id = id;
        this.stockQuantity = stockQuantity;
        this.productAvailable = productAvailable;
        this.price = price;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.imageName = imageName;
        this.imageType = imageType;
        this.imageData = imageData;
    }

    public Product() {
    }
}
