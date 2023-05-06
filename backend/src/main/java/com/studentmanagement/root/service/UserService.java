package com.studentmanagement.root.service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.root.entity.User;
import com.studentmanagement.root.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public List<User> getAllUsers(){
		return userRepo.findAll();
	}
	
	public Optional<User>  getUser( Integer userID ) {
		return userRepo.findById(userID);
	}

	public User createUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(Integer id, User user) {
	    Optional<User> existingUser = userRepo.findById(id);
	    if(existingUser.isPresent()) {
	        User updatedUser = existingUser.get();
	        updatedUser.setFirstName(user.getFirstName());
	        updatedUser.setLastName(user.getLastName());
	        updatedUser.setEmail(user.getEmail());
	        updatedUser.setPhone(user.getPhone());
	        updatedUser.setPassword(user.getPassword());
	        updatedUser.setIsLandlord(user.getIsLandlord());
	        updatedUser.setRoom(user.getRoom());
	        return userRepo.save(updatedUser);
	    }
	    return null;
	}

	 
	// Delete user
    public String deleteUser(Integer id) {
	    Optional<User> existingUser = userRepo.findById(id);
	    if(existingUser.isPresent()) {
	    	User deleteThisUser = existingUser.get();
	    	userRepo.delete(deleteThisUser);
	    	return "deleted successfully";
	    }
	    return "delete not successfull";
    }
	 
}
