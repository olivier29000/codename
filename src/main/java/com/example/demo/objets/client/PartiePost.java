package com.example.demo.objets.client;

import java.util.List;

import com.example.demo.objets.Joueur;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PartiePost {

	
	private String nomPartie;
	private String nomLieu;
	private List<String> listeDeNomsJoueurs;
	
}
