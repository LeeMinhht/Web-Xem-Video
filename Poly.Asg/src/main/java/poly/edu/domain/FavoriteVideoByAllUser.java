package poly.edu.domain;

public class FavoriteVideoByAllUser {
	private String videoId;
	private String title;
	private String description;
	private String poster;
	private int views;
	private boolean active;
	
	public FavoriteVideoByAllUser() {

	}

	public FavoriteVideoByAllUser(String videoId, String title, String description, String poster, int views,
			boolean active) {

		this.videoId = videoId;
		this.title = title;
		this.description = description;
		this.poster = poster;
		this.views = views;
		this.active = active;
	}

	public String getVideoId() {
		return videoId;
	}

	public void setVideoId(String videoId) {
		this.videoId = videoId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public int getViews() {
		return views;
	}

	public void setViews(int views) {
		this.views = views;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	
}
