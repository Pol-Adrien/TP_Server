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

	@Override
	public ArrayList<Ville> findAllVilles() {
		ArrayList<Ville> listeVille = new ArrayList<>();
		Connection conn = JDBCConfiguration.connexion();
		String query = "SELECT * FROM ville_france";
		try (Statement stm = conn.createStatement();
			 ResultSet rset = stm.executeQuery(query)) {
			while (rset.next()) {
				Ville ville = new Ville();
				ville.setCodeCommune(rset.getString(1));
				ville.setNomCommune(rset.getString(2));
				ville.setCodePostal(rset.getString(3));
				ville.setLibelleAcheminement(rset.getString(4));
				ville.setLigne5(rset.getString(5));
				ville.setLatitude(rset.getString(6));
				ville.setLongitude(rset.getString(7));
				listeVille.add(ville);
			}
			rset.close();
			stm.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listeVille;
	}

}
