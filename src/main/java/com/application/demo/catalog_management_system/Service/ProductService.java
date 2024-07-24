package com.application.demo.catalog_management_system.Service;

import com.application.demo.catalog_management_system.Controller.ProductController;
import com.application.demo.catalog_management_system.Entity.Product;
import com.application.demo.catalog_management_system.Enum.Category;
import com.application.demo.catalog_management_system.Repository.ProductRepository;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    Logger logger = LoggerFactory.getLogger(ProductService.class);
    @Autowired
    private ProductRepository productRepository;
    public String addProduct(Product product){
        logger.info("AddProduct method has been called");
        product.setCreatedOn(new Date());
        product.setUpdatedOn(new Date());
        productRepository.save(product);
        logger.info("AddProduct method has been ended");
        return "Product added successfully";
    }

    public Product getProductByName(String name){
        logger.info("GetProductByName method has been called");
        Product product  = productRepository.findByName(name);
        logger.info("GetProductByName method has been ended");
        return product;
    }

    public List<Product> getProductByBrand(String brand){
        logger.info("GetProductByBrand method has been called");
        List<Product> product = productRepository.findByBrand(brand);
        logger.info("GetProductByBrand method has been ended");
        return product;
    }

    public List<Product> getProductByCategory(Category category){
        logger.info("GetProductByCategory method has been called");
        List<Product> product = productRepository.findByCategory(category);
        logger.info("GetProductByCategory method has been ended");
        return product;
    }

    public void updateProductById(int productId, Product product) throws Exception{
        logger.info("UpdateProductById method has been called");
        Product getProduct = productRepository.findById(productId).orElse(null);
        getProduct.setBrand(product.getBrand());
        getProduct.setName(product.getName());
        getProduct.setCategory(product.getCategory());
        getProduct.setPrice(product.getPrice());
        getProduct.setQuantity(product.getQuantity());
        getProduct.setDescription(product.getDescription());
        getProduct.setCreatedOn(getProduct.getCreatedOn());
        getProduct.setUpdatedOn(new Date());
        productRepository.save(getProduct);
        logger.info("UpdateProductById method has been ended");
    }

    public String updateProductByName(String name, Product product) throws Exception{
        Product getProduct = productRepository.findByName(name);

        if(product == null){
            throw new RuntimeException(String.format("Not Available ",name));
        }
        logger.info("UpdateProductByName method has been called");
        getProduct.setBrand(product.getBrand());
        getProduct.setName(product.getName());
        getProduct.setCategory(product.getCategory());
        getProduct.setPrice(product.getPrice());
        getProduct.setQuantity(product.getQuantity());
        getProduct.setDescription(product.getDescription());
        getProduct.setCreatedOn(getProduct.getCreatedOn());
        getProduct.setUpdatedOn(new Date());
        productRepository.save(getProduct);
        logger.info("UpdateProductByName method has been ended");
        return "Details updated successfully";

    }

    public void deleteProduct(Integer productId){
        logger.info("DeleteProduct method has been called");
        productRepository.deleteById(productId);
        logger.info("DeleteProduct method has been ended");
    }

}
