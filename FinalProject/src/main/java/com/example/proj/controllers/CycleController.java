package com.example.proj.controllers;

import java.util.ArrayList;
import java.util.Optional;

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

import com.example.proj.models.CycleModel;
import com.example.proj.services.CycleService;
import com.example.proj.vo.JsonResponse;

@RestController
@RequestMapping("/api/cycle")
public class CycleController {
	
	@Autowired
	CycleService cycleService;
	
	
	@GetMapping(value = "/")
	public ArrayList<CycleModel> getAllCycles(){
		return cycleService.getAllCycles();
	}
	
	@GetMapping(path = "/{status}")
	public CycleModel getCycleByStatus(@PathVariable String status) {
		return cycleService.getCycleByStatus(status);
	}
	
	@PostMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE)
	public JsonResponse addNewCycle(@RequestBody CycleModel cycle) {
		return cycleService.addCycle(cycle);
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CycleModel> updateCycle(@RequestBody CycleModel request, @PathVariable Long id) {
		boolean updatedCycle = cycleService.updateById(id, request);

		if (updatedCycle) {
			return new ResponseEntity<>(request, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping(value = "/{id}")
	public JsonResponse deleteCycle(@PathVariable Long id) {
		
		JsonResponse response = new JsonResponse();
		
		Optional<CycleModel> search = cycleService.getById(id);
		
		response.setData(search);
		response.setSuccess(false);
		
		if(search.isEmpty()) {
			response.setMessage("Cycle not exist!");
		}else {
			response.setMessage("Cycles can't deleted, sorry!");
		}
		
		return response;
	}

}
