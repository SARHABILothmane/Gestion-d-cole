package controleur;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entite.generation;
import modele.generationDAO;

/**
 * Servlet implementation class ajouterGeneration
 */
@WebServlet("/ajouterGeneration")
public class ajouterGeneration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ajouterGeneration() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String anneeStr = request.getParameter("annee");
//		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date annee =  dateFormat.parse(anneeStr);
		int annee = Integer.parseInt(request.getParameter("annee"));
		generation ge = new generation(annee);
		Boolean msg = generationDAO.insertionGeneration(ge);
		System.out.println(msg);
		request.setAttribute("msg", msg);
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
