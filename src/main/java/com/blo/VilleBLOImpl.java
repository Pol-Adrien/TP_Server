package com.blo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.VilleDAO;
import com.dto.Ville;

@Service
public class VilleBLOImpl implements VilleBLO {

	@Autowired
	private VilleDAO villeDAO;

	@Override
	public ArrayList<Ville> getInfoVille(String filtre) {
		ArrayList<Ville> listeVille = null;
		if (filtre == null) {
			listeVille = villeDAO.findAllVilles();
		} else {
			listeVille = villeDAO.findVilles(filtre);
		}
		return listeVille;
	}

	@Override
	public void ajouterVille(Ville ville) {
		villeDAO.addVille(ville);
	}

	@Override
	public void modifierVille(Ville ville) {
		villeDAO.updateVille(ville);
	}

	@Override
	public void supprimerVille(String codeCommune) {
		villeDAO.deleteVille(codeCommune);
	}

}
