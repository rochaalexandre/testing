package com.example.demo.customer;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface CustomerRepository extends
        PagingAndSortingRepository<Customer, Long> {
}
