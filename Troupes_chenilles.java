package Deplacement;

import java.util.Map;
import java.util.TreeMap;

public class Troupes_chenilles extends Deplacer {
	
	private  Map<String, Integer> troupes_chenilles;
	
	public Troupes_chenilles() {
		this.troupes_chenilles =  new TreeMap<String, Integer>();
		troupes_chenilles.put("Tank", 6);
		troupes_chenilles.put("Convoi", 6);
		troupes_chenilles.put("DCA", 6);
	}
	
	@Override
	public void ajouter(String unite, Integer n) {
		this.troupes_chenilles.put(unite, n);
	}

}
