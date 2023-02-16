package poly.edu.domain;

import java.util.Date;

public class MyFavorites {
	private String title;
	private int view;
	private String videoId;
	private Date likeDate;
	private String poster;
	private int favoriteId;
	
	public MyFavorites() {

	}

	public MyFavorites(String title, int view, String videoId, Date likeDate, String poster, int favoriteId) {

		this.title = title;
		this.view = view;
		this.videoId = videoId;
		this.likeDate = likeDate;
		this.poster = poster;
		this.favoriteId = favoriteId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getView() {
		return view;
	}

	public void setView(int view) {
		this.view = view;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getFavoriteId() {
		return favoriteId;
	}

	public void setFavoriteId(int favoriteId) {
		this.favoriteId = favoriteId;
	}
	
	
	
	
	
	
	
	

}
