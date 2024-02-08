package Deplacement;

import java.util.*;

public class Troupes_pied extends Deplacer {
	
	private Map<String, Integer> troupes_pied;
	
	public Troupes_pied() {
		this.troupes_pied = new TreeMap<String, Integer>();
		troupes_pied.put("Infanterie", 3);
		troupes_pied.put("Bazooka", 2);
	}
	@Override
	public void ajouter(String unite, Integer n) {
		this.troupes_pied.put(unite, n);
	}

}
