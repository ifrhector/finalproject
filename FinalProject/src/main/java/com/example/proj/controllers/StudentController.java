package com.example.proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proj.models.StudentModel;
import com.example.proj.services.StudentService;
import com.example.proj.vo.JsonResponse;

@RestController
@RequestMapping("/api/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	/**
	 * 
	 * @return all student registered on system
	 */
	@GetMapping(value = "/")
	public ResponseEntity<JsonResponse> getAll() {
		return studentService.getAll();
	}

	/**
	 * 
	 * @param id
	 * @return an object from student, if exist, otherwise return false
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> getById(@PathVariable Long id) {
		return studentService.getById(id);
	}
	
	/**
	 * This service requires two parameters, idCampus and status, for identify students on some campus
	 * @param idCampus
	 * @param status
	 * @return success and data if campus and status is correct, campus = id and status 0 for inactive or 1 for active
	 */
	@GetMapping(value = "/{idCampus}/{status}")
	public ResponseEntity<JsonResponse> getAllActiveByCampus(@PathVariable Long idCampus, @PathVariable int status) {
		return studentService.getAllActiveByCampus(idCampus, status);
	}

	/**
	 * 
	 * @param student
	 * @return success true, if object added correctly, otherwise return false
	 */
	@PostMapping(value = "/")
	public ResponseEntity<JsonResponse> addNew(@RequestBody StudentModel student) {
		return studentService.addNew(student);
	}

	/**
	 * 
	 * @param id
	 * @param student
	 * @return success true, if modified is applied, otherwise return false
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> update(@PathVariable Long id, @RequestBody StudentModel student) {
		return studentService.update(id, student);
	}

	/**
	 * 
	 * @param id
	 * @return the object to delete, but record persist, only change the status "ACTIVE = 0" this for all relationship with other tables
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> delete(@PathVariable Long id) {
		return studentService.delete(id);
	}
}
