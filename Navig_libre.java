package main;
import Tableau.*;
import ressources.Affichage;

public class Navig_libre extends Etat {
	
	public Navig_libre(String nom) {
		super(nom);
	}
	

	public Etat actionDroite(Coord curseur) {
		curseur.x = curseur.x + 1;
		System.out.println("Touche DROITE");
		return new Navig_libre("Navigation libre");
	}
	
	public Etat actionGauche(Coord curseur) {
		curseur.x = curseur.x - 1;
		System.out.println("Touche GAUCHE");
		return new Navig_libre("Navigation libre");
	}
	
	public Etat actionHaut(Coord curseur) {
		curseur.y = curseur.y + 1;
		System.out.println("Touche HAUT");
		return new Navig_libre("Navigation libre");
	}
	
	public Etat actionBas(Coord curseur) {
		curseur.y = curseur.y - 1;
		System.out.println("Touche BAS");
		return new Navig_libre("Navigation libre");
	}
	
	public Etat actionT(int joueur) {
		String[] options = {"Oui", "Non"};
		if (Affichage.popup("Finir le tour de XXX?", options, true, 1) == 0) {
			//le choix 0, "Oui", a été selectionné
			// passer au joueur suivant 
			joueur = 3 - joueur;
			System.out.println("FIN DE TOUR");
		}
		return new Navig_libre("Navigation libre");
	}
	
	/**
	 * spécifier qu'il s'agira d'entrer sur une unite
	 */
	public Etat actionEntree() {
		String[] options = {"Attendre"};
		if (Affichage.popup("Options pour l'unite XXX?", options, true, 0) == 0) {
			System.out.println("ATTENTE");
		}
		return new Navig_libre("Navigation libre");
	}
	
	public Etat actionEchap() {
		return null;
	}


	@Override
	public void selectionCheminArtillerie(Jeu jeu, int deplacement) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminBazooka(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminBombardier(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminConvoi(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminDCA(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminHelico(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminInfanterie(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void selectionCheminTank(Jeu jeu, int deplacement, Coord curseur) {
		// TODO Auto-generated method stub
		
	}


}
