package Controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.MovieBean;
import Respority.MovieListRespority;

/**
 * Servlet implementation class MovieListServlet
 */
@WebServlet("/MovieLists")
public class MovieListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MovieListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String catId=request.getParameter("catId");
	if(!catId.isEmpty()) {
		int id=Integer.parseInt(catId);
		MovieListRespority movRepo=new MovieListRespority();
		List<MovieBean> movlist=movRepo.getAllCategorise(id);
				
		request.setAttribute("mov_list", movlist);
		request.getRequestDispatcher("MovieList.jsp").forward(request, response);
	}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
