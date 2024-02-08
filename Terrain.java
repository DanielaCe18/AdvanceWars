package Terrain;

public class Terrain {
	
	private String nom;
	private int joueur;
	
	public Terrain() {
		this.nom = "Terrain";
		this.joueur = 0;
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
