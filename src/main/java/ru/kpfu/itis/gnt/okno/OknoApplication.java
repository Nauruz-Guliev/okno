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
		try {
			User user = new User();
			user.setName("New User " + Math.random());
			User newUser = userRepository.save(user);
			return "created new user with id " + newUser.getId();
		} catch (Exception  ex) {
			return ex.getMessage();
		}
	}

	@GetMapping("/okno")
	public String okno() {
		return htmlPage;
	}

	private String htmlPage = """
			<!DOCTYPE html>
			<html lang="en">
			<head>
			    <meta charset="UTF-8">
			    <meta name="viewport" content="width=device-width, initial-scale=1.0">
			    <title>OKNO is Online</title>
			    <style>
			        body {
			            font-family: sans-serif;
			            margin: 0;
			            padding: 0;
			            background-color: #f2f2f2;
			            display: flex;
			            flex-direction: column;
			            align-items: center;
			            justify-content: center;
			            min-height: 100vh;
			        }
			        h1 {
			            color: #333;
			            text-align: center;
			            margin-bottom: 20px;
			        }
			        .flowers {
			            display: flex;
			            justify-content: center;
			            flex-wrap: wrap;
			            width: 80%;
			        }
			        .flower {
			            width: 150px;
			            margin: 10px;
			        }
			        img {
			            max-width: 100%;
			            height: auto;
			        }
			    </style>
			</head>
			<body>
			    <h1>OKNO IS ONLINE</h1>
			</body>
			</html>
			""";
}
