package com.gcu.data;

import java.util.List;

import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.MongoTemplate;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;


@Service
public class RegisterDataService implements DataAccessInterface<UserEntity>{
	
		//Declaring and Initializing
	    private final MongoTemplate mongoTemplate;

	    //Constructor and initializing mongoTemplate
	    public RegisterDataService(MongoTemplate mongoTemplate) {
	    	this.mongoTemplate=mongoTemplate;
	       
	    }

	    //method to create a new user in the database
	    @Override
	    public boolean createUser(UserEntity user) {
	        try {
	            mongoTemplate.save(user);
	            return true;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return false;
	        }
	    }

		@Override
		public List<UserEntity> findProducts() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean createProduct(UserEntity t) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean findUser() {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public boolean addUser(UserEntity t) {
			// TODO Auto-generated method stub
			return true;
		}

		@Override
		public ProductEntity findProductById(int productId) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public boolean deleteProduct(int id) {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public UserEntity findByUsername(String username) {
			// TODO Auto-generated method stub
			return null;
		}

}