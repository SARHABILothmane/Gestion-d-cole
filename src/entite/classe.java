package entite;

public class classe {
	private int id ;
	private String nom;
	private String pseudo;
	private generation generation;
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
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public generation getGeneration(){
		 return generation;
	}
	public void setGeneration(generation generation) {
		this.generation = generation;
	}
	public classe(int id, String nom, String pseudo,generation generation) {
		super();
		this.id = id;
		this.nom = nom;
		this.pseudo = pseudo;
		this.generation = generation;
	}
	@Override
	public String toString() {
		return "classe [id=" + id + ", nom=" + nom + ", pseudo=" + pseudo +", generation="+generation+"]";
	}
	
}
