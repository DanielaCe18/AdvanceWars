package Tableau;

import Terrain.*;
import Unite.*;

public class Case {
	
	private Terrain terrain;
	private Unite unite;
	private Coord position;
	
	public Case (){
		this.terrain = null;
		this.unite = null;
		this.position = null;
	}
	
	
	
	public void setPosition(Coord position) {
		this.position = position;
	}


	public Terrain getTerrain() {
		return terrain;
	}
	

	public void setTerrain(Terrain terrain) {
		this.terrain = terrain;
	}



	public void setUnite(Unite unite) {
		this.unite = unite;
	}



	public Unite getUnite() {
		return unite;
	}



	public Coord getPosition() {
		return position;
	}



	public Case (Terrain terrain, Unite unite, Coord position){
		this.terrain = terrain;
		this.unite = unite;
		this.position = position;
	}

}
