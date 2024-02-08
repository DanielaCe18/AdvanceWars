package Unite;
import Outils.*;
import ressources.*;
import java.util.*;

public class Bazooka extends Unite {
	
	private String unite;
	private int joueur1;
	private Canon arme;
	private int prix;
	
	public Bazooka(String unite, int n) {
		super();
		this.unite = unite;
		this.joueur1 = n;
		this.arme = new Canon();
		this.prix = 3500;
	}

	@Override
	public String getString() {
		return unite;
	}

	public int getJoueur1() {
		return joueur1;
	}


	public void attaque(Unite unite) {
		if(unite.getString().equals("Bazooka")) {
			int point = (int)super.getPv() + 1;
			double degat = arme.getArmes().get("Bazooka") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bazooka") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		else if(unite.getString().equals("Convoit")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("Convoi") * point;
			unite.setPv(unite.getPv() - degat);
		}
		else if(unite.getString().equals("DCA")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("DCA") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bazooka") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		else if(unite.getString().equals("Helico")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("Helicoptere") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bazooka") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		
		else if(unite.getString().equals("Infanterie")) {
			int point = (int)super.getPv() + 1;
			double degat = arme.getArmes().get("Infanterie") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bazooka") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		
		else if(unite.getString().equals("Tank")) {
			int point = (int) super.getPv() + 1;
			double degat = arme.getArmes().get("Tank") * point;
			unite.setPv(unite.getPv() - degat);
			// une riposte du défenseur
			if(unite.getPv() > 0.0) {
				int point_rip = (int) unite.getPv() + 1;
				double riposte = unite.getArmes().get("Bazooka") * point_rip;
				super.setPv(super.getPv() - riposte);
			}
		}
		
		else if(unite.getString().equals("Bombardier")) {
			
			Affichage.popup("Attaque Impossible du Bazooka", null, true, 0);
		}
	}
	
}
