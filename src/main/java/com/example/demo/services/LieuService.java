package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Lieu;
import com.example.demo.objets.Role;
import com.example.demo.repositories.LieuRepository;
import com.example.demo.utils.Utils;

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
	
	public List<Lieu> obtenirLalisteDesLieuxSansLespion() {
		List<Lieu> listeDesLieuxDisponibles = obtenirLalisteDesLieuxSansLespion();
		int n = 0;
		for (int i = 0; i < listeDesLieuxDisponibles.size(); i++) {
			if (listeDesLieuxDisponibles.get(i).getNomLieu().equals("espion")) {
				n = i;
			}
		}
		List<Lieu> retour = (List<Lieu>) listeDesLieuxDisponibles.remove(n);
		return retour;
		
		
	}

	public String determinerUnLieuAuHasard() {
		List<Lieu> listeDesLieuxDisponibles = obtenirLalisteDesLieuxSansLespion();
		
		Integer randomInt = Utils.getRandomNumberInRange(0, listeDesLieuxDisponibles.size() - 1);
		
		return listeDesLieuxDisponibles.get(randomInt).getNomLieu();
	}
	
	

}
