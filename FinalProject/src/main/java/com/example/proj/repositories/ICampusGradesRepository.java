package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj.models.CatCampusGrades;

public interface ICampusGradesRepository extends JpaRepository<CatCampusGrades, Long> {

}
