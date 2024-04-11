package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj.models.CampusModel;

public interface ICampusRepository extends JpaRepository<CampusModel, Long> {

}
