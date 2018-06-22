package com.example.demo;

import com.example.demo.com.example.demo.dao.UsrInfoDao;
import com.google.common.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class DemoApplication {
@Autowired
private UsrInfoDao gavaDao;
	@RequestMapping("/test")
	public @ResponseBody String hello(){
		return "Ok"+gavaDao.getUSer(5);

	}
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
