package Terrain;

public class Usine extends Proprietes {
	
	private String nom;
	private int joueur;
	private int resistance;
	
	public Usine() {
		this.nom = "Usine";
		this.joueur = 0;
		this.resistance = 20;
	}
	
	public Usine(String nom, int joueur) {
		this.nom = nom;
		this.joueur = joueur;
		this.resistance = 20;
	}

	public int getJoueur() {
		return joueur;
	}

	public void setJoueur(int joueur) {
		this.joueur = joueur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
