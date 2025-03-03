package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;

@Service
public class LoginDataService implements DataAccessInterface<UserEntity> {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * CRUD: finder to return if user is in system with correct login
     */
    public boolean findUser(String inputUsername, String inputPassword) {
        // Construct a query to find the user by username and password
        Query query = new Query(Criteria.where("username").is(inputUsername).and("password").is(inputPassword));
        
        // Execute the query and check if any documents match
        long count = mongoTemplate.count(query, UserEntity.class);

        // If count is greater than 0, user exists
        return count > 0;
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
		public boolean createUser(UserEntity t) {
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
