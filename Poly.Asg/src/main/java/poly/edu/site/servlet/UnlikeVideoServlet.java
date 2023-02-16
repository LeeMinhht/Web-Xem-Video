package poly.edu.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.SessionUtils;
import poly.edu.common.pageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.domain.MyFavorites;
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class UnlikeVideoServlet
 */
@WebServlet("/sites/UnlikeVideo")
public class UnlikeVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int favoriteId = Integer.valueOf(request.getParameter("favoriteId"));
		System.out.println(favoriteId);
		
		
		try {
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite =dao.findById(favoriteId);
			if(favorite != null) {
				dao.delete(favoriteId);
				System.out.println("Xoa thanh cong favorite");
				
			}
			else {
				System.out.println("khong tim thay Favorite");
				response.sendRedirect("Homepage");
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		response.sendRedirect("MyFavorites");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
