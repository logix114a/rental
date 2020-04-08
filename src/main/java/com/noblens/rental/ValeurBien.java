package com.noblens.rental;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


public class ValeurBien {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private Double prix_net;
	private Double frais_agence;
	private String date_achat; 
	@ManyToOne
	private Set<Bien> bien = new HashSet<Bien>();
	@ManyToOne
	private Set<Proprietaire> proprietaire = new HashSet<Proprietaire>();	
}
