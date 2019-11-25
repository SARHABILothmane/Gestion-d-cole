package modele;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entite.absence;

public class absenceDAO {
	//ajoute d une classe
	public static void ajouteAbsence(absence ab) {
		Connection con = connectionDB.getconnection();
		try {
			String query = "INSERT INTO absences (matin,soire, remarque ) values (?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setBoolean(1, ab.getMatin());
			ps.setBoolean(1, ab.getSoire());
			ps.setString(3, ab.getRemarque());
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		 }
	   }
//		//selection d une classe par id 
	public absence selectionAbsenceId(int id) {
		Connection con = connectionDB.getconnection();
		absence ab = null;
		try {
			String query = "SELECT * FROM absences  WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id_ab = rs.getInt("id");
				Boolean matin = rs.getBoolean("matin");
				Boolean soire = rs.getBoolean("soire");
				String remarque = rs.getString("remarque");
				
				
				ab = new absence(id_ab, matin, soire, remarque);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		}
		return ab;
	  }
	//  //selection tous les classes
	//public ArrayList<classe>  selectionGeneratio() {
//		Connection con = connectionDB.getconnection();
//		ArrayList<classe> tbl = new ArrayList<classe>();
//		generation genre;
//		classe cla = null;
//		try {
//			String query = "SELECT * FROM classes";
//			PreparedStatement ps = con.prepareStatement(query);
//			ResultSet rs = ps.executeQuery();
//			while(rs.next()) {
//				int id_cl = rs.getInt("id");
//				String nom = rs.getString("nom");
//				String pseudo= rs.getString("pseudo");
//				int generation_id = rs.getInt("generation_id");
//				
//				generationDAO ge = new generationDAO();
//				genre = ge.selectionGenerationId(generation_id);
//				
//				cla = new classe(id_cl, nom, pseudo, genre);
//				
//				tbl.add(cla);
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			if(con!=null) {
//				connectionDB.disconnect();
//			}
//		}
//		return tbl;
	//  }
//	    //modifier une classe
	//public void  modifierClasse(classe cl) {
//		Connection con = connectionDB.getconnection();
//		try {
//			String query = "UPDATE classes SET nom=?,pseudo=?,generation_id=? WHERE id=?";
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setString(1, cl.getNom());
//			ps.setString(2, cl.getPseudo());
//			ps.setInt(3, cl.getGeneration().getId());
//			ps.executeUpdate();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			if(con!=null) {
//				connectionDB.disconnect();
//			}
//		 }
	//  }
	//   //suprimer classe
	//public void suprimmerClasse(int id) {
//		Connection con = connectionDB.getconnection();
//		try {
//			String query = "DELETE FROM classes WHERE id=?";
//			PreparedStatement ps = con.prepareStatement(query);
//			ps.setInt(1, id);
//			ps.executeUpdate();
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}finally {
//			if(con!=null) {
//				connectionDB.disconnect();
//			}
//		 }
	//  }
}
