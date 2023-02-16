package poly.edu.site.servlet;

import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.CookieUtils;
import poly.edu.common.PageInfo;
import poly.edu.common.SessionUtils;
import poly.edu.common.pageType;
import poly.edu.dao.UserDao;
import poly.edu.domain.LoginForm;
import poly.edu.model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/sites/Login")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = CookieUtils.get("username", request);
		
		if(username == null) {
			PageInfo.preparAndForwardSite(request, response, pageType.SITE_LOGIN_PAGE);
			return;
		}
		SessionUtils.add(request, "username", username);
		request.getRequestDispatcher("/sites/Homepage").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 try {
			LoginForm form = new LoginForm();
			BeanUtils.populate(form, request.getParameterMap());
			UserDao dao = new UserDao();
			User user = dao.findById(form.getUsername());
			
			if(user!=null && user.getPassword().equals(form.getPassword())) {
				SessionUtils.add(request, "username", user.getUsername());
				
				if(form.isRemember()) {
					CookieUtils.add("username", form.getUsername(), 24, response);
				}else {
					CookieUtils.add("username", form.getUsername(), 0, response);
				}
				request.setAttribute("isLogin", true);
				
				if(user.getAdmin()==true) {
					response.sendRedirect("/Poly.Asg/admin/VideosManagement");
					return;
				}
				
				request.setAttribute("name", user.getFullname());
				request.getRequestDispatcher("/sites/Homepage").forward(request, response);
				return;
			}
			request.setAttribute("error", "invalid username or password");
			
		} catch (Exception e) {
			request.setAttribute("error",e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_LOGIN_PAGE);
	}

}
