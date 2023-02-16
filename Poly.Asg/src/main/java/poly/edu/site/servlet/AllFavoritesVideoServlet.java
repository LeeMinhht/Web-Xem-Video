package poly.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.pageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.domain.FavoriteVideoByAllUser;

/**
 * Servlet implementation class AllFavoritesVideoServlet
 */
@WebServlet("/sites/AllFavoritesVideo")
public class AllFavoritesVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteVideoByAllUser> list = dao.reportFavoriteVideoByAllUser();
			request.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_ALLVIDEOFAVORITE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
