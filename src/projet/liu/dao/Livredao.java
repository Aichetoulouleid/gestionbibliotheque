package projet.liu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet.DbConnection;
import metier.liu.projet2.Livre;

public class Livredao implements Dao<Livre> {
	// varibles de connection
	private Connection conn;

	// initilisation de variable
	public Livredao() {
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public Livre get(long id) {
		Livre livre = null;
		// requett
		String requet = "SELECT * FROM Livre WHERE ISBN = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int ISBN = rs.getInt("ISBN");
				String titre = rs.getString("titre");
				int idAuteur = rs.getInt("idAuteur");
				livre = new Livre(ISBN, titre, idAuteur);
				System.out.println(livre.toString());
				System.out.println();
			} else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return livre;
	}

	@Override
	public List<Livre> getAll() {
		Livre livre = null;
		ArrayList<Livre> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Livre";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int ISBN = rs.getInt("ISBN");
					String titre = rs.getString("titre");
					int idAuteur = rs.getInt("idAuteur");
					livre = new Livre(ISBN, titre, idAuteur);
					arrayList.add(livre);
					System.out.println(livre.toString());
				} while (rs.next());
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Livre t) {
		String requet = "INSERT INTO Livre(ISBN, titre, idAuteur) VALUES(" + t.getISBN() + ", '" + t.getTitre() + "', '"
				+ t.getIdAuteur() + "')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tLivre enregistre !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}

	}

	@Override
	public void update(Livre t, String[] params) {
		String requet = "UPDATE Livre SET titre='" + params[0] + "', " + "idAuteur=" + Integer.parseInt(params[1]) + " "
				+ "WHERE ISBN = " + (int) t.getISBN();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tLivre modifie !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... modification echouee");
			e.printStackTrace();
		}

	}

	@Override
	public void delete(Livre t) {

		String requet = "DELETE FROM Livre WHERE ISBN = " + (int) t.getISBN();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs > 0)
				System.out.println("\tLivre supprime !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Livredao livdao = new Livredao();
		Livre liv8 = new Livre(111223, "Voyages a travrers le savoi", 8);
		//livdao.save(liv8);
		livdao.get(111223);
		livdao.getAll();
		String[] params = { "Livre Aichetou", "2" };
		livdao.update(liv8, params);
		livdao.delete(liv8);

	}

}
