package com.disys.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.disys.entities.LinhaOnibus;

public interface LinhaOnibusRepository extends JpaRepository<LinhaOnibus, Long>{
	
	public List<LinhaOnibus> findByNome(String nome);
	
	public Page<LinhaOnibus> findByNomeContaining(String nome, Pageable paginacao);

}
