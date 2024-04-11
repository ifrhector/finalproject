package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj.models.CatCampusLevel;

public interface ICampusLevelRepository extends JpaRepository<CatCampusLevel, Long> {

}
