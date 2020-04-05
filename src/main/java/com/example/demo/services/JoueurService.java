package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Lieu;
import com.example.demo.repositories.JoueurRepository;

@Service
public class JoueurService {

	
	@Autowired
	JoueurRepository joueurRepository;

	public Joueur mettreEnBaseJoueur(Joueur joueur) {
		return joueurRepository.save(joueur);
		// TODO Auto-generated method stub
		
	}

	public List<Joueur> obtenirLalisteDesJoueurs() {
		return joueurRepository.findAll();
	}
	
}
