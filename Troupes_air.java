package Deplacement;

import java.util.Map;
import java.util.TreeMap;

public class Troupes_air extends Deplacer {
	
	private  Map<String, Integer> troupes_air;
	
	public Troupes_air() {
		this.troupes_air = new TreeMap<String, Integer>();
		this.troupes_air.put("Helicoptere", 6);
		this.troupes_air.put("Bombardier", 7);
	}
	@Override
	public void ajouter(String unite, Integer n) {
		troupes_air.put(unite, n);
	}
	
}
