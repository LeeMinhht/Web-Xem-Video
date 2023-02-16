package poly.edu.site.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.EmailUtils;
import poly.edu.common.PageInfo;
import poly.edu.common.SessionUtils;
import poly.edu.common.pageType;
import poly.edu.dao.ShareDao;
import poly.edu.dao.UserDao;
import poly.edu.domain.Email;
import poly.edu.model.Share;
import poly.edu.model.User;
import poly.edu.model.Video;

/**
 * Servlet implementation class ShareVideoServlet
 */
@WebServlet("/sites/ShareVideo")
public class ShareVideoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(!SessionUtils.islogin(request)) {
			response.sendRedirect("Login");
			return;
		}
		
		String videoId = request.getParameter("videoId");
		
		if(videoId == null) {
			response.sendRedirect("/sites/Homepage");
			return;
			
		}
		request.setAttribute("videoId", videoId);
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_SHARE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String emailAddress = request.getParameter("email");
			String videoId = request.getParameter("videoId");
			
			
			if(videoId == null) {
				request.setAttribute("error", "VideoID is null!!");
				
			}else {
				Email email = new Email();
				email.setFrom("minhlvpd05439@fpt.edu.vn");
				email.setFromPassword("levanminh12");
				email.setTo(emailAddress);
				email.setSubject("Share Favorite Video");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ");
				
				sb.append("The video is more interesting and i want to share with you");
				sb.append("Please click the link ").append(String.format("a href=''>View Video</a>", videoId));
				sb.append("Regards");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				 
				ShareDao dao = new ShareDao();
				Share share = new Share();
				share.setEmail(emailAddress);
				share.setShareDate(new Date());
				
				String username = SessionUtils.getLoginUsername(request);
				User user = new User();
				user.setUsername(username);			
				share.setUser(user);
				Video video = new Video();
				
				video.setVideoId(videoId);
				
				share.setVideo(video);
				System.out.println(username);
				System.out.println(videoId);
				dao.insert(share);
				request.setAttribute("message", "video link has been sent");
//				response.sendRedirect("Homepage");
//				return;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_SHARE_PAGE);
	}

}
