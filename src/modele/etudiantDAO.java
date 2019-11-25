package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entite.absence;
import entite.classe;
import entite.etudiants;

public class etudiantDAO {
	//ajoute un etudiant
	public static String ajouteetudiant(etudiants p){
		 Connection con = connectionDB.getconnection();
		 String msg = null;
		try {
			String query = "insert into etudiants(nom,prenom,cin,adresse,email,image,numphone,genre,classe_id,absence_id) values (?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setInt(3, p.getCin());
			ps.setString(4, p.getAdresse());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getImage());
			ps.setInt(7, p.getNumphone());
			ps.setString(8, p.getGenre());
			ps.setInt(9, p.getClasse().getId());
			ps.setInt(10, p.getAbsence().getId());
			int a = ps.executeUpdate();
			if(a == 1) {
				msg = "l ajouter a est succes";
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
				
		}
		return msg;
	}
	//selection d un etdiant par id 
	public  static etudiants selectionEtudiantId(int id) {
		Connection con = connectionDB.getconnection();
		classe cla;
		absence abs;
		etudiants etudiant=null;
		try {
			String query = "SELECT * FROM etudiants  WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				int id_et = rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int cin = rs.getInt("cin");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String image = rs.getString("image");
				int numphone = rs.getInt("numphone");
				String genre = rs.getString("genre");
				int classe_id = rs.getInt("classe_id");
				int absence_id = rs.getInt("absence_id");
				
				classeDAO clid = new classeDAO();
				cla = clid.selectionClasseId(classe_id);
				absenceDAO abid = new absenceDAO();
				abs = abid.selectionAbsenceId(absence_id);
				 etudiant = new  etudiants(id_et, nom, prenom, cin, adresse, email, image, numphone, genre, cla, abs);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
				
		}
		return etudiant;
	}
	//selection tout les etudiants
	public ArrayList<etudiants>  selectionEtudiants() {
		ArrayList<etudiants> tousetudiant = new ArrayList<etudiants>();
		Connection con = connectionDB.getconnection();
		classe cla;
		absence abs;
		try {
			String query = " SELECT * FROM etudiants";
			PreparedStatement ps=con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id= rs.getInt("id");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				int cin = rs.getInt("cin");
				String adresse = rs.getString("adresse");
				String email = rs.getString("email");
				String image = rs.getString("image");
				int numphone = rs.getInt("numphone");
				String genre = rs.getString("genre");
				int classe_id = rs.getInt("classe_id");
				int absence_id = rs.getInt("absence_id");
				
				classeDAO cd = new classeDAO();
				cla=cd.selectionClasseId(classe_id);
				absenceDAO ad = new absenceDAO();
				abs = ad.selectionAbsenceId(absence_id);
				etudiants etudiant = new  etudiants(id, nom, prenom, cin, adresse, email, image, numphone, genre, cla, abs);
				
				tousetudiant.add(etudiant);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		}
		return tousetudiant;
	}
	//modifier l infos d un etudiant
	public void modifierEtudiant(etudiants p) {
		Connection con = connectionDB.getconnection();
		try {
			String query = " update etudiants set nom=?,prenom=?,cin?,adresse=?,email=?,image=?,numphone=?,genre=?,classe_id=?,absence_id=? where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setString(1, p.getNom());
			ps.setString(2, p.getPrenom());
			ps.setInt(3, p.getCin());
			ps.setString(4, p.getAdresse());
			ps.setString(5, p.getEmail());
			ps.setString(6, p.getImage());
			ps.setInt(7, p.getNumphone());
			ps.setString(8, p.getGenre());
			ps.setInt(9, p.getClasse().getId());
			ps.setInt(10, p.getAbsence().getId());
			ps.setInt(11, p.getId());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		}
	}
	// supristion etudiant
	public void suprimerEtudiant(int id) {
		Connection con = connectionDB.getconnection();
		try {
			String query = " delete from  etudiants where id=?";
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, id);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		}
	}
	
}
