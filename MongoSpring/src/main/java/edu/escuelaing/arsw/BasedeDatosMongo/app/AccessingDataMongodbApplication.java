
package edu.escuelaing.arsw.BasedeDatosMongo.app;

import edu.escuelaing.arsw.BasedeDatosMongo.app.customer.Customer;
import edu.escuelaing.arsw.BasedeDatosMongo.app.customer.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class AccessingDataMongodbApplication implements CommandLineRunner {

    @Autowired
    private CustomerRepository repository;

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(AccessingDataMongodbApplication.class);
        Map<String,Object> properties = new HashMap<>();
        properties.put("spring.data.mongodb.uri", "mongodb+srv://prueba:admin@cluster0.lm1ec.mongodb.net/muFirstDataBase?retryWrites=true&w=majority");
        app.setDefaultProperties(properties);
        app.run(args);
    }

    @Override
    public void run(String... args) throws Exception {

        repository.deleteAll();

        // save a couple of customers
        repository.save(new Customer("Alice", "Smith"));
        repository.save(new Customer("Bob", "Smith"));

        // fetch all customers
        System.out.println("Customers found with findAll():");
        System.out.println("-------------------------------");
        for (Customer customer : repository.findAll()) {
            System.out.println(customer);
        }
        System.out.println();

        // fetch an individual customer
        System.out.println("Customer found with findByFirstName('Alice'):");
        System.out.println("--------------------------------");
        System.out.println(repository.findByFirstName("Alice"));

        System.out.println("Customers found with findByLastName('Smith'):");
        System.out.println("--------------------------------");
        for (Customer customer : repository.findByLastName("Smith")) {
            System.out.println(customer);
        }

    }

}