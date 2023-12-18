package metier.liu.projet2;

public class Auteur {
	private int idAuteur;
	private String nom;
	private String adresse;
	private String region;
	
	public Auteur(int idAuteur, String nom, String adresse, String region) {
		super();
		this.idAuteur = idAuteur;
		this.nom = nom;
		this.adresse = adresse;
		this.region = region;
	}

	public int getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(int idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Auteur [idAuteur=" + idAuteur + ", nom=" + nom + ", adresse=" + adresse + ", region=" + region + "]";
	}
}
