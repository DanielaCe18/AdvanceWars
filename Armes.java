package Outils;

import java.util.Map;
import java.util.TreeMap;

public class Armes {
	
	private  Map<String , Double> armes;
	
	public Armes() {
		this.armes = new TreeMap<String, Double>();
		armes.put("Infanterie", null);
		armes.put("Bazooka", null);
		armes.put("Tank", null);
		armes.put("DCA", null);
		armes.put("Helicoptere",null);
		armes.put("Bombardier", null);
		armes.put("Convoi", null);
	}

	public Map<String, Double> getArmes() {
		return armes;
	}
	
	public Double get (String unite) {
		return null;
	}
}
