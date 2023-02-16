package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.edu.domain.MyFavorites;
import poly.edu.domain.ShareAboutByVideo;
import poly.edu.model.Favorite;
import poly.edu.model.Share;

public class ShareDao extends AbstractEntityDao<Share> {

	public ShareDao() {
		super(Share.class);
		
	}
	 
	//tìm kiếm thông tin của Shared bằng videoId  từ Video title
	public List<ShareAboutByVideo> ShareAboutByVideo(String videoId){
		String jpql = "select new poly.edu.domain.ShareAboutByVideo(f.user.username, f.user.email, "
				+ "f.email, f.shareDate, f.video.videoId,f.video.title) from Share f where f.video.videoId = :videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<ShareAboutByVideo> list = null;
		
		try {
			TypedQuery<ShareAboutByVideo> query = em.createQuery(jpql,ShareAboutByVideo.class);
			
			query.setParameter("videoId", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<Share> findShareByUsername(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Share f where f.user.username like :username";
		List<Share> list = null;
		
		try {

			TypedQuery<Share> query = em.createQuery(jpql,Share.class);
			query.setParameter("username", username);
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;

	}
	//tìm kiếm video đã được like hay share chưa để xóa
		public List<Share> findShareByVideoId(String videoID) {
			EntityManager em = JpaUtils.getEntityManager();
			String jpql = "select f from Share f where f.video.videoId = :videoId";
			List<Share> list = null;
			
			try {

				TypedQuery<Share> query = em.createQuery(jpql,Share.class);
				query.setParameter("videoId", videoID);
				list = query.getResultList();
			} finally {
				em.close();
			}
			
			return list;

		}
		
	
	
}
