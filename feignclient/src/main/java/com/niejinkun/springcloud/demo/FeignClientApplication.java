package com.niejinkun.springcloud.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class FeignClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(FeignClientApplication.class, args);
	}
}


@RestController
class InvokeController implements UserServiceClient{
    Logger logger = LoggerFactory.getLogger("feignclient");

    @Autowired
    private  UserServiceClient userServiceClient;

    @RequestMapping("/users2")
    public List<User> getUsers() {
        List<User> users = userServiceClient.getUsers();

        logger.info("users : {}",users.toString() );

        return  users;
    }
}



@FeignClient(value = "user-service",fallback = HystrixUserServiceClient.class)
interface UserServiceClient {
	@RequestMapping(method = RequestMethod.GET, value = "/user/list")
	List<User> getUsers();
}

@Component
 class HystrixUserServiceClient implements UserServiceClient{

    @Override
    public List<User> getUsers() {
        return new ArrayList<>();
    }
}

class User implements Serializable{
	int userId;
	String userName;

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
