package projet.liu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet.DbConnection;
import metier.liu.projet2.Auteur;

public class Auteurdao implements Dao<Auteur>  {
	private Connection conn;
	public Auteurdao() {
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	@Override
	public Auteur get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Auteur> getAll() {
		Auteur auteur = null;
		ArrayList<Auteur> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Auteur";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idAuteur = rs.getInt("idAuteur");
					String nom = rs.getString("nom");
					String adresse = rs.getString("adresse");
					String region = rs.getString("region");
					auteur = new Auteur(idAuteur, nom, adresse, region);
					arrayList.add(auteur);
					System.out.println(auteur.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Auteur t) {
		String requet = "INSERT INTO Auteur(idAuteur, nom, adresse, region) VALUES("+t.getIdAuteur()+", '"+t.getNom()+"', '"+t.getAdresse()+"', '"+t.getRegion()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAuteur enregistre !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(Auteur t, String[] params) {
		String requet = "UPDATE Auteur SET nom='"+params[0]+"', "
				+ "adresse='"+params[1]+"' "
				+ "region='"+params[1]+"' "
				+ "WHERE idAuteur = " + (int) t.getIdAuteur();
System.out.println(requet);
try {
	Statement pstm = conn.createStatement();
	int rs = pstm.executeUpdate(requet);
	if (rs>0)
		System.out.println("\tAuteur modifie !\n");
	else throw new SQLException();
} catch (SQLException e) {
	System.out.println("Erreur SQL... modification echouee");
	e.printStackTrace();
}
		
	}

	@Override
	public void delete(Auteur t) {
		String requet = "DELETE FROM Auteur WHERE idAuteur = " + (int) t.getIdAuteur();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAuteur supprime !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
		
	}
	public static void main ( String [] arg) {
		Auteurdao Autdao= new Auteurdao();
		Auteur Aut13= new Auteur (13," Hassen ould Med","Rue des livres , Boghe","Trarza");
		Autdao.save(Aut13);
	}
	

}
