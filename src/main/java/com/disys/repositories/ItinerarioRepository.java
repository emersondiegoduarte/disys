package com.disys.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.disys.entities.Itinerarios;

public interface ItinerarioRepository extends JpaRepository<Itinerarios, Long>{
	
	
	public Page<Itinerarios> findByIdlinha(Long idlinha, Pageable paginacao);
	
	public List<Itinerarios> findByNome(String nome);

	public Page<Itinerarios> findByNomeContainingIgnoreCase(String nome, Pageable paginacao);

}
