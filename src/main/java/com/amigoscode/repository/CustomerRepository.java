package com.amigoscode.repository;

import com.amigoscode.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
public interface CustomerRepository
        extends JpaRepository<Customer, Integer> { //This requires as arguments the entity as well as the data type of the primary key

    default int countByName(String name){
        int n = 0;
        return n;
    }
}

