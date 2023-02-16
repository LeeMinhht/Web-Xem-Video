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
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class LikeVideoServlet
 */
@WebServlet("/sites/LikeVideo")
public class LikeVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(!SessionUtils.islogin(request)) {
			response.sendRedirect("Login");
			return;
		}

		String videoId = request.getParameter("videoId");
		
		try {
			FavoriteDao dao = new FavoriteDao();
			Favorite favorite = new Favorite();
			Video video = new Video();
			video.setVideoId(videoId);
			favorite.setVideo(video);
			
			String username = SessionUtils.getLoginUsername(request);
			User user = new User();
			user.setUsername(username);
			
			favorite.setUser(user);
			favorite.setLikeDate(new Date());
			
			dao.insert(favorite);
			request.setAttribute("message", "Video is added to Favorite");
			
			request.setAttribute("videoId", videoId);
//			response.sendRedirect("Detail");
			response.sendRedirect("MyFavorites");
			return;
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
//		if(page == null) {
//			page = "/sites/Homepage";
//		}
//		request.getRequestDispatcher(page).forward(request, response);
		}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
