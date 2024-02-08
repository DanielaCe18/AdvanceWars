package Unite;
import Outils.*;
import ressources.Affichage;

import java.util.*;

public class Convoi extends Unite {
	
	private String unite;
	private int joueur1;
	private double pv;
	private int prix;
	
	public Convoi(String unite , int n) {
		super();
		this.unite = unite;
		this.joueur1 = n;
		this.prix = 5000;
	}

	@Override
	public String getString() {
		return unite;
	}

	public int getJoueur1() {
		return joueur1;
	}

	public double getPv() {
		return pv;
	}

	public void attaque(Unite unite) {
		Affichage.popup("Attaque Impossible: le convoi n'a pas d'armes", null, true, 0);
	}
	
}
