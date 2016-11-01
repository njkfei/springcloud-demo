package com.niejinkun.springcloud.demo;

import com.niejinkun.springcloud.demo.mapper.ProductBasicMapper;
import com.niejinkun.springcloud.demo.model.ProductBasic;
import com.niejinkun.springcloud.demo.model.ProductBasicExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@SpringBootApplication
@EnableDiscoveryClient
@EnableAutoConfiguration
@Configuration
public class ApplicationserviceApplication {
		public static void main(String[] args) {
		SpringApplication.run(ApplicationserviceApplication.class, args);
	}
}

@RestController
@RequestMapping("/application")
class ProductController {
    @Autowired
    private ProductBasicMapper productBasicMapper;

    @RequestMapping("/infos")
    Collection<ProductBasic> infos() {
        ProductBasicExample example = new ProductBasicExample();
        example.createCriteria().andIdGreaterThan(0);
        return productBasicMapper.selectByExample(example);
    }

    @RequestMapping(method = RequestMethod.POST)
    int insert(@RequestBody ProductBasic productBasic) {
        return productBasicMapper.insertSelective(productBasic);
    }
}
