package metier.liu.projet2;

public class Bibliotheque {
	private int idBibliotheque;
	private String emplacement;

	public Bibliotheque(int idBibliotheque, String emplacement) {
		super();
		this.idBibliotheque = idBibliotheque;
		this.emplacement = emplacement;
	}

	public int getIdBibliotheque() {
		return idBibliotheque;
	}

	public void setIdBibliotheque(int idBibliotheque) {
		this.idBibliotheque = idBibliotheque;
	}

	public String getEmplacement() {
		return emplacement;
	}

	public void setEmplacement(String emplacement) {
		this.emplacement = emplacement;
	}

	@Override
	public String toString() {
		return idBibliotheque + " - " + emplacement;
	}

}
