package fr.lteconsulting.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.lteconsulting.modele.Chanson;

public class ChansonDAO {
	private Connection connection;

	public ChansonDAO(MySQLDatabaseConnection connection) {
		this.connection = connection.getConnection();
	}

	public Chanson findId(String id) {
		try {

			PreparedStatement stm = connection.prepareStatement("SELECT FROM `chansons` WHERE id=?");
			stm.setString(1, id);

			ResultSet resultSet = stm.executeQuery();

			return (Chanson) resultSet;

		} catch (SQLException e) {
			throw new RuntimeException("Impossible à faire", e);
		}

	}

	public List<Chanson> findAllChansons() {
		try {
			List<Chanson> chansons = new ArrayList<>();
			PreparedStatement stm = connection.prepareStatement("SELECT * FROM `chansons`");
			stm.executeQuery();
			return chansons;
		} catch (SQLException e) {
			throw new RuntimeException("Impossible à faire", e);
		}

	}

	public Chanson add(Chanson chanson){
		try{
			PreparedStatement stm = connection.prepareStatement("INSERT INTO chansons (`disque_id`, `nom`, `duree`) VALUES (?, ?, ?)");
			stm.setString(1, chanson.getDisqueId());
			stm.setString(2, chanson.getNom());
			stm.setInt(3, chanson.getDureeEnSecondes());
			stm.executeUpdate();
			return chanson;
		} catch (SQLException e){
			throw new RuntimeException("Impossible d'ajouter la chanson", e);
		}
	}
	
	public void delete (int id){
		try{
			PreparedStatement stm = connection.prepareStatement("DELETE FROM chansons WHERE id =?");
			stm.setInt(1, id);
			stm.executeUpdate();
		}catch (SQLException e){
			throw new RuntimeException("Impossible de supprimer la chanson", e);
		}
	}
	
	public void update (Chanson chanson){
		try{
			PreparedStatement stm = connection.prepareStatement("UPDATE chansons SET `disque_id` = ?, `nom` = ?, `duree` = ? WHERE id = ?" );
			stm.setString(1, chanson.getDisqueId());
			stm.setString(2, chanson.getNom());
			stm.setInt(3, chanson.getDureeEnSecondes());
			stm.setInt(4, chanson.getId());
			stm.executeUpdate();
		}catch (SQLException e){
			throw new RuntimeException("Impossible de modifier la chanson", e);
		}
	}


}
