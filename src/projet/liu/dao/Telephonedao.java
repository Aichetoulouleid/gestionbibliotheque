package projet.liu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import bdd.liu.projet.DbConnection;
import metier.liu.projet2.Telephone;

public class Telephonedao implements Dao<Telephone> {
	
	private Connection conn;
	public Telephonedao() {
		try {
			conn = DbConnection.getInstance().getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Override
	public Telephone get(long id) {
		Telephone telephone = null;
		String requet = "SELECT * FROM Telephone WHERE numero = " + (int) id;
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next()) {
				int numero = rs.getInt("numero");
				String type = rs.getString("type");
				int idAuteur = rs.getInt("idAuteur");
				telephone = new Telephone(numero, type, idAuteur);
				System.out.println(telephone.toString());
				System.out.println();
			}
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... element introuvable");
			e.printStackTrace();
		}
		return telephone;
	}

	@Override
	public List<Telephone> getAll() {
		Telephone telephone = null;
		ArrayList<Telephone> arrayList = new ArrayList<>();
		String requet = "SELECT * FROM Telephone";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			ResultSet rs = pstm.executeQuery(requet);
			if (rs.next())
				do {
					int numero = rs.getInt("numero");
					String type = rs.getString("type");
					int idAuteur = rs.getInt("idAuteur");
					telephone = new Telephone(numero, type, idAuteur);
					arrayList.add(telephone);
					System.out.println(telephone.toString());
				} while (rs.next());
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... Elements introuvables");
			e.printStackTrace();
		}
		return arrayList;
	}

	@Override
	public void save(Telephone t) {
		String requet = "INSERT INTO Telephone(numero, type, idAuteur) VALUES("+t.getNumero()+", '"+t.getType()+"', '"+t.getIdAuteur()+"')";
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tTelephone enregistre !\n");
			else
				throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... enregistrement echoue");
			e.printStackTrace();
		}
	}

	@Override
	public void update(Telephone t, String[] params) {
		String requet = "UPDATE Telephone SET type='"+params[0]+"', "
				+ "idAuteur='"+params[1]+"' "
				+ "WHERE numero = " + (int) t.getNumero();
System.out.println(requet);
try {
	Statement pstm = conn.createStatement();
	int rs = pstm.executeUpdate(requet);
	if (rs>0)
		System.out.println("\tTelephone modifee !\n");
	else throw new SQLException();
} catch (SQLException e) {
	System.out.println("Erreur SQL... modification echouee");
	e.printStackTrace();
}
		
	}

	@Override
	public void delete(Telephone t) {
		String requet = "DELETE FROM Telephone WHERE numero = " + (int) t.getNumero();
		System.out.println(requet);
		try {
			Statement pstm = conn.createStatement();
			int rs = pstm.executeUpdate(requet);
			if (rs>0)
				System.out.println("\tTelephone supprime !\n");
			else throw new SQLException();
		} catch (SQLException e) {
			System.out.println("Erreur SQL... suppression echouee");
			e.printStackTrace();
		}
		}
		public static void main ( String [] arg) {
			Telephonedao Teldao =new Telephonedao();
			  Telephone Tel11=new Telephone(123123,"Mobile", 11);
			  Teldao.save (Tel11);
	}
		
	
		
	

}
