package com.example.proj.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.proj.models.StudentModel;
import com.example.proj.utils.MyQueryRewriter;

public interface iStudentRepository extends JpaRepository<StudentModel, Long> {

	@Query(value = "SELECT s.* FROM students s WHERE s.active = ?1 AND s.campus_id = ?2", nativeQuery = true,
			queryRewriter = MyQueryRewriter.class)
	ArrayList<StudentModel> findAllActiveStudentByCampus(int status, long idCampus);
}
