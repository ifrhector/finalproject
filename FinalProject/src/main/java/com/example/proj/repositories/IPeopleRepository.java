package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.proj.models.PeopleModel;

public interface IPeopleRepository extends JpaRepository<PeopleModel, Long> {

}
