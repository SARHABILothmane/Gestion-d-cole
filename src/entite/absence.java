	package entite;

public class absence {
private int id ;
private Boolean matin;
private Boolean soire ;
private String remarque;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Boolean getMatin() {
	return matin;
}
public void setMatin(Boolean matin) {
	this.matin = matin;
}
public Boolean getSoire() {
	return soire;
}
public void setSoire(Boolean soire) {
	this.soire = soire;
}
public String getRemarque() {
	return remarque;
}
public void setRemarque(String remarque) {
	this.remarque = remarque;
}
public absence(int id, Boolean matin, Boolean soire, String remarque) {
	super();
	this.id = id;
	this.matin = matin;
	this.soire = soire;
	this.remarque = remarque;
}
@Override
public String toString() {
	return "absence [id=" + id + ", matin=" + matin + ", soire=" + soire + ", remarque=" + remarque + "]";
}

}
