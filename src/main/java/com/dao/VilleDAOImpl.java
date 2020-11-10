package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.springframework.stereotype.Repository;

import com.config.JDBCConfiguration;
import com.dto.Ville;

@Repository
public class VilleDAOImpl implements VilleDAO {

	private JDBCConfiguration connexionBDD = new JDBCConfiguration();

	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listeVille = new ArrayList<Ville>();

		// TODO récupération et requête SQL
		try {
			Connection conn = this.connexionBDD.connexion();
			Statement stm = conn.createStatement();
			ResultSet rset = stm.executeQuery("SELECT * FROM ville_france");
			while(rset.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rset.getString(1));
				ville.setNomCommune(rset.getString(2));
				ville.setCodePostal(rset.getString(3));
				ville.setLibelleAcheminement(rset.getString(4));
				ville.setLigne(rset.getString(5));
				listeVille.add(ville);
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listeVille;
	}

}
