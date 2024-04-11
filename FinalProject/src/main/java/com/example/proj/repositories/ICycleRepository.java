package com.example.proj.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.proj.models.CycleModel;
import com.example.proj.utils.MyQueryRewriter;

public interface ICycleRepository extends JpaRepository<CycleModel, Long> {

	@Query(value = "SELECT c.* FROM cycles c WHERE c.status = ?1", nativeQuery = true,
			queryRewriter = MyQueryRewriter.class)
	CycleModel findByStatusCycleModel(String status);
}
