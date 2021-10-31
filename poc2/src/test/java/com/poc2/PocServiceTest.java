package com.poc2;

import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PocServiceTest {

	@Autowired
	private UserService userService;

	@MockBean
	private UserRepository userRepository;

	@Test
	public void testGetAllUsers() {
		User user = new User();
		user.setId(1);
		user.setName("Am");
		user.setJoingDate(new Date(20));
		user.setDob(new Date(10));
		user.setLocation("Mumbai");
		
		when(userRepository.findAll()).thenReturn(Stream.of(user).collect(Collectors.toList()));
		
		assertEquals(1, userService.getAllUsers().size());
		
	}

}
