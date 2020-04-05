package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.objets.Lieu;
import com.example.demo.services.LieuService;


@RestController
public class LieuController {
	
	@Autowired
	LieuService lieuService;
	
	@PostMapping(path = "/creerUnLieu", consumes = "application/json", produces = "application/json")
	public Lieu postUnLieu(@RequestBody Lieu lieu) {
		
		return lieuService.mettreEnBaseLieu(lieu);
	}
	
	@GetMapping("/obtenirLalisteDesLieux")
	public List<Lieu> obtenirLalisteDesLieux() {
		
		return lieuService.obtenirLalisteDesLieux();
	}

}
