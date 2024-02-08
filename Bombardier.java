package Unite;
import Outils.*;
import ressources.Affichage;

import java.util.*;

public class Bombardier extends Unite {
	private String unite;
	private int joueur1;
	private Bombes arme;
	private int prix;
	
	public Bombardier(String unite, int n) {
		super();
		this.unite = unite;
		this.joueur1 = n;
		this.arme = new Bombes();
		this.prix = 20000;
	}

	@Override
	public String getString() {
		return unite;
	}

	public int getJoueur1() {
		return joueur1;
	}

	public Bombes getArme() {
		return arme;
	}
	public void attaque(Unite unite) {
		if(unite.getString().equals("Bazooka")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("Bazooka") * point;
			unite.setPv(unite.getPv() - degat);
			// riposte impossible contre un bombardier
		}
		else if(unite.getString().equals("Convoit")) {
			int point = (int)super.getPv() + 1;
			double degat = arme.getArmes().get("Convoi") * point;
			unite.setPv(unite.getPv() - degat);
			// riposte impossible contre un bombardier, n' a pas d'armes
		}
		else if(unite.getString().equals("DCA")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("DCA") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bombardier") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		else if(unite.getString().equals("Helico")) {
			Affichage.popup("Attaque Impossible du Bombardier", null, true, 0);
		}
		
		else if(unite.getString().equals("Infanterie")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("Infanterie") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte impossible du défenseur
		}
		
		else if(unite.getString().equals("Tank")) {
			int point = (int) super.getPv()+ 1;
			double degat = arme.getArmes().get("Tank") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte impossible du défenseur
		}
		
		else if(unite.getString().equals("Bombardier")) {
			
			Affichage.popup("Attaque Impossible du Bombardier", null, true, 0);
		}
	}
	
	
	
}
