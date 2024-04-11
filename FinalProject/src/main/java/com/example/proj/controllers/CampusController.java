package com.example.proj.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proj.models.CampusModel;
import com.example.proj.services.CampusService;
import com.example.proj.vo.JsonResponse;

@RestController
@RequestMapping("/api/campus")
public class CampusController {
	
	@Autowired
	CampusService campusService;

	/**
	 * 
	 * @return List from all registered campus
	 */
	@GetMapping(value = "/")
	public ResponseEntity<JsonResponse> getAll() {
		return campusService.getAllCampus();
	}

	/**
	 * 
	 * @param id
	 * @return searched object (if exist)
	 */
	@GetMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> getById(@PathVariable Long id) {
		return campusService.getCampusById(id);
	}

	/**
	 * 
	 * @param campus
	 * @return true if campus is success created and the object created, otherwise return false 
	 */
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JsonResponse> addNew(@RequestBody CampusModel campus) {
		return campusService.addNewCampus(campus);
	}

	/**
	 * 
	 * @param id
	 * @param campus
	 * @return the object updated if success, otherwise return false
	 */
	@PutMapping(value = "/{id}")
	public ResponseEntity<JsonResponse> update(@PathVariable Long id, @RequestBody CampusModel campus) {
		return campusService.updateCampus(id, campus);
	}
	
	/**
	 * 
	 * @param id
	 * @return a message, because the campus can´t delete
	 */
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id){
		return new ResponseEntity<String>("Campus can't deleted", HttpStatus.CONFLICT);
	}
}
