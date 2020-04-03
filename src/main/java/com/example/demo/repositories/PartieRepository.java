package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.objets.Lieu;
import com.example.demo.objets.Partie;

@Repository
public interface PartieRepository extends JpaRepository<Partie, Integer>{

	

	Optional<Partie> findByNomPartie(String nomPartie);

}
