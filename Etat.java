package main;
import Tableau.*;

public abstract class Etat {

	public String nom;
	
	public Etat(String nom) {
		this.nom = nom;
	}
	
	
	
	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}



	public abstract Etat actionDroite(Coord curseur);
	
	public abstract Etat actionGauche(Coord curseur);
	
	public abstract Etat actionHaut(Coord curseur);
	
	public abstract Etat actionBas(Coord curseur);
	
	public abstract Etat actionT(int joueur);
	
	public abstract Etat actionEntree();
	
	public abstract Etat actionEchap();
	
	public abstract void selectionCheminArtillerie(Jeu jeu,int deplacement); 
	
	public abstract void selectionCheminBazooka(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminBombardier(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminConvoi(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminDCA(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminHelico(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminInfanterie(Jeu jeu, int deplacement, Coord curseur);
	
	public abstract void selectionCheminTank(Jeu jeu, int deplacement, Coord curseur);
	
}

