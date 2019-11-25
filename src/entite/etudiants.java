package entite;

public class etudiants {
	 private int id ;
	 private String nom ;
	 private String prenom ;
	 private int cin ;
	 private String adresse;
	 private String email;
	 private String image;
	 private int numphone;
	 private String genre;
	 private classe classe;
	 private absence absence;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getNumphone() {
		return numphone;
	}
	public void setNumphone(int numphone) {
		this.numphone = numphone;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public classe getClasse() {
		return classe;
	}
	public void setClasse(classe classe) {
		this.classe = classe;
	}
	public absence getAbsence() {
		return absence;
	}
	public void setAbsence(absence absence) {
		this.absence = absence;
	}
	public etudiants(int id, String nom, String prenom, int cin, String adresse, String email, String image,
			int numphone, String genre, entite.classe classe, entite.absence absence) {
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
		this.adresse = adresse;
		this.email = email;
		this.image = image;
		this.numphone = numphone;
		this.genre = genre;
		this.classe = classe;
		this.absence = absence;
	}
	@Override
	public String toString() {
		return "etudiants [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", adresse=" + adresse
				+ ", email=" + email + ", image=" + image + ", numphone=" + numphone + ", genre=" + genre + ", classe="
				+ classe + ", absence=" + absence + "]";
	}

}
