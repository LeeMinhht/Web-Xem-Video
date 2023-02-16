package poly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.PageInfo;
import poly.edu.common.pageType;
import poly.edu.dao.UserDao;
import poly.edu.model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/sites/Registration")
public class RegistrationServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_REGISTRATION_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String username = request.getParameter("username");
		
		try {
			
			UserDao dao = new UserDao();
			 User user = dao.findById(username);
			 
			if(user != null) {
				
				request.setAttribute("error", "username is aready!!");
				
				
			}else {
				user = new User();
				BeanUtils.populate(user, request.getParameterMap());
				user.setAdmin(false);

				dao.insert(user);
				request.setAttribute("user", user);
				request.setAttribute("message", "Register is sucessfully!!");
				
				
			}
				
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
			
		}
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_REGISTRATION_PAGE);
		
	}
}
