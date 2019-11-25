package entite;


public class generation {
	private int id ;
	private int datecreation;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDatecreation() {
		return datecreation;
	}
	public void setDatecreation(int datecreation) {
		this.datecreation = datecreation;
	}
	public generation(int datecreation) {
		super();
		this.datecreation = datecreation;
	}
	@Override
	public String toString() {
		return "generation [id=" + id + ", datecreation=" + datecreation + "]";
	}
	
}
