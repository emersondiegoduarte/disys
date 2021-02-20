package com.disys.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.disys.entities.Coordenadas;

@Repository
public interface CoordenadasRepository extends JpaRepository<Coordenadas, Long>{

}
