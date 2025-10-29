package com.sama.E_Commerce.controller;

import com.sama.E_Commerce.model.Product;
import com.sama.E_Commerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/view-all")
    public ResponseEntity<List<Product>> viewAllProducts(){
        return new ResponseEntity<>(productService.viewAllProducts() , HttpStatus.OK);
    }

    @GetMapping("/find-product/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable int id){
        Product product = productService.findProduct(id);
        if(product != null) return new ResponseEntity<>(product, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/add-product")
    public ResponseEntity<?> addProduct(@RequestPart Product product , @RequestPart MultipartFile imageFile){
        try{
            productService.addOrUpdateProduct(product,imageFile);
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        catch (IOException e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete-product/{id}")
    public  ResponseEntity<?> deleteProduct(@PathVariable int id) {
        Product product = productService.findProduct(id);
        if (product != null) {
            productService.deleteProduct(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/search-product/{keyword}")
    public ResponseEntity<List<Product>> searchProducts(@PathVariable String keyword){
        List<Product> products= productService.searchProducts(keyword);
        return new ResponseEntity<>(products , HttpStatus.OK);
    }

    @PutMapping("/update-product/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id, @RequestPart Product product, @RequestPart MultipartFile imageFile) {
        Product selectedProduct = productService.findProduct(id);
        if (selectedProduct != null) {
            try {
                productService.addOrUpdateProduct(product, imageFile);
                return new ResponseEntity<>(HttpStatus.OK);
            } catch (IOException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
