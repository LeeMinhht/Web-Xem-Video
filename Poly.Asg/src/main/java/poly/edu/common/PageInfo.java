package poly.edu.common;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.collections.map.HashedMap;

public class PageInfo {
	public static Map<pageType, PageInfo> pageRoute = new HashedMap();
	static {
		pageRoute.put(pageType.User_MANAGEMENT_PAGE, new PageInfo("User Management","/admin/users/users.jsp",null));
		pageRoute.put(pageType.REPORT_MANAGEMENT_PAGE, new PageInfo("Reports Management","/admin/reports/reports.jsp",null));
		pageRoute.put(pageType.VIDEO_MANAGEMENT_PAGE, new PageInfo("Video Management","/admin/videos/videos.jsp",null));
		
		
		pageRoute.put(pageType.SITE_HOME_PAGE, new PageInfo("Home Page","/sites/home/home.jsp",null));
		pageRoute.put(pageType.SITE_LOGIN_PAGE, new PageInfo("Home Page","/sites/users/login.jsp",null));
		pageRoute.put(pageType.SITE_REGISTRATION_PAGE, new PageInfo("Registration","/sites/users/registration.jsp",null));
		
		pageRoute.put(pageType.SITE_CHANGE_PASSWORD_PAGE, new PageInfo("Change Password","/sites/users/change-password.jsp",null));
		pageRoute.put(pageType.SITE_EDIT_PROFILE_PAGE, new PageInfo("Edit Profile","/sites/users/edit-profile.jsp",null));
		pageRoute.put(pageType.SITE_FORGOT_PASSWORD_PAGE, new PageInfo("Forgot Password","/sites/users/forgot-password.jsp",null));
		pageRoute.put(pageType.SITE_FAVORITE_PAGE, new PageInfo("Vavorite","/sites/videos/favorite.jsp",null));
		pageRoute.put(pageType.SITE_VIDEO_DETAIL_PAGE, new PageInfo("Detail","/sites/videos/detail.jsp",null));
		pageRoute.put(pageType.SITE_SHARE_PAGE, new PageInfo("Shares","/sites/videos/share.jsp",null));
		pageRoute.put(pageType.SITE_MYFAVORITES_PAGE, new PageInfo("Favorites","/sites/videos/myfavorites.jsp",null));
		pageRoute.put(pageType.SITE_ALLVIDEOFAVORITE_PAGE, new PageInfo("AllFavoritesVideo","/sites/videos/allFavoritesVideo.jsp",null));
		pageRoute.put(pageType.SITE_VIDEO_SEARCH_PAGE, new PageInfo("VideoBySearch","/sites/videos/videoBySearch.jsp",null));
		
	}
	
	public static void preparAndForward(HttpServletRequest request,HttpServletResponse response,pageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/layout.jsp").forward(request, response);
	}
	
	public static void preparAndForwardSite(HttpServletRequest request,HttpServletResponse response,pageType pageType) throws ServletException, IOException {
		PageInfo page = pageRoute.get(pageType);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/sites/layout.jsp").forward(request, response);
	}
	private String title;
	private String contenUrl;
	private String scriptUrl;
	
	
	public PageInfo() {
		super();
	}
	
	public PageInfo(String title, String contenUrl, String scriptUrl) {
		super();
		this.title = title;
		this.contenUrl = contenUrl;
		this.scriptUrl = scriptUrl;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContenUrl() {
		return contenUrl;
	}
	public void setContenUrl(String contenUrl) {
		this.contenUrl = contenUrl;
	}
	public String getScriptUrl() {
		return scriptUrl;
	}
	public void setScriptUrl(String scriptUrl) {
		this.scriptUrl = scriptUrl;
	}
	
	
}
