package org.springframework.samples.petclinic.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
    public List<Product> getAllProducts(){
        return productRepo.findAll();
    }

    public List<Product> getProductsCheaperThan(double price) {
        return productRepo.findByPriceLessThan(price);
    }

    public ProductType getProductType(String typeName) {
        return productRepo.findProductTypeByName(typeName);
    }

    public Product save(Product p){
        return null;       
    }
    
    public List<ProductType> findAllProductTypes(){
    	return productRepo.findAllProductTypes();
    }

    
}
