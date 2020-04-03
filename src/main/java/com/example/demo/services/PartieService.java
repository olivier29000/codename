package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.objets.Joueur;
import com.example.demo.objets.Lieu;
import com.example.demo.objets.Partie;
import com.example.demo.objets.Role;
import com.example.demo.repositories.JoueurRepository;
import com.example.demo.repositories.LieuRepository;
import com.example.demo.repositories.PartieRepository;

@Service
public class PartieService {

	@Autowired
	PartieRepository partieRepository;
	
	@Autowired
	JoueurRepository joueurRepository;
	
	@Autowired
	LieuRepository lieuRepository;
	
	public Partie mettreEnBaseUnePartie(Partie partie) {
		return partieRepository.save(partie);
	}
	public String obtenirMaCarte(String nomJoueur, String nomPartie) {
		Optional<Joueur> joueurOptionnel = joueurRepository.findByNomJoueur(nomJoueur);
		Joueur joueur = new Joueur();
		if (joueurOptionnel.isPresent()) {
			joueur = joueurOptionnel.get();
		}
		
		if (joueur.getRole().equals(Role.ESPION)) {
			return lieuRepository.findByNomLieu("espion").get().getUrlPhoto();
		}else {
			Optional<Partie> partie = partieRepository.findByNomPartie(nomPartie);
			if (partie.isPresent()) {
				Optional<Lieu> lieuOptionnel = lieuRepository.findByNomLieu(partie.get().getNomLieu());
				
				return lieuOptionnel.get().getUrlPhoto();
			}
			return null;
		}
	}

}
