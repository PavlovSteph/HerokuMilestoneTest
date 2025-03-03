package com.gcu.business;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.ProductDataService;
import com.gcu.data.entity.ProductEntity;
import com.gcu.model.ProductModel;

@Service
public class ProductsBusinessService implements ProductsBusinessInterface{

	/**
	 * Service for accessing the data
	 */
	@Autowired
	private ProductDataService service;

	/**
	 * Gets the products by using the data access service
	 * @return List of products using ProductModel
	 */
	public List<ProductModel> getProducts() {
		
		//Get all the Entity products
    	List<ProductEntity> productEntity = service.findProducts();
    	
    	//Iterate over the Entity products and create a list of Domain Products
    	List<ProductModel> productsDomain = new ArrayList<ProductModel>();
    	for(ProductEntity entity : productEntity)
    	{
    		productsDomain.add(new ProductModel(entity.getID(), entity.getPicURL(), entity.getName(), entity.getEffects(), entity.getPrice(), entity.getIngredients()));
    	}
    	
    	//Return list of Domain Products
    	
    	return productsDomain;
	}

	/**
	 * Create a product using the data access service
	 * @param productEntity
	 * @return
	 */
	public boolean createProduct(ProductEntity productEntity) {
		//Making sure textboxes arent blank
		if (productEntity.getPicURL() == null || productEntity.getPicURL().isBlank() || 
		        productEntity.getName() == null || productEntity.getName().isBlank() ||
		        productEntity.getEffects() == null || productEntity.getEffects().isBlank() || 
		        productEntity.getPrice() == 0 || 
		        productEntity.getIngredients() == null || productEntity.getIngredients().isBlank()) {
			return false;
		} else {
			service.createProduct(productEntity);
			return true;
		}


	}
	
	/**
	 * Update a product using the data access service
	 * @param productEntity
	 * @return
	 */
	public boolean updateProduct(ProductEntity productEntity) {
		//Making sure textboxes arent blank
		if (productEntity.getPicURL() == null || productEntity.getPicURL().isBlank() || 
		        productEntity.getName() == null || productEntity.getName().isBlank() ||
		        productEntity.getEffects() == null || productEntity.getEffects().isBlank() || 
		        productEntity.getPrice() == 0 || 
		        productEntity.getIngredients() == null || productEntity.getIngredients().isBlank()) {
			return false;
		} else {
			service.updateProduct(productEntity);
			return true;
		}


	}

	
	/**
	 * Method to delete to a product
	 */
	public boolean deleteProduct(String id) {
		service.deleteProduct(id);
		
		return true;
	}
	
	/**
	 * Method to search for a product
	 * @param searchTerm
	 * @return
	 */
	public List<ProductModel> searchProducts(String searchTerm) {
	    List<ProductEntity> productEntityList = service.searchProducts(searchTerm);
	    
	    List<ProductModel> productModelList = new ArrayList<>();
	    for (ProductEntity entity : productEntityList) {
	        productModelList.add(new ProductModel(entity.getID(), entity.getPicURL(), entity.getName(), entity.getEffects(), entity.getPrice(), entity.getIngredients()));
	    }

	    return productModelList;
	}
	
	/**
	 * Method to find the product id for each product
	 */
	public ProductModel findProductById(String productId) {
		
		ProductEntity p = service.getProductById(productId);
		ProductModel product = new ProductModel(p.getID(), p.getPicURL(), p.getName(), p.getEffects(), p.getPrice(), p.getIngredients());
		
	    // ProductRowMapper is a class that maps a ResultSet row to a ProductModel object
	    return product;
	}

	@Override
	public boolean createProduct(ProductModel productModel) {
		// TODO Auto-generated method stub
		return false;
	}
}
