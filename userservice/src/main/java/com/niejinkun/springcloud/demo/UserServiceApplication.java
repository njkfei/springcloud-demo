package com.niejinkun.springcloud.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableAutoConfiguration
public class UserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserServiceApplication.class, args);
	}
}


@RestController
@RequestMapping("/user")
class UserController{
	List<User> users = new ArrayList<>();
	{
		users.add(new User(1,"hekk"));
		users.add(new User(2,"world"));
	}

	@RequestMapping("/list")
	List<User> getusers(){

		return users;
	}

	@RequestMapping(value = "/add",method = RequestMethod.POST)
	int addUser(@RequestBody User user){
		users.add(user);

		return users.size();
	}

}


class User implements Serializable{
	int userId;
	String userName;

	public User() {
	}

	public User(int userId, String userName) {
		this.userId = userId;
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "User{" +
				"userId=" + userId +
				", userName='" + userName + '\'' +
				'}';
	}
}