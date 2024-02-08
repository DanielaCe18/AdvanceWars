package Outils;

import java.util.Map;
import java.util.TreeMap;

public class Mitrailleuse_lourde extends Armes{

	private Map<String , Double> mitrailleuse_lourde;
	
	public  Mitrailleuse_lourde() {
		this.mitrailleuse_lourde =  new TreeMap<String, Double>();
		mitrailleuse_lourde.put("Infanterie", 1.0);
		mitrailleuse_lourde.put("Bazooka", 0.8);
		mitrailleuse_lourde.put("Tank", 0.3);
		mitrailleuse_lourde.put("DCA", 0.3);
		mitrailleuse_lourde.put("Helicoptere", 1.1);
		mitrailleuse_lourde.put("Bombardier", 0.7);
		mitrailleuse_lourde.put("Convoi", 0.5);
	}
	
	@Override
	public Map<String, Double> getArmes() {
		return mitrailleuse_lourde;
	}
}
