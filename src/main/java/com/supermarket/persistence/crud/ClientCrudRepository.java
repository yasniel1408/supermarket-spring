package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Client;
import org.springframework.data.repository.CrudRepository;

public interface ClientCrudRepository extends CrudRepository<Client, Long> {
}