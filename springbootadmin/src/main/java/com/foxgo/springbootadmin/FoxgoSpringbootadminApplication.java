package com.foxgo.springbootadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class FoxgoSpringbootadminApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoxgoSpringbootadminApplication.class, args);
    }
}
