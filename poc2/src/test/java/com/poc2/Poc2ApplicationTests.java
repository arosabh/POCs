package com.poc2;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.verify;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@ExtendWith(MockitoExtension.class)
class Poc2ApplicationTests {

	@Mock
	private UserRepository userRepo;
	
	private UserService userService;
	
	@BeforeEach
	void setup() {
		this.userService = new UserService(this.userRepo);
	}
	
	@Test
	void getAllUsers() {
		userService.getAllUsers();
		verify(userRepo).findAll();
	}

}
