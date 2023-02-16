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
import poly.edu.domain.ChangePasswordForm;

/**
 * Servlet implementation class ChangePasswordServlet
 */
@WebServlet("/sites/ChangePassword")
public class ChangePasswordServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = SessionUtils.getLoginUsername(request);
		
		if(username == null) {
			request.getRequestDispatcher("/sites/Login").forward(request, response);
			return;
		}
		request.setAttribute("username", username);
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_CHANGE_PASSWORD_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			String username = SessionUtils.getLoginUsername(request);
			ChangePasswordForm form = new ChangePasswordForm();
			BeanUtils.populate(form, request.getParameterMap());
			
			request.setAttribute("username", username);
			
			if(!form.getConfirmPassword().equals(form.getPassword())) {
				request.setAttribute("error", "new password and new confirm password are not identical");
			}else {
				UserDao dao = new UserDao();
				dao.changPassword(form.getUsername(), form.getCurrentPassword(), form.getPassword());
				request.setAttribute("message", "Password has been changed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForwardSite(request, response, pageType.SITE_CHANGE_PASSWORD_PAGE);
	}

}
