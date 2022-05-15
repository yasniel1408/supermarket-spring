package com.supermarket.persistence.crud;

import com.supermarket.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IClientCrudRepository extends JpaRepository<Client, Long> {
}