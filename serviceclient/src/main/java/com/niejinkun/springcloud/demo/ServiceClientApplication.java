package com.niejinkun.springcloud.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@Configuration
@EnableCircuitBreaker
@EnableAutoConfiguration
public class ServiceClientApplication {
	@Bean
	@LoadBalanced
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(ServiceClientApplication.class, args);
	}
}

@RestController
class InvokeController{
	private final RestTemplate restTemplate;

//	private final UserServiceClient userServiceClient;

	@Autowired
	public InvokeController(@LoadBalanced  RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
//		this.userServiceClient = userServiceClient;
	}

	public List<User> fallback(){
		return new ArrayList<>();
	}

	public int addfallback(){return 0;}

	@RequestMapping(value = "/user",method = RequestMethod.POST)
	@HystrixCommand(fallbackMethod = "addfallback")
	int addUser(@RequestBody User user){
		restTemplate.postForObject("http://user-service/user/add",user,User.class);
		return 1;
	}

	@RequestMapping("/users")
	@HystrixCommand(fallbackMethod = "fallback")
	List<User> getUsers(){
		return restTemplate.getForObject("http://user-service/user/list",List.class);
	}

/*	@RequestMapping("/users2")
	@HystrixCommand(fallbackMethod = "fallback")
	List<User> getUsers2(){
		return userServiceClient.getUsers();
	}*/
}

/*@FeignClient("user-service")
interface UserServiceClient {
	@RequestMapping(method = RequestMethod.GET, value = "/user/list")
	List<User> getUsers();
}*/

class User {
	int userId;
	String userName;
}
