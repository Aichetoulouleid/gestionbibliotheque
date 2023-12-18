package metier.liu.projet2;

public class Associer {
	private int idBibliotheque;
	private int idAuteur;
	
	public Associer(int idBibliotheque, int idAuteur) {
		super();
		this.idBibliotheque = idBibliotheque;
		this.idAuteur = idAuteur;
	}

	public int getIdBibliotheque() {
		return idBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	@Override
	public String toString() {
		return "Associer [idBibliotheque=" + idBibliotheque + ", idAuteur=" + idAuteur + "]";
	}

}
