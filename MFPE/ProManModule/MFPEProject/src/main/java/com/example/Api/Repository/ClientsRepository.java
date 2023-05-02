package com.example.Api.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Api.Model.Clients;

@Repository
public interface ClientsRepository extends JpaRepository<Clients,Integer> {

}
