package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Lieu;
import com.example.demo.objets.Partie;
import com.example.demo.objets.client.PartiePost;
import com.example.demo.repositories.PartieRepository;
import com.example.demo.services.PartieService;

@RestController
public class PartieController {
	
	
	@Autowired
	PartieService partieService;

	@GetMapping("/obtenirMaCarte")
	public String obtenirMaCarte(@RequestParam String nomJoueur,  String nomPartie) {
		return partieService.obtenirMaCarte(nomJoueur,nomPartie);
	}
	
	@PostMapping(path = "/creerUnePartie", consumes = "application/json", produces = "application/json")
	public String creerUnePartie(@RequestBody PartiePost partiePost) {
		Partie partie = new Partie(partiePost.getNomPartie(), partiePost.getNomLieu(),partiePost.getListeDeNomsJoueurs());
		
		partieService.mettreEnBaseUnePartie(partie);
		
		return "ok";
	}
}
