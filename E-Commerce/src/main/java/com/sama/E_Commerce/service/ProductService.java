package com.sama.E_Commerce.service;

import com.sama.E_Commerce.model.Product;
import com.sama.E_Commerce.repo.ProductRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;
    public List<Product> viewAllProducts() {
        return productRepo.findAll();
    }
    public Product findProduct(int id){
        return productRepo.findById(id).orElse(null);
    }
//    @Transactional
    public void addOrUpdateProduct(Product product , MultipartFile imageFile) throws IOException {
        product.setImageName(imageFile.getOriginalFilename());
        product.setImageType(imageFile.getContentType());
        product.setImageData(imageFile.getBytes());
        productRepo.save(product);
    }
    public void deleteProduct(int id){
        productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword){
        return productRepo.findByNameContainingOrBrandContainingOrCategoryContaining(keyword,keyword,keyword);
    }


}
