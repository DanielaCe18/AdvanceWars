package Outils;

import java.util.*;

public class Mitrailleuse_legere extends Armes {
	
	private Map<String , Double> mitrailleuse_legere;
	
	public  Mitrailleuse_legere() {
		this.mitrailleuse_legere = new TreeMap<String, Double>();
		mitrailleuse_legere.put("Infanterie", 0.6);
		mitrailleuse_legere.put("Bazooka", 0.55);
		mitrailleuse_legere.put("Tank", 0.15);
		mitrailleuse_legere.put("DCA", 0.1);
		mitrailleuse_legere.put("Helicoptere", 0.3);
		mitrailleuse_legere.put("Bombardier", null);
		mitrailleuse_legere.put("Convoi", 0.4);
		
	}

	@Override
	public Map<String, Double> getArmes() {
		return mitrailleuse_legere;
	}
	
}
