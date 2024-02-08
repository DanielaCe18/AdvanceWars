package Outils;

import java.util.Map;
import java.util.TreeMap;

public class Canon extends Armes {
	
	private Map<String , Double> canon;
	
	public Canon() {
		this.canon = new TreeMap<String, Double>();
		canon.put("Infanterie", 0.45);
		canon.put("Bazooka", 0.45);
		canon.put("Tank", 0.55);
		canon.put("DCA", 0.60);
		canon.put("Helicoptere", 0.30);
		canon.put("Bombardier", null);
		canon.put("Convoi", 0.7);
	}

	@Override
	public Map<String, Double> getArmes() {
		return canon;
	}
	
	
}
