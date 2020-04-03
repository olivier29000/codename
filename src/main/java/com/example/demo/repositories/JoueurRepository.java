package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.objets.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Integer>{

	Optional<Joueur> findByNomJoueur(String nomJoueur);

}
