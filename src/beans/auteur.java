package beans;

public class auteur {
	 private Integer id ;
	  private String sexe;
	  private String nom;
	  private String prenom;
	  private Integer AnnéeNaissance;
	  private Integer Annéedécés;
	  
	public auteur(Integer id, String sexe, String nom, String prenom,
			Integer annéeNaissance, Integer annéedécés) {
		this.id = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.AnnéeNaissance = annéeNaissance;
		this.Annéedécés = annéedécés;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Integer getAnnéeNaissance() {
		return AnnéeNaissance;
	}

	public void setAnnéeNaissance(Integer annéeNaissance) {
		this.AnnéeNaissance = annéeNaissance;
	}

	public Integer getAnnéedécés() {
		return Annéedécés;
	}

	public void setAnnéedécés(Integer annéedécés) {
		this.Annéedécés = annéedécés;
	}
}
