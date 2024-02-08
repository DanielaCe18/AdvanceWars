/** package principal */
package main;
import librairies.AssociationTouches;
import librairies.StdDraw;
import ressources.Config;
import ressources.ParseurCartes;
import ressources.Affichage;
import ressources.Chemins;
import Tableau.*;
import Terrain.*;
import Unite.*;
import Outils.*;

public class Jeu {
	private int indexJoueurActif; //l'indice du joueur actif:  1 = rouge, 2 = bleu
	// l'indice 0 est reserve au neutre, qui ne joue pas mais peut posseder des proprietes
	
	private Coord curseur = new Coord();// ça servira à se déplacer sur la grille
	private Case[][] carteObject; // notre Grille de jeu composé d'objets
	private Etat etat = new Navig_libre("Navigation libre");
	
	
	public Jeu(String fileName) throws Exception {
		//appel au parseur, qui renvoie un tableau de String 
		String[][] carteString = ParseurCartes.parseCarte(fileName);
		for (int i = 0; i<carteString.length; i++) {
			for (int j=0; j < carteString[0].length; j++){
				System.out.print(carteString[i][j]);
				if (j != carteString[0].length) {
						System.out.print(" | ");
					}
				else {
					System.out.println();
				}
			}
			System.out.println();
		}
		
		Config.setDimension(carteString[0].length, carteString.length);
		// initialise la configuration avec la longueur de la carte
		
		// a vous de manipuler ce tableau de String pour le transformer en une carte avec vos propres classes, a l'aide de la methode split de la classe String
		this.carteObject = new Case [carteString.length][carteString[0].length];
		for(int i =0; i<carteString.length; i++) {
			for(int j=0; j < carteString[0].length; j++) {
				carteObject[i][j] = new Case();
				carteObject[i][j].setPosition(Coord.conversion(Config.longueurCarteYCases, i, j));
				if(carteString[i][j].contains(";")) {// on teste si on a 2 chaines de caracteres
					String [] s = carteString[i][j].split(";");// tableau contenant les éléments d'une case
					/*
					 * chaque case doit contenir un terrain et une unite correspondant au tableau de string s
					 * ne pas oublier de mettre les coordonnées (avec une conversion particulière)
					 */
					if(s[0].equals("Plaine")) carteObject[i][j].setTerrain(new Plaine());
					else if( s[0].equals("Eau")) carteObject[i][j].setTerrain(new Eau());
					else if(s[0].equals("Foret")) carteObject[i][j].setTerrain(new Foret());
					else if(s[0].equals("Montagne")) carteObject[i][j].setTerrain(new Montagne());
					else if(s[0].equals("QG")) carteObject[i][j].setTerrain(new QG());
					else if (s[0].equals("Ville")) carteObject[i][j].setTerrain(new Ville());
					else if(s[0].equals("Usine"))  carteObject[i][j].setTerrain(new Usine());
					
					String [] str = s[1].split(":"); // on a par exemple Tank:1 ou 1 est le joueur 1
					if(str[0].equals("Artillerie") && str[1].equals("1")) carteObject[i][j].setUnite(new Artillerie("Artillerie", 1)) ;
					else if(str[0].equals("Artillerie") && str[1].equals("2")) carteObject[i][j].setUnite(new Artillerie("Artillerie", 2)) ;
					else if(str[0].equals("Bazooka") && str[1].equals("1")) carteObject[i][j].setUnite(new Bazooka("Bazooka", 1));
					else if(str[0].equals("Bazooka") && str[1].equals("2")) carteObject[i][j].setUnite(new Bazooka("Bazooka", 2));
					else if(str[0].equals("Bombardier") && str[1].equals("1")) carteObject[i][j].setUnite(new Bombardier("Bombardier", 1));
					else if(str[0].equals("Bombardier") && str[1].equals("2")) carteObject[i][j].setUnite(new Bombardier("Bombardier", 2));
					else if(str[0].equals("Convoit") && str[1].equals("1")) carteObject[i][j].setUnite(new Convoi("Convoit", 1));
					else if(str[0].equals("Convoit") && str[1].equals("2")) carteObject[i][j].setUnite(new Convoi("Convoit", 2));
					else if(str[0].equals("DCA") && str[1].equals("1")) carteObject[i][j].setUnite(new DCA("DCA", 1));
					else if(str[0].equals("DCA") && str[1].equals("2")) carteObject[i][j].setUnite(new DCA("DCA", 2));
					else if(str[0].equals("Helico") && str[1].equals("1")) carteObject[i][j].setUnite(new Helicoptere("Helico", 1));
					else if(str[0].equals("Helico") && str[1].equals("2")) carteObject[i][j].setUnite(new Helicoptere("Helico", 2));
					else if(str[0].equals("Infanterie") && str[1].equals("1")) carteObject[i][j].setUnite(new Infanterie("Infanterie", 1));
					else if(str[0].equals("Infanterie") && str[1].equals("2")) carteObject[i][j].setUnite(new Infanterie("Infanterie", 2));
					else if(str[0].equals("Tank") && str[1].equals("1")) carteObject[i][j].setUnite(new Tank("Tank", 1));
					else if(str[0].equals("Tank") && str[1].equals("2")) carteObject[i][j].setUnite(new Tank("Tank", 2));
					
				}
				
				else if(carteString[i][j].contains(":")) {// cas ou Ville:2
					String [] s = carteString[i][j].split(":");
					if(s[0].equals("Ville") && s[1].equals("1")) carteObject[i][j].setTerrain(new Ville("Ville", 1)) ;
					else if(s[0].equals("Ville") && s[1].equals("2")) carteObject[i][j].setTerrain(new Ville("Ville", 2)) ;
					else if(s[0].equals("Ville") && s[1].equals("0")) carteObject[i][j].setTerrain(new Ville());
					else if(s[0].equals("QG") && s[1].equals("1")) carteObject[i][j].setTerrain(new QG("QG", 1));
					else if(s[0].equals("QG") && s[1].equals("2")) carteObject[i][j].setTerrain(new QG("QG", 2));
					else if(s[0].equals("QG") && s[1].equals("0")) carteObject[i][j].setTerrain(new QG());
					else if(s[0].equals("Usine") && s[1].equals("1")) carteObject[i][j].setTerrain(new Usine ("Usine", 1));
					else if(s[0].equals("Usine") && s[1].equals("2")) carteObject[i][j].setTerrain(new Usine ("Usine", 2));
					else if(s[0].equals("Usine") && s[1].equals("0")) carteObject[i][j].setTerrain(new Usine ("Usine", 0));
					
				}
				else { // dans le cas où on a juste un terrain
					if(carteString[i][j].equals("Plaine")) carteObject[i][j].setTerrain(new Plaine());
					else if( carteString[i][j].equals("Eau")) carteObject[i][j].setTerrain(new Eau());
					else if(carteString[i][j].equals("Foret")) carteObject[i][j].setTerrain(new Foret());
					else if(carteString[i][j].equals("Montagne")) carteObject[i][j].setTerrain(new Montagne());
					else if(carteString[i][j].equals("QG")) carteObject[i][j].setTerrain(new QG());
					else if (carteString[i][j].equals("Ville")) carteObject[i][j].setTerrain(new Ville());
					else if(carteString[i][j].equals("Usine"))  carteObject[i][j].setTerrain(new Usine());
				}
			}
		}
		
		indexJoueurActif = 1; // rouge commence
	}
	
	// Zone Déplacements; à faire une fois la grille terminée
	/*
	 * methodes necessaires
	 * 
	 * selection_Chemin
	 * choix_Action
	 * Trajet// revenir en arriere faudrait une arraylist
	 * Limite_deplacement
	 */

	public boolean isOver() {
		return false;
	}

	public void afficheStatutJeu() {
		Affichage.videZoneTexte();
		Affichage.afficheTexteDescriptif("Status du jeu");
		}
	
	public void grille() {
		// afficher les images dans les cases
		for(int i =0; i<carteObject.length; i++) {
			for(int j=0; j < carteObject[0].length; j++) {
				//affichage terrains et proprietes
				Coord coord = carteObject[i][j].getPosition();
				
				if(carteObject[i][j].getTerrain() != null && carteObject[i][j].getTerrain().getNom() != null) {
					if (carteObject[i][j].getTerrain().getNom().equals("Plaine")) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminTerrain(Chemins.FICHIER_PLAINE));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Eau")) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminTerrain(Chemins.FICHIER_EAU));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Foret")) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminTerrain(Chemins.FICHIER_FORET));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Montagne")) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminTerrain(Chemins.FICHIER_MONTAGNE));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Ville") && 
							carteObject[i][j].getTerrain().getJoueur() == 1) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 1));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Ville") && 
							carteObject[i][j].getTerrain().getJoueur() == 2) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 2));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Ville") && 
							carteObject[i][j].getTerrain().getJoueur() == 0) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_VILLE, 0));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("QG") && 
							carteObject[i][j].getTerrain().getJoueur() == 1) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_QG, 1));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("QG") && 
							carteObject[i][j].getTerrain().getJoueur() == 2) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_QG, 2));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("QG") && 
							carteObject[i][j].getTerrain().getJoueur() == 0) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_QG, 0));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Usine") && 
							carteObject[i][j].getTerrain().getJoueur() == 1) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 1));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Usine") && 
							carteObject[i][j].getTerrain().getJoueur() == 2) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 2));
					}
					else if(carteObject[i][j].getTerrain().getNom().equals("Usine") && 
							carteObject[i][j].getTerrain().getJoueur() == 0) {
						Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminPropriete(Chemins.FICHIER_USINE, 0));
					}
				}
				
				//Cas ou notre unite est non nulle
				if(carteObject[i][j].getUnite() != null) {
					//affichage proprietes d'un joueur
					if(carteObject[i][j].getUnite().getJoueur1() == 1) {
						//affichage des troupes du joueur 1
						if(carteObject[i][j].getUnite().getString().equals("Artillerie")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_ARTILLERIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Bazooka")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_BAZOOKA));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Bombardier")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_BOMBARDIER));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Convoit")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_GENIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("DCA")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_ANTIAIR));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Helico")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_HELICOPTERE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Infanterie")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_INFANTERIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Tank")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(1, true, Chemins.FICHIER_TANK));
						}
						
						//fin affichage joueur 1
					}
					
					else if(carteObject[i][j].getUnite().getJoueur1() == 2) {
						//affichage des troupes du joueur 2
						if(carteObject[i][j].getUnite().getString().equals("Artillerie")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_ARTILLERIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Bazooka")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_BAZOOKA));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Bombardier")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_BOMBARDIER));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Convoit")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_GENIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("DCA")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_ANTIAIR));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Helico")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_HELICOPTERE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Infanterie")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_INFANTERIE));
						}
						else if(carteObject[i][j].getUnite().getString().equals("Tank")) {
							Affichage.dessineImageDansCase(coord.x, coord.y, Chemins.getCheminUnite(2, true, Chemins.FICHIER_TANK));
						}
						
						//fin affichage joueur 2
					}
					//on pourrait aussi afficher les troupes neutres 0
				}
			}
			// Fin affichage

		}
	}


	public void display() {
		StdDraw.clear();
		afficheStatutJeu();
		//affiche la grille jeu
		grille();
		
		if(etat.getNom().equals("Navigation trajet")) {
			imgDepartFleche();
		}		
		//Affichage.dessineImageDansCase(1, 1, Chemins.getCheminFleche(Chemins.DIRECTION_DROITE,Chemins.DIRECTION_DEBUT));
	
        
		Affichage.dessineGrille(); //affiche une grille, mais n'affiche rien dans les cases		
		drawGameCursor();
		StdDraw.show(); //montre a l'ecran les changement demandes
	}

	public void initialDisplay() {
		StdDraw.enableDoubleBuffering(); // rend l'affichage plus fluide: tout draw est mis en buffer et ne s'affiche qu'au prochain StdDraw.show();
		display();
	}

	public void drawGameCursor() {
		Affichage.dessineCurseur(curseur.x, curseur.y); 
	}

	/**
	 * @param grille represente notre grille de jeu
	 * @param curseur le curseur de notre jeu
	 * @return une case dont les coordonnees coïncident avec un curseur sur la grille de jeu
	 */
	public Case ChoixUnite(Case [][] grille, Coord curseur) {
		for(int i =0; i<carteObject.length; i++) {
			for(int j=0; j < carteObject[0].length; j++) {
				if(carteObject[i][j].getPosition().x == curseur.x && 
						carteObject[i][j].getPosition().y == curseur.y) {
					return carteObject[i][j];
				}
			}	
		}
		return null;
	}
	
	public void imgDepartFleche() {
		// pour afficher le depart d'une fleche
		Case unite = ChoixUnite(carteObject,curseur);
		if(unite.getUnite() != null) {
			Affichage.dessineImageDansCase(unite.getPosition().x, unite.getPosition().y, Chemins.getCheminFleche(Chemins.DIRECTION_DEBUT,Chemins.DIRECTION_FIN));
		}
	}
	
	public void imgFlecheDroite() {
		Case cas = ChoixUnite(carteObject,curseur);
		Affichage.dessineImageDansCase(cas.getPosition().x, cas.getPosition().y, Chemins.getCheminFleche(Chemins.DIRECTION_DROITE,Chemins.DIRECTION_DEBUT));
	}
	
	public void imgFlecheGauche() {
		Case cas = ChoixUnite(carteObject,curseur);
		Affichage.dessineImageDansCase(cas.getPosition().x, cas.getPosition().y, Chemins.getCheminFleche(Chemins.DIRECTION_DEBUT,Chemins.DIRECTION_GAUCHE));
	}
	
	public void imgFlecheHaut() {
		Case cas = ChoixUnite(carteObject,curseur);
		Affichage.dessineImageDansCase(cas.getPosition().x, cas.getPosition().y, Chemins.getCheminFleche(Chemins.DIRECTION_HAUT,Chemins.DIRECTION_FIN));
	}
	
	public void imgFlecheBas() {
		Case cas = ChoixUnite(carteObject,curseur);
		Affichage.dessineImageDansCase(cas.getPosition().x, cas.getPosition().y, Chemins.getCheminFleche(Chemins.DIRECTION_BAS,Chemins.DIRECTION_DEBUT));
	}
	
	public void update() {
		AssociationTouches toucheSuivante = AssociationTouches.trouveProchaineEntree(); //cette fonction boucle jusqu'a la prochaine entree de l'utilisateur
		if (toucheSuivante.isHaut()) { 
			// deplacer le curseur vers le haut
			etat = etat.actionHaut(curseur);
			display();
			Case unite1 = ChoixUnite(carteObject, curseur);
			if(unite1.getUnite() != null) {
				// choisir de le deplacer, utiliser getUnite.getString pour avoir son nom
				//fenetre popup deplacer ou attaquer
				String[] options = {"Deplacer", "Attendre"};
				if (Affichage.popup("Menu choix options", options, true, 1) == 0) {
					etat = new Navig_trajet("Navigation trajet");
					if(unite1.getUnite().getString().equals("Artillerie")) etat.selectionCheminArtillerie(this, 0); 
					else if(unite1.getUnite().getString().equals("Bombardier")) etat.selectionCheminBombardier(this, 7, curseur);
					else if(unite1.getUnite().getString().equals("Bazooka")) etat.selectionCheminBazooka(this, 2, curseur);
					else if(unite1.getUnite().getString().equals("Convoit")) etat.selectionCheminConvoi(this, 6, curseur);
					else if(unite1.getUnite().getString().equals("Helico")) etat.selectionCheminHelico(this, 6, curseur);
					else if(unite1.getUnite().getString().equals("Infanterie")) etat.selectionCheminInfanterie(this, 3, curseur);
					else if(unite1.getUnite().getString().equals("Tank")) etat.selectionCheminTank(this, 6, curseur);
					else if(unite1.getUnite().getString().equals("DCA")) etat.selectionCheminDCA(this, 6, curseur);
					etat = new Navig_libre("Navigation libre");
				}
			}
			
			}
		if (toucheSuivante.isBas()){ 
			// deplacer le curseur vers le bas	
			etat = etat.actionBas(curseur);
			display();
			Case unite2 = ChoixUnite(carteObject, curseur);
			if(unite2.getUnite() != null) {
				// choisir de le deplacer, utiliser getUnite.getName pour avoir son nom
				//fenetre popup deplacer ou attaquer
				String[] options = {"Deplacer", "Attendre"};
				if (Affichage.popup("Menu choix options", options, true, 1) == 0) {
					etat = new Navig_trajet("Navigation trajet");
					if(unite2.getUnite().getString().equals("Artillerie")) etat.selectionCheminArtillerie(this,0);
					else if(unite2.getUnite().getString().equals("Bombardier")) etat.selectionCheminBombardier(this, 7, curseur);
					else if(unite2.getUnite().getString().equals("Bazooka")) etat.selectionCheminBazooka(this, 2, curseur);
					else if(unite2.getUnite().getString().equals("Convoit")) etat.selectionCheminConvoi(this,6, curseur);
					else if(unite2.getUnite().getString().equals("Helico")) etat.selectionCheminHelico(this, 6, curseur);
					else if(unite2.getUnite().getString().equals("Infanterie")) etat.selectionCheminInfanterie(this, 3, curseur);
					else if(unite2.getUnite().getString().equals("Tank")) etat.selectionCheminTank(this, 6, curseur);
					else if(unite2.getUnite().getString().equals("DCA")) etat.selectionCheminDCA(this, 6, curseur);
					etat = new Navig_libre("Navigation libre");
					
				}
			}
		}
		if (toucheSuivante.isGauche()) { 
			// deplacer le curseur vers la gauche
			etat = etat.actionGauche(curseur);
			display();
			Case unite3 = ChoixUnite(carteObject, curseur);
			if(unite3.getUnite() != null) {
				// choisir de le deplacer, utiliser getUnite.getName pour avoir son nom
				//fenetre popup deplacer ou attaquer
				String[] options = {"Deplacer", "Attendre"};
				if (Affichage.popup("Menu choix options", options, true, 1) == 0) {
					etat = new Navig_trajet("Navigation trajet");
					if(unite3.getUnite().getString().equals("Artillerie")) etat.selectionCheminArtillerie(this, 0);
					else if(unite3.getUnite().getString().equals("Bombardier")) etat.selectionCheminBombardier(this, 7, curseur);
					else if(unite3.getUnite().getString().equals("Bazooka")) etat.selectionCheminBazooka(this, 2, curseur);
					else if(unite3.getUnite().getString().equals("Convoit")) etat.selectionCheminConvoi(this, 6, curseur);
					else if(unite3.getUnite().getString().equals("Helico")) etat.selectionCheminHelico(this, 6, curseur);
					else if(unite3.getUnite().getString().equals("Infanterie")) etat.selectionCheminInfanterie(this,3, curseur);
					else if(unite3.getUnite().getString().equals("Tank")) etat.selectionCheminTank(this, 6, curseur);
					else if(unite3.getUnite().getString().equals("DCA")) etat.selectionCheminDCA(this, 6, curseur);
					etat = new Navig_libre("Navigation libre");
					
				}
			}
			
		}
		if 	(toucheSuivante.isDroite()) { 
			// deplacer le curseur vers la droite
			etat = etat.actionDroite(curseur);
			display();
			Case unite4 = ChoixUnite(carteObject, curseur);
			if(unite4.getUnite() != null) {
				// choisir de le deplacer, utiliser getUnite.getName pour avoir son nom
				//fenetre popup deplacer ou attaquer
				String[] options = {"Deplacer", "Attendre"};
				if (Affichage.popup("Menu choix options", options, true, 1) == 0) {
					etat = new Navig_trajet("Navigation trajet");
					if(unite4.getUnite().getString().equals("Artillerie")) etat.selectionCheminArtillerie(this, 0);
					else if(unite4.getUnite().getString().equals("Bombardier")) etat.selectionCheminBombardier(this, 7, curseur);
					else if(unite4.getUnite().getString().equals("Bazooka")) etat.selectionCheminBazooka(this, 2, curseur);
					else if(unite4.getUnite().getString().equals("Convoit")) etat.selectionCheminConvoi(this, 6, curseur);
					else if(unite4.getUnite().getString().equals("Helico")) etat.selectionCheminHelico(this, 6, curseur);
					else if(unite4.getUnite().getString().equals("Infanterie"))etat.selectionCheminInfanterie(this, 3, curseur);
					else if(unite4.getUnite().getString().equals("Tank")) etat.selectionCheminTank(this, 6, curseur);
					else if(unite4.getUnite().getString().equals("DCA")) etat.selectionCheminDCA(this, 6, curseur);
					etat = new Navig_libre("Navigation libre");
				}
			}
			
		}
		
		//  ATTENTION ! si vous voulez detecter d'autres touches que 't',
		//  vous devez les ajouter au tableau Config.TOUCHES_PERTINENTES_CARACTERES
		if (toucheSuivante.isCaractere('t')) {
			etat = etat.actionT( indexJoueurActif);
			display();
		}
	}
}

