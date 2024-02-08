package Terrain;
import Unite.*;

public class Proprietes extends Terrain {
	 
	private String nom;
	private int joueur;
	private int resistance;
	
	public Proprietes() {
		this.nom = "Propriete";
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
	
	/**
	 * @param
	 * Unite est l'unite qui opère l'action capture
	 * Propriete est la propriete cible de la capture
	 * 
	 * @return true si notre propriete est capturée
	 */
	public boolean capture(Unite unite, Proprietes prop) {
		if(!unite.estDetruite()) {
			int point = (int) unite.getPv() + 1;
			this.resistance = this.resistance - point;
			if(resistance == 0) {
				prop.setJoueur(unite.getJoueur1());
				this.resistance = 20;
				return true;
			}
			else return false;
		}
		
		else {
			this.resistance = 20;
			return false;
		}
	}
	

}
