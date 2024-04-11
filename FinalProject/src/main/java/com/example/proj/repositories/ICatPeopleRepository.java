package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj.models.CatPeopleType;

public interface ICatPeopleRepository extends JpaRepository<CatPeopleType, Long> {

}
