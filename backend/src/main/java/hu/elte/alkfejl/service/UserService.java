package hu.elte.alkfejl.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hu.elte.alkfejl.entity.User;
import hu.elte.alkfejl.repository.UserRepository;

 
@Service
@Transactional
public class UserService{
	
	@Autowired
	private UserRepository userRepository;

	public User findUserById(long id) {
		return userRepository.findOne(id);
	}
	
	public User saveUser(User newUser) {
		return userRepository.save(newUser);
	}
	
	public Iterable<User> findAll() {
		return userRepository.findAll();
	}
	public User findByEmailAndPassword(String email, String password) {
		return userRepository.findByEmailAndPassword(email, password);
	}
}
