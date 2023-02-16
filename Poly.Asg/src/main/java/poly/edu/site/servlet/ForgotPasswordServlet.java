package poly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import poly.edu.common.EmailUtils;
import poly.edu.common.PageInfo;
import poly.edu.common.pageType;
import poly.edu.dao.UserDao;
import poly.edu.domain.Email;
import poly.edu.model.User;

/**
 * Servlet implementation class ForgotPasswordServlet
 */
@WebServlet("/sites/ForgotPassword")
public class ForgotPasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_FORGOT_PASSWORD_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String emailAddress = request.getParameter("email");
			String username = request.getParameter("username");
			
			UserDao dao = new UserDao();
			User user = dao.findByUserIdAndEmail(username, emailAddress);
			
			if(user == null) {
				request.setAttribute("error", "Username or Eamil is incorrect");
				
			}else {
				Email email = new Email();
				email.setFrom("minhlvpd05439@fpt.edu.vn");
				email.setFromPassword("levanminh12");
				email.setTo(emailAddress);
				email.setSubject("Forgot Password Function");
				
				StringBuilder sb = new StringBuilder();
				sb.append("Dear ").append(username);
				
				sb.append("You are used the forgot password function.");
				sb.append("Your password is ").append(user.getPassword());
				sb.append("Regards");
				sb.append("Administrator");
				
				email.setContent(sb.toString());
				EmailUtils.send(email);
				
				request.setAttribute("message", "Email sent to the email address. Please check and get Your password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_FORGOT_PASSWORD_PAGE);
	}

}
