package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Role;
import com.example.demo.repositories.JoueurRepository;

public class TestMain {
	
	@Autowired
	static JoueurRepository joueurRepository;

	public static void main(String[] args) {
		
		Joueur joueur = new Joueur("toto", Role.ESPION);
		joueurRepository.save(joueur);
	}

}
