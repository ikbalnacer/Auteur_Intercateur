package beans;

public class auteur {
	 private Integer id ;
	  private String sexe;
	  private String nom;
	  private String prenom;
	  private Integer Ann�eNaissance;
	  private Integer Ann�ed�c�s;
	  
	public auteur(Integer id, String sexe, String nom, String prenom,
			Integer ann�eNaissance, Integer ann�ed�c�s) {
		this.id = id;
		this.sexe = sexe;
		this.nom = nom;
		this.prenom = prenom;
		this.Ann�eNaissance = ann�eNaissance;
		this.Ann�ed�c�s = ann�ed�c�s;
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

	public Integer getAnn�eNaissance() {
		return Ann�eNaissance;
	}

	public void setAnn�eNaissance(Integer ann�eNaissance) {
		this.Ann�eNaissance = ann�eNaissance;
	}

	public Integer getAnn�ed�c�s() {
		return Ann�ed�c�s;
	}

	public void setAnn�ed�c�s(Integer ann�ed�c�s) {
		this.Ann�ed�c�s = ann�ed�c�s;
	}
}
