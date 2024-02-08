package main;
import Tableau.*;
import librairies.*;
import ressources.*;

import java.util.*;

public class Navig_trajet extends Etat {
	
	private  List<Coord> trajet;
	
	public Map<String, Coord> getChemin() {
		return chemin;
	}

	public void setChemin(Map<String, Coord> chemin) {
		this.chemin = chemin;
	}
	private Map<String,Coord> chemin;
	
	public Navig_trajet(String nom ) {
		super(nom);
		trajet = new LinkedList<Coord>();
		chemin= new TreeMap<String, Coord>();

	}
	
	public boolean finTrajet() {
		return true;
	}
	
	// On a pensé à enregistrer en mémoire le parcours d'une unite
	public Etat actionDroite(Coord curseur) {
		curseur.x = curseur.x + 1;
		System.out.println("Touche DROITE");
		
		return new Navig_trajet("Navigation Trajet");
	}
	
	public Etat actionGauche(Coord curseur) {
		curseur.x = curseur.x - 1;
		System.out.println("Touche GAUCHE");
		
		return new Navig_trajet("Navigation Trajet");
	}
	
	public Etat actionHaut(Coord curseur) {
		curseur.y = curseur.y + 1;
		System.out.println("Touche HAUT");
		
		return new Navig_trajet("Navigation Trajet");
	}
	
	public Etat actionBas(Coord curseur) {
		curseur.y = curseur.y - 1;
		System.out.println("Touche BAS");
		trajet.add(curseur);
		
		return new Navig_trajet("Navigation Trajet");
	}
	
	public Etat actionT(int joueur) {
		return null;
	}
	
	public Etat actionEntree() {
		return null;
	}
	
	public Etat actionEchap() {
		return null;
	}
	
	public void selectionCheminArtillerie(Jeu jeu, int deplacement) {
		//penser à mettre des touches clavier ici
		// While(deplacement >= 0 || !isToucheEntree)
		// faire ici toutes mes manipulations de touches
		AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
		
	}
	
	public void selectionCheminBazooka(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
		
				
				//if dans le cas ou on reviendrait en arrière
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				//Affichage.dessineImageDansCase(curseur.x, curseur.y, Chemins.getCheminFleche(Chemins.DIRECTION_DROITE,Chemins.DIRECTION_DEBUT));
				jeu.display();
				deplacement --;
				jeu.imgFlecheDroite();
			}
			
		}
	
	}
	public void selectionCheminBombardier(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
	}
	public void selectionCheminConvoi(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
}
	public void selectionCheminDCA(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
}
	public void selectionCheminHelico(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
}
	public void selectionCheminInfanterie(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
		
}
	public void selectionCheminTank(Jeu jeu, int deplacement, Coord curseur) {
		jeu.imgDepartFleche();
		jeu.display();
		while(deplacement >= 0) {
			AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree();
			if (toucheSuivante.isHaut()) { 
				Etat etat =  actionHaut(curseur);
				chemin.put("Haut",curseur);
				jeu.imgFlecheHaut();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isBas()){ 
				Etat etat =  actionBas(curseur);
				chemin.put("Bas",curseur);
				jeu.imgFlecheBas();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isGauche()) {
				Etat etat =  actionGauche(curseur);
				chemin.put("Gauche",curseur);
				jeu.imgFlecheGauche();
				jeu.display();
				deplacement --;
			}
			else if (toucheSuivante.isDroite()) {
				Etat etat =  actionDroite(curseur);
				chemin.put("Droite",curseur);
				jeu.imgFlecheDroite();
				jeu.display();
				deplacement --;
			}
		}
}

}
