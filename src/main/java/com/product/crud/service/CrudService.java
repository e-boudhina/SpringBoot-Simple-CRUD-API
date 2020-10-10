package com.product.crud.service;

import com.product.crud.model.Product;
import com.product.crud.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;


@Service
public class CrudService {
    //Injecting the repository
    @Autowired
    private ProductRepository repo;

    //Local Product
    private Product productToUpdate;

    public ArrayList<Product> fetchProductFromRepository(){
        return (ArrayList<Product>) repo.findAll();
    }

    public Product persistProductIntoRepository(Product product){
       return repo.save(product);
    }

    public Optional<Product> fetchProductFromRepositoryById(int id)
    {
        //I wanted to return a Json format pending on the case if found returns the object else return a message
        return repo.findById(id);
    }

    public String updateProductInRepository(Product product) {
        try {
            productToUpdate = repo.getOne(product.getId());

            productToUpdate.setName(product.getName());
            productToUpdate.setDesc(product.getDesc());
            productToUpdate.setPrice(product.getPrice());
            repo.save(productToUpdate);
            return "Product Updated";
        }catch (Exception e){
            return "There is no product registered under the ID: "+product.getId()+"\nMake sure you you send a valid product!";
        }
    }


//    public Boolean deleteProductById(int id) {
//        try
//        {
//            repo.deleteById(id);
//            return true;
//        }catch (Exception e){
//            return false;
//        }
//
//    }
     public String deleteProductById(int id) {
        try
        {
            repo.deleteById(id);
            return "Product Deleted Successfully";
        }catch (Exception e){
            return "Product not found";
        }

    }
}
