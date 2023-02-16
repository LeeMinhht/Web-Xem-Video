package poly.edu.domain;

import java.util.Date;

public class ShareAboutByVideo {
	
	private String senderName;
	private String senderEmail;
	private String receiverEmail;
	private Date   sentDate;
	private String videoId;
	private String title;
	public ShareAboutByVideo() {

	}
	public ShareAboutByVideo(String senderName, String senderEmail, String receiverEmail, Date sentDate, String videoId,
			String title) {
		this.senderName = senderName;
		this.senderEmail = senderEmail;
		this.receiverEmail = receiverEmail;
		this.sentDate = sentDate;
		this.videoId = videoId;
		this.title = title;
	}
	public String getSenderName() {
		return senderName;
	}
	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}
	public String getSenderEmail() {
		return senderEmail;
	}
	public void setSenderEmail(String senderEmail) {
		this.senderEmail = senderEmail;
	}
	public String getReceiverEmail() {
		return receiverEmail;
	}
	public void setReceiverEmail(String receiverEmail) {
		this.receiverEmail = receiverEmail;
	}
	public Date getSentDate() {
		return sentDate;
	}
	public void setSentDate(Date sentDate) {
		this.sentDate = sentDate;
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
	
	
	
}
