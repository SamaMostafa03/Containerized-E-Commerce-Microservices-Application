package com.sama.E_Commerce.repo;

import com.sama.E_Commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

    List<Product> findByNameContainingOrBrandContainingOrCategoryContaining(String name, String brand, String category);
    List<Product> findAllByOrderByIdAsc();
}
