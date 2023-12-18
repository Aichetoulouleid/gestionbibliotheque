package projet.liu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet.DbConnection;
import metier.liu.projet2.Associer;
import metier.liu.projet2.Bibliotheque;
import metier.liu.projet2.Livre;

public class Associerdao implements Dao<Associer> {
	private Connection conn;
	public Associerdao() {
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Associer get( int idBibliotheque, int idAuteur) {
		Associer association = null;
		String requet = "SELECT * FROM Associer WHERE idbibliotheque = "+idBibliotheque+" AND idAuteur = "+idAuteur;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				association = new Associer(idBibliotheque, idAuteur);
				System.out.println(association.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return association;
	}

	@Override
	public Associer get(long id) {
		Associer associer = null;
		String requet = "SELECT * FROM Associer  WHERE idAuteur = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int idBibliotheque = rs.getInt("idBibliotheque");
				int idAuteur = rs.getInt("idAuteur");
				associer = new Associer(idBibliotheque, idAuteur);
				System.out.println(associer.toString());
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return associer;
	}

	@Override
	public List<Associer> getAll() {
		
		Associer associer = null;
		ArrayList<Associer> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Associer";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int idBibliotheque = rs.getInt("idBibliotheque");
					int idAuteur = rs.getInt("idAuteur");
					associer = new Associer(idBibliotheque, idAuteur);
					arrayList.add(associer);
					System.out.println(associer.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Associer t) {
		String requet = "INSERT INTO Associer(idBibliotheque, idAuteur) VALUES("+t.getIdBibliotheque()+", '"+t.getIdAuteur()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAssociation enregistree !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Associer t, String[] params) {

	}
		
		
	

	@Override
	public void delete(Associer t) {
		String requet = "DELETE FROM Associer WHERE idBibliotheque = " + t.getIdBibliotheque() + "AND idAuteur = " + t.getIdAuteur();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tAssociation supprimee !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
		}
		
		public static void main(String[] args) {
			Associerdao assdao =new Associerdao();
			Associer ass8 = new Associer (2,3);
			//assdao.save(ass8);
			//assdao.getAll();
			//assdao.get(2);
		}
	}


