package poly.edu.site.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.PageInfo;
import poly.edu.common.SessionUtils;
import poly.edu.common.pageType;
import poly.edu.dao.UserDao;
import poly.edu.model.User;

/**
 * Servlet implementation class EditProfileServlet
 */
@WebServlet("/sites/EditProfile")
public class EditProfileServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(request);
		if(username==null) {
			request.getRequestDispatcher("/sites/Login").forward(request, response);
			return;
		}
		try {
			UserDao dao = new UserDao();
			User user = dao.findById(username);
			
			request.setAttribute("user", user);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_EDIT_PROFILE_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user = new User();
			BeanUtils.populate(user, request.getParameterMap());
			
			String username = SessionUtils.getLoginUsername(request);
			String password =request.getParameter("password");
			System.out.println(password);
			
			UserDao dao = new UserDao();
			User oldUser = dao.findById(username);
			System.out.println(oldUser.getPassword());
			

				user.setAdmin(oldUser.getAdmin());
				dao.update(user);
				request.setAttribute("message", "User profile updated!!");

				
		
			request.setAttribute("user", user);
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_EDIT_PROFILE_PAGE);
	}

}
