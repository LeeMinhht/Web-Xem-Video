package poly.edu.site.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.PageInfo;
import poly.edu.common.SessionUtils;
import poly.edu.common.pageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.dao.VideoDao;
import poly.edu.domain.MyFavorites;
import poly.edu.model.Video;

/**
 * Servlet implementation class MyFavoritesServlet
 */
@WebServlet("/sites/MyFavorites")
public class MyFavoritesServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(request);
		if(username == null) {
			response.sendRedirect("Login");
			return;
		}
		System.out.println(username);
		try {

			FavoriteDao dao = new FavoriteDao();
			List<MyFavorites> list = dao.reportMyFavoriteByUser(username);

			request.setAttribute("video", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_MYFAVORITES_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
