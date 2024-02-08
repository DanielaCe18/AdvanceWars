package Unite;
import Outils.*;
import Terrain.*;
import java.util.*;

public class Unite {
	
	private String unite;
	private int joueur1;
	private double pv;
	private Armes armes;
	private int prix;
	private int credit;
	
	public Unite (){
		this.pv = 10.0;
		this.credit = 0;
		
	}
	
	
	public int getJoueur1() {
		return joueur1;
	}

	public double getPv() {
		return pv;
	}

	public void setPv(double pv) {
		this.pv = pv;
	}


	public String getString() {
		return unite;
	}

	public Armes getArmes() {
		return armes;
	}


	public void setArmes(Armes armes) {
		this.armes = armes;
	}

	public int getCredit() {
		return credit;
	}


	public void rise_credit(Unite unite, Proprietes prop) {
		if(prop.capture(unite, prop)) {
			this.credit += 1000;
		}
	}

	/**
	 * renvoie true si une unite est détruite
	 */
	public boolean estDetruite() {
		if (pv <= 0.0) {
			return true;
		}
		else return false;
	}
}
