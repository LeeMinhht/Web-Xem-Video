package poly.edu.admin.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import poly.edu.dao.VideoDao;
import poly.edu.model.Favorite;
import poly.edu.model.Share;
import poly.edu.model.Video;

/**
 * Servlet implementation class VideosManagementServlet
 */
@WebServlet({ "/admin/VideosManagement", "/admin/VideosManagement/create", "/admin/VideosManagement/update",
		"/admin/VideosManagement/delete", "/admin/VideosManagement/reset", "/admin/VideosManagement/edit" })
@MultipartConfig
public class VideosManagementServlet extends HttpServlet {

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
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}

		Video video = new Video();
		video.setPoster("images/up-min.jpg");

		findAll(request, response);

		request.setAttribute("video", video);
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.contains("create")) {
			create(request, response);
			return;
		}
		if (url.contains("delete")) {
			create(request, response);
			return;
		}
		if (url.contains("update")) {
			update(request, response);
			return;
		}
		if (url.contains("reset")) {
			reset(request, response);
			return;
		}
	}

	private void reset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video=new Video();
		video.setPoster("images/up-min.jpg");
		request.setAttribute("video",video);
		
		findAll(request, response);
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");

		if (id == null) {
			request.setAttribute("error", "Video id is required!!");
			PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}

		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);
			
			if(video == null) {
				request.setAttribute("error", "Video id not found!!");
				PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
				return;
			} 
			ShareDao shdao = new ShareDao();
			FavoriteDao fdao = new FavoriteDao();
			
			List<Favorite> flist = fdao.findFavoriteByVideoId(id);
			List<Share> shlist = shdao.findShareByVideoId(id);
			
			if(flist.size()==0 && shlist.size() == 0) {
				dao.delete(id);
				request.setAttribute("message", "Video is deleted");
			}else {
				request.setAttribute("error", "This Video already exists in the favorites or Shares");
			}
			

			request.setAttribute("video", new Video());
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();
		try {
			BeanUtils.populate(video, request.getParameterMap());
			VideoDao dao = new VideoDao();

			Video oldVideo = dao.findById(video.getVideoId());

			if (request.getPart("cover").getSize() == 0) {
				video.setPoster(oldVideo.getPoster());
			} else {
				video.setPoster(
						"uploads/" + UploadUtils.processUploadFiled("cover", request, "/uploads", video.getVideoId()));
			}

			dao.update(video);
			request.setAttribute("video", video);
			request.setAttribute("message", "Video is updated!!");
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
	}

	private void findAll(HttpServletRequest request, HttpServletResponse response) {

		try {

			VideoDao dao = new VideoDao();

			List<Video> list = dao.findAll();
			request.setAttribute("videos", list);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}

	}

	private void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("videoId");

		if (id == null) {
			request.setAttribute("error", "Video id is required!!");
			PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
			return;
		}

		try {
			VideoDao dao = new VideoDao();
			Video video = dao.findById(id);

			request.setAttribute("video", video);
			findAll(request, response);
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());
		}
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);

	}

	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Video video = new Video();

		try {
			BeanUtils.populate(video, request.getParameterMap());

			video.setPoster(
					"uploads/" + UploadUtils.processUploadFiled("cover", request, "/uploads", video.getVideoId()));
			VideoDao dao = new VideoDao();
			dao.insert(video);

			request.setAttribute("video", video);
			request.setAttribute("message", "Video is inserted!!");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e.getMessage());

		}
		findAll(request, response);
		PageInfo.preparAndForward(request, response, pageType.VIDEO_MANAGEMENT_PAGE);
	}

}
