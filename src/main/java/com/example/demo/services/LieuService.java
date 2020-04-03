package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.objets.Lieu;
import com.example.demo.repositories.LieuRepository;

@Service
public class LieuService {
	
	@Autowired
	LieuRepository lieuRepository;

	public Lieu mettreEnBaseLieu(Lieu lieu) {
		return lieuRepository.save(lieu);
		// TODO Auto-generated method stub
		
	}

	public List<Lieu> obtenirLalisteDesLieux() {
		return lieuRepository.findAll();
	}
	
	

}
