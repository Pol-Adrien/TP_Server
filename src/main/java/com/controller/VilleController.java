package com.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.VilleBLO;
import com.dto.Ville;

@RestController
public class VilleController {

	@Autowired
	VilleBLO villeService;

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	@ResponseBody
	public ArrayList<Ville> appelGet(@RequestParam(required = false) String departement) {
		System.out.println("Appel GET");
		return villeService.getInfoVille(departement);
	}
	
	@RequestMapping(value = "/post", method = RequestMethod.POST)
	@ResponseBody
	public void appelPost(@RequestParam String codeCommune,
						  @RequestParam String nomCommune, 
						  @RequestParam String codePostal,
						  @RequestParam String libelleAcheminement,
						  @RequestParam String ligne5,
						  @RequestParam String latitude,
						  @RequestParam String longitude) {
		System.out.println("Appel POST");
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne5(ligne5);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		villeService.ajouterVille(ville);
	}
	
	@RequestMapping(value = "/put", method = RequestMethod.PUT)
	@ResponseBody
	public void appelPut(@RequestParam String codeCommune,
					  	 @RequestParam String nomCommune, 
						 @RequestParam String codePostal,
						 @RequestParam String libelleAcheminement,
						 @RequestParam String ligne5,
						 @RequestParam String latitude,
						 @RequestParam String longitude) {
		System.out.println("Appel PUT");
		Ville ville = new Ville();
		ville.setCodeCommune(codeCommune);
		ville.setNomCommune(nomCommune);
		ville.setCodePostal(codePostal);
		ville.setLibelleAcheminement(libelleAcheminement);
		ville.setLigne5(ligne5);
		ville.setLatitude(latitude);
		ville.setLongitude(longitude);
		villeService.modifierVille(ville);
	}

	@RequestMapping(value = "/delete", method = RequestMethod.DELETE)
	@ResponseBody
	public void appelDelete(@RequestParam String codeCommune) {
		System.out.println("Appel DELETE");
		villeService.supprimerVille(codeCommune);;
	}
}
