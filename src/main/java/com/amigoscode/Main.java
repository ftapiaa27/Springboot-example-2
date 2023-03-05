package com.amigoscode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

//    private CustomerRepository customerRepository;
//    // Instance of the interface to connect to db
//    public Main(CustomerRepository customerRepository) {
//        this.customerRepository = customerRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

}
