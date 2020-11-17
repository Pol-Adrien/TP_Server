package com.blo;

import java.util.ArrayList;
import com.dto.Ville;

public interface VilleBLO {
	
	public ArrayList<Ville> getInfoVille(String filtre);
	
	public void ajouterVille(Ville ville);
	
	public void modifierVille(Ville ville);
	
	public void supprimerVille(String codeCommune);
	
}
