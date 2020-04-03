package com.example.demo.objets;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.utils.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomPartie;
	private String nomLieu;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Joueur> listeDeJoueurs;
	
	public Partie(String nomPartie, String nomLieu, List<String> listeDeNomJoueurs) {
		
		List<Joueur> listeDesJoueurs = new ArrayList<Joueur>();
		Integer randomInt = Utils.getRandomNumberInRange(0, listeDeNomJoueurs.size() - 1);
		Integer compteur=0;
		
		for (String nomJoueur : listeDeNomJoueurs) {
			Role role;
			if (compteur == randomInt) {
				role = Role.ESPION;
			}else {
				role = Role.JOUEUR;
			}
			compteur++;
			listeDesJoueurs.add(new Joueur(nomJoueur,role));
		}
		this.nomLieu = nomLieu;
		this.nomPartie = nomPartie;
		this.listeDeJoueurs = listeDesJoueurs;
	}
	

}
