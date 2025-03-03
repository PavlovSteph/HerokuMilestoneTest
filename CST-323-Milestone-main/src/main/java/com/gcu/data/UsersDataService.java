package com.gcu.data;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.entity.ProductEntity;
import com.gcu.data.entity.UserEntity;
import com.gcu.data.repository.UsersRepository;

@Service
public class UsersDataService implements DataAccessInterface<UserEntity>{


	@Autowired
	private UsersRepository usersRepository;
	
	public UsersDataService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }
	
	/**
	 * CRUD: finder to return an entity by Username
	 */
	public UserEntity findByUsername(String username) {
        
		return usersRepository.findByUsername(username);
    }

	@Override
	public List<UserEntity> findProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createProduct(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteProduct(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean findUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addUser(UserEntity t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ProductEntity findProductById(int productId) {
		// TODO Auto-generated method stub
		return null;
	}
}
