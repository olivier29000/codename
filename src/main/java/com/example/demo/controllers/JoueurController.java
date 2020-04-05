package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Lieu;
import com.example.demo.services.JoueurService;
import com.example.demo.services.LieuService;

@RestController
public class JoueurController {
	
	@Autowired
	JoueurService joueurService;
	
	@PostMapping(path = "/creerUnJoueur", consumes = "application/json", produces = "application/json")
	public Joueur postUnJoueur(@RequestBody Joueur joueur) {
		
		return joueurService.mettreEnBaseJoueur(joueur);
	}
	
	@GetMapping("/obtenirLalisteDesJoueurs")
	public List<Joueur> obtenirLalisteDesJoueurs() {
		
		return joueurService.obtenirLalisteDesJoueurs();
	}


}
