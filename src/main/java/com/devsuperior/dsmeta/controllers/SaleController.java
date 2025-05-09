package com.devsuperior.dsmeta.controllers;


import com.devsuperior.dsmeta.dto.SaleMinProjectionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.services.SaleService;

import java.util.List;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

	@Autowired
	private SaleService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<SaleMinDTO> findById(@PathVariable Long id) {
		SaleMinDTO dto = service.findById(id);
		return ResponseEntity.ok(dto);
	}

	@GetMapping(value = "/report")
	public ResponseEntity<Page<SaleMinDTO>> getReport(
		@RequestParam(name="minDate", required = false) String minDate, @RequestParam(name= "maxDate",required = false) String maxDate,
		@RequestParam(required = false) String name, Pageable pageable) {

			Page<SaleMinDTO> result = service.searchAll(minDate,maxDate,name, pageable);
			return ResponseEntity.ok(result);

	}

	@GetMapping(value = "/summary")
	public ResponseEntity<List<SaleMinProjectionDTO>> getSummary(@RequestParam(name = "minDate",required = false) String minDate,@RequestParam(name = "maxDate",required = false) String maxDate ){

		List<SaleMinProjectionDTO> result = service.searchSalesSummary(minDate,maxDate);
		return ResponseEntity.ok(result);
	}
}
