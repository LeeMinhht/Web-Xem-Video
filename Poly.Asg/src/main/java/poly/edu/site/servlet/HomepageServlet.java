package poly.edu.site.servlet;

import java.io.IOException;
import java.util.Iterator;
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
 * Servlet implementation class HomepageServlet
 */
@WebServlet("/sites/Homepage")
public class HomepageServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			VideoDao dao = new VideoDao();
//			List<Video> list = dao.findAll();
//			request.setAttribute("video", list);
			
			//lấy 6 video được phân trong 1 trang
			String indexPage = request.getParameter("index");
			if(indexPage == null) {
				indexPage = "1" ;
			}
			int index = Integer.parseInt(indexPage);
			
			
			//chia trang ,trong mỗi trang có 6 video
			long count = dao.videoCount();
			System.out.println(dao.videoCount());
			long endPage = count/8;
			if(count % 8 !=0) {
				endPage++;
			}
			List<Video> list = dao.pagingvideo(index);
			
			request.setAttribute("video", list);
			request.setAttribute("tag", index);
			request.setAttribute("endPage", endPage);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error" ,e.getMessage());
		}
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_HOME_PAGE);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
