package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.objets.Lieu;

@Repository
public interface LieuRepository extends JpaRepository<Lieu, Integer>{
	
	Optional<Lieu> findByNomLieu (String nomLieu);

}
