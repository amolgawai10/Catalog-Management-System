package com.application.demo.catalog_management_system.Controller;

import com.application.demo.catalog_management_system.Entity.Product;
import com.application.demo.catalog_management_system.Enum.Category;
import com.application.demo.catalog_management_system.Repository.ProductRepository;
import com.application.demo.catalog_management_system.Service.ProductService;
import org.hibernate.annotations.NotFound;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductRepository productRepository;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @PostMapping("/add")
    public ResponseEntity<String> addProduct(@RequestBody Product product) throws Exception{
        logger.info("addProduct API has started");
        try{
            String response = productService.addProduct(product);
            logger.info("addProduct API has ended");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        catch(Exception e){
            String msg = "Product can not be added :" + e.getMessage();
            logger.error("addProduct API failed due to error - "+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("getProductByName")
    public ResponseEntity<?> getProductByName(@RequestParam String name) throws Exception{
        logger.info("getProductByName API has started");
        try{
            Product product = productService.getProductByName(name);
            logger.info("getProductByName API has ended");
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        catch(Exception e){
            String msg = "Product not found";
            logger.error("getProductByName API failed due to error - "+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductByBrand")
    public ResponseEntity<?> getProductsByBrands(@RequestParam String brand) throws Exception{
        logger.info("getProductByBrand API has started");
        try{
            List<Product> product = productService.getProductByBrand(brand);
            logger.info("getProductByBrand API has ended");
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        catch(Exception e){
            String msg = "Product's brand is not available";
            logger.error("getProductByBrand API failed due to error "+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getProductByCategory")
    public ResponseEntity<?> getProductByCategory(@RequestParam Category cat) throws Exception{
        logger.info("getProductByCategory API has started");
        try{
            List<Product> product = productService.getProductByCategory(cat);
            logger.info("getProductByCategory API has ended");
            return new ResponseEntity<>(product,HttpStatus.OK);
        }
        catch(Exception e){
            String msg = "Category not exist";
            logger.error("getProductByCategory API failed due to error "+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateById")
    public ResponseEntity<?> updateProductById(@RequestParam Integer productId,
                                                   @RequestBody Product product) throws Exception{
        logger.info("update API has started");
        try{
            productService.updateProductById(productId, product);
            Product p = productRepository.findById(productId).orElse(null);
            logger.info("update API has ended");
            return new ResponseEntity<>(p, HttpStatus.OK);
        }
        catch(Exception e){
            String msg = "Invalid Entry";
            logger.error("Update API has failed due to error :"+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/updateByName")
    public ResponseEntity<?> updateProductByName(@RequestParam String name, @RequestBody Product product){

        logger.info("updateProductByName API has started");
        try{
            String res = productService.updateProductByName(name,product);
            logger.info("updateProductByName API has ended");
            return new ResponseEntity<>(res,HttpStatus.OK);
        }
        catch(Exception e){
            String msg = "can't update the product";
            logger.error("updateProductByName API has failed due to error :"+e.getMessage());
            return new ResponseEntity<>(msg,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteProduct(@RequestParam Integer productId){

        logger.info("Delete API has started");
        Product product = productRepository.findById(productId).orElse(null);
        if(product == null){
            logger.error("Delete API failed due to error");
            return new ResponseEntity<>("Id is invalid",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        productService.deleteProduct(productId);
        logger.info("Delete API has ended");
        return new ResponseEntity<>("Product is deleted Successfully", HttpStatus.OK);

    }


}
