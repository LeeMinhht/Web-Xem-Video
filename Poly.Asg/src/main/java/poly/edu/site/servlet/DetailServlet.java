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
import poly.edu.model.Favorite;
import poly.edu.model.Video;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/sites/Detail")
public class DetailServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CheckLike(request, response);
		insertViewVideo(request, response);
		fillAllVideo(request, response);
		
		try {
			
			String videoId = request.getParameter("videoId");
//			if(videoId == null) {
//				response.sendRedirect("Homepage");
//				return;
//			}else {
				
				VideoDao dao = new VideoDao();
				Video video = dao.findById(videoId);
				
				request.setAttribute("video", video);
//			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_VIDEO_DETAIL_PAGE);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void fillAllVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		try {
			VideoDao dao = new VideoDao();
			List<Video> list = dao.findAll();
			
			request.setAttribute("videos", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	protected void insertViewVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");

		try {
			
			VideoDao dao = new VideoDao();
			Video video = dao.findById(videoId);
			video.setViews(video.getViews()+1);
			System.out.println(video.getViews());
			dao.update(video);

		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	protected  void CheckLike(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String videoId = request.getParameter("videoId");
		String username = SessionUtils.getLoginUsername(request);
		System.out.println("haha");
		boolean check = false;
		try {
			
			FavoriteDao fdao = new FavoriteDao();
			Favorite favorite = fdao.checkLikeVideoByUsername(videoId, username);
			request.setAttribute("favorite", favorite);
			
			if(favorite==null) {
				System.out.println("Ban chua like video");
				check = false;
				return ;
			}else {
				System.out.println("ban da like video");
				check = true;
				request.setAttribute("checkLike", true);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		
	}

}
