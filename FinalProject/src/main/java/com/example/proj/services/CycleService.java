package com.example.proj.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.proj.models.CycleModel;
import com.example.proj.repositories.ICycleRepository;
import com.example.proj.vo.JsonResponse;

@Service
public class CycleService {

	@Autowired
	ICycleRepository cycleRepository;

	public ArrayList<CycleModel> getAllCycles() {
		return (ArrayList<CycleModel>) cycleRepository.findAll();
	}

	public CycleModel getCycleByStatus(String status) {
		return cycleRepository.findByStatusCycleModel(status);
	}

	public Optional<CycleModel> getById(long id) {
		return cycleRepository.findById(id);
	}

	public JsonResponse addCycle(CycleModel cycle) {

		JsonResponse response = new JsonResponse();

		response.setData(cycle);
		response.setSuccess(false);
		response.setMessage("Error on save cycle");

		if (cycleRepository.save(cycle) != null) {
			response.setSuccess(true);
			response.setMessage("Cycle saved correctly!");
		}
		
		return response;
	}

	public boolean updateById(Long id, CycleModel request) {

		boolean response = false;

		try {

			if (cycleRepository.existsById(id)) {

				request.setId(id);
				cycleRepository.save(request);

				response = true;
			} else {
				response = false;
			}

		} catch (Exception e) {
			response = false;
		}

		return response;
	}
}
