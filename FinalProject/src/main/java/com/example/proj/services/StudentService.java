package com.example.proj.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proj.models.StudentModel;
import com.example.proj.repositories.iStudentRepository;
import com.example.proj.vo.JsonResponse;

@Service
public class StudentService {

	@Autowired
	iStudentRepository studentRepository;

	public ResponseEntity<JsonResponse> getAll() {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		ArrayList<StudentModel> student = (ArrayList<StudentModel>) studentRepository.findAll();

		if (student.isEmpty()) {
			response.setData(null);
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setData(student);
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}
	
	public ResponseEntity<JsonResponse> getAllActiveByCampus(long idCampus, int status) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		ArrayList<StudentModel> student = (ArrayList<StudentModel>) studentRepository.findAllActiveStudentByCampus(status, idCampus);

		if (student.isEmpty()) {
			response.setData(null);
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setData(student);
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> getById(Long id) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		Optional<StudentModel> student = studentRepository.findById(id);

		if (student.isEmpty()) {
			response.setData(null);
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setData(student);
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> addNew(StudentModel student) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		if (studentRepository.save(student) != null) {
			response.setData(student);
			response.setMessage("Added student ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Add student error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, hs);
	}
	
	public ResponseEntity<JsonResponse> update(Long id, StudentModel student){
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;
		
		if(studentRepository.existsById(id)) {
			response.setData(student);
			response.setMessage("Update student ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Update student error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(response, hs);
	}
	
	public ResponseEntity<JsonResponse> delete(Long id){
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;
		
		if(studentRepository.existsById(id)) {
			Optional<StudentModel> student = studentRepository.findById(id);
			student.get().setActive(false);
			studentRepository.save(student.get());
			
			response.setData(student);
			response.setMessage("Delete student ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Delete student error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(response, hs);
	}

}
