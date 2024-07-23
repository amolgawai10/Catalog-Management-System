package com.application.demo.catalog_management_system.Repository;

import com.application.demo.catalog_management_system.Entity.Product;
import com.application.demo.catalog_management_system.Enum.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findByName(String name);

    public List<Product> findByBrand(String brand);

    public List<Product> findByCategory(Category category);
}
