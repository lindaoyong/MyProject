package com.example.configclient.configclient;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ConfigclientApplication {

    @Value("${name}") // git配置文件里的key
    String name;

    @RequestMapping(value = "/hi")
    public String hi(){
        return name;
    }

    public static void main(String[] args) {
        SpringApplication.run(ConfigclientApplication.class, args);
    }

}
