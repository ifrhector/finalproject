package com.example.proj.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.proj.models.PeopleModel;
import com.example.proj.repositories.IPeopleRepository;
import com.example.proj.vo.JsonResponse;

@Service
public class PeopleService {

	@Autowired
	IPeopleRepository peopleRepository;

	public ResponseEntity<JsonResponse> getAllPeople() {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		ArrayList<PeopleModel> people = (ArrayList<PeopleModel>) peopleRepository.findAll();

		if (people.isEmpty()) {
			response.setData(null);
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setData(people);
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> getPeopleById(Long id) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		Optional<PeopleModel> people = peopleRepository.findById(id);

		if (people.isEmpty()) {
			response.setData(null);
			response.setMessage("No data");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		} else {
			response.setData(people);
			response.setMessage("All data are ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		}

		return new ResponseEntity<>(response, hs);
	}

	public ResponseEntity<JsonResponse> addNewPeople(PeopleModel people) {
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;

		if (peopleRepository.save(people) != null) {
			response.setData(people);
			response.setMessage("Added people ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Add people error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}

		return new ResponseEntity<>(response, hs);
	}
	
	public ResponseEntity<JsonResponse> updatePeople(Long id, PeopleModel people){
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;
		
		if(peopleRepository.existsById(id)) {
			response.setData(people);
			response.setMessage("Update people ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Update people error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(response, hs);
	}
	
	public ResponseEntity<JsonResponse> deletePeople(Long id){
		JsonResponse response = new JsonResponse();

		HttpStatus hs = null;
		
		if(peopleRepository.existsById(id)) {
			Optional<PeopleModel> people = peopleRepository.findById(id);
			people.get().setActive(false);
			peopleRepository.save(people.get());
			
			response.setData(people);
			response.setMessage("Delete people ok!");
			response.setSuccess(true);
			hs = HttpStatus.OK;
		} else {
			response.setData(null);
			response.setMessage("Delete people error!");
			response.setSuccess(false);
			hs = HttpStatus.BAD_REQUEST;
		}
		
		return new ResponseEntity<>(response, hs);
	}

}
