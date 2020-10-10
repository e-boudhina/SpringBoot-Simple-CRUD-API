package com.product.crud.controller;

import com.product.crud.model.Product;
import com.product.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CrudRestController {

    //Injecting the service
    @Autowired
    private CrudService service;

    ArrayList<Product> products;

    //Method one, the old way of mapping requests
    //    @RequestMapping(path ="/getproductlist",method = RequestMethod.GET)

    //Method 2 => directly straight to the point
    @GetMapping("/getproductlist")
    @CrossOrigin(origins = "http://localhost:4200")
    public ArrayList<Product> fetchProductList(){
        //Logic to fetch list from database
        products = new ArrayList<Product>();
         products = service.fetchProductFromRepository();
         return products;
    }

    @PostMapping("/addproduct")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product saveProduct(@RequestBody Product product){
        //Logic to save the product into database
       return service.persistProductIntoRepository(product);
    }

    @GetMapping("/getproductbyid/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Product fetchProductById(@PathVariable int id){
        //Logic to get product by id from database
        return service.fetchProductFromRepositoryById(id).get();
    }

    @PostMapping("/editproduct")
    @CrossOrigin(origins = "http://localhost:4200")
    public String updateProduct(@RequestBody Product product){
        //Logic to get update product from database
        return service.updateProductInRepository(product);
    }

    @DeleteMapping("/product/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProduct(@PathVariable int id){
        //Logic to get delete product by id from database



        return service.deleteProductById(id);
    }

}
/*
public Map<String, Boolean> deleteProduct(@PathVariable int id){
        //Logic to get delete product by id from database

        Map<String, Boolean> response = new HashMap<>();

        if (service.deleteProductById(id)){
            response.put("Product deleted", Boolean.TRUE);
        }else response.put("Product not found", Boolean.FALSE);

        return response;

    }
*/
