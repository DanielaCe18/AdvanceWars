package Unite;
import Outils.*;
import ressources.Affichage;

public class Artillerie extends Unite {
	
	private String unite;
	private int joueur1;
	private double pv;
	private int prix;
	
	public Artillerie(String unite, int n) {
		super();
		this.unite = unite;
		this.joueur1 = n;
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
		Affichage.popup("Attaque Impossible: l'artillerie n'a pas d'armes", null, true, 0);
	}
	

}
