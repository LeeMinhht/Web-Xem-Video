package poly.edu.admin.servlet;

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
import poly.edu.dao.ShareDao;
import poly.edu.dao.VideoDao;
import poly.edu.domain.FavoriteReport;
import poly.edu.domain.FavoriteUserReport;
import poly.edu.domain.ShareAboutByVideo;
import poly.edu.model.Video;

/**
 * Servlet implementation class ReportsManagementServlet
 */
@WebServlet("/admin/ReportsManagement")
public class ReportsManagementServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reportFavoritesByVideos(request, response);
		reportFavoriteUsersByVideo(request, response);
		reportShareByVideos(request, response);
		
		PageInfo.preparAndForward(request, response, pageType.REPORT_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	protected void reportFavoriteUsersByVideo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String videoUserId = request.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<Video> vList = vdao.findAll();
			
			if(videoUserId == null && vList.size()>0) {
				videoUserId = vList.get(0).getVideoId();
			}
			
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteUserReport> list = dao.reportFavoriteUserByVideo(videoUserId);
			
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("vidList", vList);
			
			request.setAttribute("favUsers", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}
	protected void reportFavoritesByVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			FavoriteDao dao = new FavoriteDao();
			List<FavoriteReport> list = dao.reportFavoriteByVideo();
			
			request.setAttribute("favList", list);
		} catch (Exception e) {
			request.setAttribute("error", e.getMessage());
		}
	}
	//tìm kiếm thông tin  các lượt Shared Friend
	protected void reportShareByVideos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			String videoUserId = request.getParameter("videoUserId");
			VideoDao vdao = new VideoDao();
			List<Video> videoList = vdao.findAll();
			
			if(videoUserId == null && videoList.size()>0) {
				videoUserId = videoList.get(0).getVideoId();
			}
		
			ShareDao dao = new ShareDao();
			List<ShareAboutByVideo> list = dao.ShareAboutByVideo(videoUserId);
			
			request.setAttribute("videoUserId", videoUserId);
			request.setAttribute("videoList", videoList);
			request.setAttribute("videoTT", list);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
	}
	
	

}
