package Tableau;

public class Coord {

	public int x;
	public int y;
	
	public Coord () {
		this.x = 0;
		this.y = 0;
	}
	
	public Coord (int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Convertir les indices du tableau en coordonnées (x,y)
	 * 
	 * à noter: Config.longueurCarteYCases = nbCasesY
	 */
	public static Coord conversion (int nbCasesY, int i, int abscisse) {// à tester et à revoir
		Coord reel = new Coord();
		reel.y = nbCasesY-i-1;
		reel.x = abscisse;
		
		return reel;
	}
	
	/*
	 * renvoie de nouvelles coordonnées correspondant au déplacement d'un curseur 
	 * à l'aide de touche directionnelle Haut, Bas, Droite, Gauche
	 */
	public Coord curseurHaut () {
		return null;
	}
	
	public Coord curseurBas() {
		return null;
	}
	
	public Coord curseurDroite() {
		return null;
	}
	
	public Coord curseurGauche() {
		return null;
	}
}
