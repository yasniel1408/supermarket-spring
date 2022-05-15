package com.supermarket.domain.repository;

import com.supermarket.persistence.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}