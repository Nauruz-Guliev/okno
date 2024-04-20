package ru.kpfu.itis.gnt.okno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpfu.itis.gnt.okno.entity.User;
import ru.kpfu.itis.gnt.okno.repository.UserRepository;

import java.util.List;

@SpringBootApplication
@RestController
public class OknoApplication {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(OknoApplication.class, args);
	}

	@GetMapping("/users")
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@GetMapping("/new")
	public String newUser() {
		User user = new User();
		User newUser = userRepository.save(user);
		return "created new user with id " + newUser.getId();
	}

	@GetMapping("/okno")
	public String okno() {
		return "OKNO Привет ";
	}
}
