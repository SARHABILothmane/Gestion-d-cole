package modele;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import entite.generation;

public class generationDAO {

	//insertion d une generation
	public static Boolean insertionGeneration(generation ge) {
		Connection con = connectionDB.getconnection();
		Boolean msg = false;
		try {
			String query = "INSERT INTO generations (annee) values (?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, ge.getDatecreation());
			int a = ps.executeUpdate();
			if (a==1) {
				msg = true;
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
	//selection d un generation par id 
	public generation selectionGenerationId(int id) {
		Connection con = connectionDB.getconnection();
		generation gen = null;
		try {
			String query = "SELECT * FROM generations  WHERE id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int id_ge = rs.getInt("id");
				int annee = rs.getInt("annee");
				gen = new generation(annee);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			if(con!=null) {
				connectionDB.disconnect();
			}
		 }
		return gen;
	}
}
