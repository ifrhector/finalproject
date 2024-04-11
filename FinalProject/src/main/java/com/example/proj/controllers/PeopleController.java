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

import com.example.proj.models.PeopleModel;
import com.example.proj.services.PeopleService;
import com.example.proj.vo.JsonResponse;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

	@Autowired
	PeopleService peopleService;
	
	/**
	 * 
	 * @return all people registered on system
	 */
	@GetMapping(value = "/")
	public ResponseEntity<JsonResponse> getAll(){
		return peopleService.getAllPeople();
	}
	
	/**
	 * 
	 * @param id
	 * @return an object from people, if exist, otherwise return false
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> getById(@PathVariable Long id){
		return peopleService.getPeopleById(id);
	}
	
	/**
	 * 
	 * @param people
	 * @return success true, if object added correctly, otherwise return false
	 */
	@PostMapping(value = "/")
	public ResponseEntity<JsonResponse> addNew(@RequestBody PeopleModel people){
		return peopleService.addNewPeople(people);
	}
	
	/**
	 * 
	 * @param id
	 * @param people
	 * @return success true, if modified is applied, otherwise return false
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> update(@PathVariable Long id, @RequestBody PeopleModel people){
		return peopleService.updatePeople(id, people);
	}
	
	/**
	 * 
	 * @param id
	 * @return deleted object
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> delete(@PathVariable Long id){
		return peopleService.deletePeople(id);
	}
}
