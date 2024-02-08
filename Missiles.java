package Outils;

import java.util.Map;
import java.util.TreeMap;

public class Missiles extends Armes {
	private Map<String , Double> missiles;

	public Missiles() {
		this.missiles = new TreeMap<String, Double>();;
		missiles.put("Infanterie", 0.5);
		missiles.put("Bazooka", 0.5);
		missiles.put("Tank", 0.7);
		missiles.put("DCA", 0.4);
		missiles.put("Helicoptere", 0.7);
		missiles.put("Bombardier", 0.7);
		missiles.put("Convoi", 0.7);
	}
	
	@Override
	public Map<String, Double> getArmes() {
		return missiles;
	}
	
}
