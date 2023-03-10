package com.amigoscode.controller;

import com.amigoscode.exception.CannotCreateCustomerException;
import com.amigoscode.model.Customer;
import com.amigoscode.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController //This allows methods inside the class to be used as rest endpoints
@RequestMapping("api/v1/customers")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @GetMapping("{customerId}")
    public Customer getEmployeeByID(@PathVariable("customerId") Integer id) {
        return customerRepository.findById(id).get();
    }
    record NewCustomerRequest(String name, String email, Integer age) {}
    @PostMapping
    public ResponseEntity<String> addCustomer(@RequestBody NewCustomerRequest request) throws CannotCreateCustomerException{
        if (request == null){
            throw new CannotCreateCustomerException("No customer info provided.");
        }
        int matches = customerRepository.countByName(request.name);
        if (matches > 0) {
            throw new CannotCreateCustomerException("Customer already exists");
        }
        Customer customer = new Customer();
        customer.setName(request.name);
        customer.setAge(request.age);
        customer.setEmail(request.email);
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer added", HttpStatus.OK);
    }

    @DeleteMapping("{customerId}")
    public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
        return new ResponseEntity<>("Customer deleted", HttpStatus.OK);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<String> updateCustomer(@PathVariable("customerId") Integer id, @RequestBody Customer customerDetails){
        Customer customer = customerRepository.findById(id).get();
        customer.setAge(customerDetails.getAge());
        customer.setEmail(customerDetails.getEmail());
        customer.setName(customerDetails.getName());
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer updated", HttpStatus.OK);
    }

    @PatchMapping("{customerId}/{age}")
    public ResponseEntity<String> updateCustomerAge(@PathVariable("customerId") Integer id, @PathVariable("age")  Integer age){
        Customer customer = customerRepository.findById(id).get();
        customer.setAge(age);
        customerRepository.save(customer);
        return new ResponseEntity<>("Customer updated", HttpStatus.OK);
    }

    // In order to expose this method as a rest endpoint for the users to
    // use as a GET request the following tag is used
    @GetMapping("/greet")
    public GreetResponse greet(){
        return new GreetResponse(
                "Hello",
                List.of("Python", "Java", "Cpp"),
                new Person("Fausto", 22, 500));
    }
    record Person(
            String name,
            int age,
            double cash){}
    record GreetResponse(
            String greet,
            List<String> favProgrammingLangs,
            Person person
    ){}

}
