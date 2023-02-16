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
import poly.edu.dao.VideoDao;
import poly.edu.model.Video;

/**
 * Servlet implementation class SearchVideoServlet
 */
@WebServlet("/sites/SearchVideo")
public class SearchVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		VideoDao dao = new VideoDao();
		List<Video> list = dao.findVideoByTitle(title);
		System.out.println(list.size());
		request.setAttribute("video", list);
		request.setAttribute("title", title);
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_VIDEO_SEARCH_PAGE);
		
	}

}
