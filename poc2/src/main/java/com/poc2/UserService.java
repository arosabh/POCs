package com.poc2;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public UserService(UserRepository userRepo) {
		userRepository = userRepo;
	}

	User saveUser(User user) {
		return userRepository.save(user);
	}
	
	List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	String updateUserById(User user, int id) {
		Optional<User> u = userRepository.findById(id);
		if (u.isPresent()) {
			User userTemp = u.get();

			if (user.getName() != null)
				userTemp.setName(user.getName());

			if (user.getDob() != null)
				userTemp.setDob(user.getDob());

			if (user.getJoingDate() != null)
				userTemp.setJoingDate(user.getJoingDate());

			if (user.getLocation() != null)
				userTemp.setLocation(user.getLocation());

			userRepository.save(userTemp);
			return "Update Successful";
		}
		return "Updation unsuccessful";
	}
	
	List<User> findUsersByName(@RequestParam("q") String q) {
		return userRepository.findByName(q);
	}
	
	List<User> findSortedList() {
		return userRepository.sortUsers();
	}
	
	void deleteUserById(int id) {
		userRepository.deleteById(id);
	}
	
	void softDelete(int id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			userRepository.softDel(id);
		}
	}
	
}
