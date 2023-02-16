package poly.edu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import poly.edu.common.PageInfo;
import poly.edu.common.UploadUtils;
import poly.edu.common.pageType;
import poly.edu.dao.FavoriteDao;
import poly.edu.dao.ShareDao;
import poly.edu.dao.UserDao;
import poly.edu.dao.UserDao;
import poly.edu.model.Favorite;
import poly.edu.model.Share;
import poly.edu.model.User;
import poly.edu.model.User;

/**
 * Servlet implementation class UsersManagementServlet
 */
@WebServlet({ "/admin/UsersManagement", "/admin/UsersManagement/edit", "/admin/UsersManagement/update",
		"/admin/UsersManagement/delete" })
public class UsersManagementServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("edit")) {
			edit(request, response);
			return;
		}
		if (url.contains("delete")) {
			delete(request, response);
			return;
		}

		fillUser(request, response);
		PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("delete")) {
			delete(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}

	}

	protected void fillUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			UserDao dao = new UserDao();
			List<User> list = dao.findAll();

			request.setAttribute("users", list);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);
		UserDao dao = new UserDao();

		try {
			User user =dao.findById(username);
			if (user == null) {
				request.setAttribute("error", "user id is required!!");
				PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);
				return;
			}
			
			FavoriteDao fdao = new FavoriteDao();
			List<Favorite> flist= fdao.findFavoriteByUsername(username);
			
			ShareDao shdao = new ShareDao();
			List<Share> shlist = shdao.findShareByUsername(username);
			
			if(flist.size()==0 && shlist.size() == 0) {
				dao.delete(username);
				request.setAttribute("message", "User is deleted");
			}else {
				request.setAttribute("error", "This user already exists in the favorites or Shares");
			}
			
			
			
			fillUser(request, response);
			request.setAttribute("user", new User());

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

		PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = new User();
		try {
			BeanUtils.populate(user, request.getParameterMap());
			UserDao dao = new UserDao();

			User oldUser = dao.findById(user.getUsername());

			dao.update(user);
			request.setAttribute("user", user);
			request.setAttribute("message", "User is updated!!");
			fillUser(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);
	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println(username);

		if (username == null) {
			request.setAttribute("error", "User id is required!!");
			PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);
			return;
		}

		try {
			UserDao dao = new UserDao();
			User user = dao.findById(username);

			request.setAttribute("user", user);
			fillUser(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForward(request, response, pageType.User_MANAGEMENT_PAGE);

	}

}
