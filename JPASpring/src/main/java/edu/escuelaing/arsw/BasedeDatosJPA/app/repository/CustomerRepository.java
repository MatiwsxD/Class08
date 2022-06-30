package edu.escuelaing.arsw.BasedeDatosJPA.app.repository;

import java.util.List;
import edu.escuelaing.arsw.BasedeDatosJPA.app.customer.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

    List<Customer> findByLastName(String lastName);

    Customer findById(long id);
}
