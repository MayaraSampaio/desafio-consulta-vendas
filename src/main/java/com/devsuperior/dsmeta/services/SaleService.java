package com.devsuperior.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import com.devsuperior.dsmeta.dto.SaleMinProjectionDTO;
import com.devsuperior.dsmeta.projections.SaleMinProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.devsuperior.dsmeta.dto.SaleMinDTO;
import com.devsuperior.dsmeta.entities.Sale;
import com.devsuperior.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {


	@Autowired
	private SaleRepository repository;
	
	public SaleMinDTO findById(Long id) {
		Optional<Sale> result = repository.findById(id);
		Sale entity = result.get();
		return new SaleMinDTO(entity);
	}

	public Page<SaleMinDTO> searchAll(String minDate, String maxDate, String name, Pageable pageable) {

		LocalDate max =( maxDate== null || maxDate.isEmpty()
		? LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
		: LocalDate.parse(maxDate));

		LocalDate min =( minDate == null || minDate.isEmpty()
		?max.minusYears(1L)
		: LocalDate.parse(minDate));

		String nameSeller = (name == null || name.isEmpty()) ? "" : name;

		Page<Sale> result = repository.searchAll(min,max,nameSeller,pageable);
		return result.map(x -> new SaleMinDTO(x));

	}

	public List<SaleMinProjectionDTO> searchSalesSummary(String minDate, String maxDate){

		LocalDate max = (maxDate== null || maxDate.isEmpty()
				?LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault())
				:LocalDate.parse(maxDate));

		LocalDate min =( minDate == null || minDate.isEmpty()
				?max.minusYears(1L)
				: LocalDate.parse(minDate));

		List<SaleMinProjection> projection = repository.searchSalesSummary(min,max);
		return projection.stream().map(x-> new SaleMinProjectionDTO(x.getName(),x.getAmount())).collect(Collectors.toList());
	}


}
