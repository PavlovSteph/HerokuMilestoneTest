package com.gcu.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gcu.data.RegisterDataService;
import com.gcu.data.entity.UserEntity;
import com.gcu.model.RegisterModel;

@Service
public class RegisterService {
	
	//Declaring and Initializing
	@Autowired
    private RegisterDataService registerDataService;
	
	/**
	 * Registers a new user based on the provided registration information.
     * 
     * @param registrationModel The registration model containing user information.
     * @return If the registration is successful, if any required field is null or blank.
	 */
	public boolean registerUser(UserEntity userEntity) {
	    // Check for null values or blank text fields
	    if (userEntity.getFirstName().isBlank() || userEntity.getLastName().isBlank() ||
	    		userEntity.getEmail().isBlank() || userEntity.getPhoneNumber().isBlank() ||
	    		userEntity.getUsername().isBlank() || userEntity.getPassword().isBlank()) {
	        // Return false if any field is null or blank
	        return false;
	    }
	    
	    return registerDataService.createUser(userEntity);
	}
}
