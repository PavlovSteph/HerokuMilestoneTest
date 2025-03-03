package com.gcu.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.repository.ProductsRepository;


@Service
public class ProductDataService implements DataAccessInterface<ProductEntity> {

	// Declare and Initializing
	@Autowired
	private ProductsRepository productsRepository;
	private MongoTemplate mongoTemplate;

	/**
	 * Non-Default constructor for constructor injection
	 * 
	 * @param ordersRespository Specified for ordersRepository
	 */
	public ProductDataService(ProductsRepository productsRepository, MongoTemplate mongoTemplate) {
		this.productsRepository = productsRepository;
		this.mongoTemplate=mongoTemplate;
	}

	/**
	 * CRUD: finder to return all products
	 */
	public List<ProductEntity> findProducts() {
		List<ProductEntity> products = new ArrayList<ProductEntity>();

		Iterable<ProductEntity> productsIterable = productsRepository.findAll();

		productsIterable.forEach(products::add);

//		try {
//			Iterable<ProductEntity> productsIterable = ordersRepository.findAll();
//			
//			products = new ArrayList<ProductEntity>();
//			productsIterable.forEach(products::add);
//			
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}

		return products;
	}

	/**
	 * CRUD: create a product
	 */
	public boolean createProduct(ProductEntity product) {
		try {
			this.productsRepository.save(product);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	/**
	 * CRUD: Updating a product
	 */
	public boolean updateProduct(ProductEntity productEntity) {// read in the productId of the product the user selected
		
		productsRepository.save(productEntity);
		

		return false;
		
																// to update
//		// string statement to update the product
//		String sql = "UPDATE products SET PICTURE='?',NAME='?',EFFECTS='?',PRICE='?',INGREDIENTS='?' WHERE ID = ?";
//		try {
//			int update = jdbcTemplateObject.update(sql, productEntity.getPicURL(), productEntity.getName(),
//					productEntity.getEffects(), productEntity.getPrice(), productEntity.getIngredients());
//			return update > 0;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return false;
//		}
	}

	/**
	 * CRUD: delete a product
	 */
	public boolean deleteProduct(String id) {
		productsRepository.deleteById(id);

//		String sql = "DELETE FROM products WHERE ID = ?";
//		try
//		{
//			int rows = jdbcTemplateObject.update(sql, id);
//			
//			return rows == 1 ? true: false;
//		}
//		catch (Exception e)
//		{
//			e.printStackTrace();
//		}

		return false;
	}
	
	/**
	 * Search for a product
	 * @param searchTerm
	 * @return
	 */
	public List<ProductEntity> searchProducts(String searchTerm) {
	    // search for products by name
	    return productsRepository.findByNameContainingIgnoreCase(searchTerm);
	}

	@Override
	public boolean createUser(ProductEntity t) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean findUser() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean addUser(ProductEntity t) {
		// TODO Auto-generated method stub
		return true;
	}


	public ProductEntity getProductById(String id) {
		// TODO Auto-generated method stub
		// Implement logic to retrieve the product by its ID
		// Assuming you're using a JDBC template for database access
//		String query = "SELECT * FROM products WHERE id = ?";
//		ProductEntity product = jdbcTemplateObject.queryForObject(query, new Object[] { productId },
//				new ProductRowMapper());
		// ProductRowMapper is a class that maps a ResultSet row to a ProductModel
		// object
		return productsRepository.getProductById(id);
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductEntity findProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductEntity findByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

}
