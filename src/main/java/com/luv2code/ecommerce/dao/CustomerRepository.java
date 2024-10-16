package com.luv2code.ecommerce.dao;

import com.luv2code.ecommerce.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

// CUSTOMER JE ENTITY JER CUSTOMER IMA KOLEKCIJU ORDER-A, KADA SE OSTVARI KUPOVINA, UZIMAMO CUSTOMER-A, SKLAPAM GA I CUVAM GA PREKO OVOG REPOSITORY-A
public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
