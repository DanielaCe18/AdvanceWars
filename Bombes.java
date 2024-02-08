package Outils;

import java.util.Map;
import java.util.TreeMap;

public class Bombes extends Armes {
	
	private Map<String , Double> bombes;
	
	public Bombes() {
		this.bombes = new TreeMap<String, Double>();
		bombes.put("Infanterie", 1.0);
		bombes.put("Bazooka", 1.0);
		bombes.put("Tank", 1.0);
		bombes.put("DCA", 0.7);
		bombes.put("Helicoptere", null);
		bombes.put("Bombardier", null);
		bombes.put("Convoi", 1.0);
	}
	
	@Override
	public Map<String, Double> getArmes() {
		return bombes;
	}
	

}
