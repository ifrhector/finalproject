package com.example.proj.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proj.models.CampusModel;
import com.example.proj.repositories.ICampusRepository;
import com.example.proj.vo.JsonResponse;

@Service
public class CampusService {

	@Autowired
	ICampusRepository campusRepository;

	public ResponseEntity<JsonResponse> getAllCampus() {

		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		ArrayList<CampusModel> campus = (ArrayList<CampusModel>) campusRepository.findAll();

		response.setData(campus);

		if (campus.isEmpty()) {
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> getCampusById(Long id) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		Optional<CampusModel> campus = campusRepository.findById(id);
		
		response.setData(campus);

		if (campus.isEmpty()) {
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> addNewCampus(CampusModel campus) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		if (campusRepository.save(campus) != null) {
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			response.setData(campus);
			hs = HttpStatus.OK;
		} else {
			response.setMessage("Error to save data!");
			response.setSuccess(false);
			response.setData(null);
			hs = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, hs);

	}
	
	public ResponseEntity<JsonResponse> updateCampus(Long id, CampusModel campus){
		
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		if(campusRepository.existsById(id)) {
			campus.setId(id);
			campusRepository.save(campus);
			response.setMessage("Update ok!");
			response.setSuccess(true);
			response.setData(campus);
			hs = HttpStatus.OK;
		}else {
			response.setMessage("Update error!");
			response.setSuccess(false);
			response.setData(null);
			hs = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(response, hs);
	}

}
