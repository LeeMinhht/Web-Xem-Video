package poly.edu.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import poly.edu.domain.FavoriteReport;
import poly.edu.domain.FavoriteUserReport;
import poly.edu.domain.FavoriteVideoByAllUser;
import poly.edu.domain.MyFavorites;
import poly.edu.model.Favorite;
import poly.edu.model.User;
import poly.edu.model.Video;

public class FavoriteDao extends AbstractEntityDao<Favorite> {

	public FavoriteDao() {
		super(Favorite.class);
		
	}
	public List<FavoriteUserReport> reportFavoriteUserByVideo(String videoId){
		String jpql = "select new poly.edu.domain.FavoriteUserReport(f.user.username, f.user.fullname, "
				+ "f.user.email, f.likeDate) from Favorite f where f.video.videoId = :videoId";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteUserReport> list = null;
		
		try {
			TypedQuery<FavoriteUserReport> query = em.createQuery(jpql,FavoriteUserReport.class);
			
			query.setParameter("videoId", videoId);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
		
	}
	public List<FavoriteReport> reportFavoriteByVideo(){
		String jpql = "select new poly.edu.domain.FavoriteReport(f.video.title, count(f), min(f.likeDate), max(likeDate)) "
				+ " from Favorite f group by f.video.title ";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteReport> list = null;
		
		try {
			TypedQuery<FavoriteReport> query = em.createQuery(jpql,FavoriteReport.class);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	// tìm kiếm video yêu thích theo username đăng nhập
	public List<MyFavorites> reportMyFavoriteByUser(String username){
		String jpql = "select new poly.edu.domain.MyFavorites(f.video.title, f.video.views, "
				+ "f.video.videoId, f.likeDate, f.video.poster, f.favoriteId) from Favorite f where f.user.username = :username";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<MyFavorites> list = null;
		
		try {
			TypedQuery<MyFavorites> query = em.createQuery(jpql,MyFavorites.class);
			
			query.setParameter("username", username);
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	//tìm kiếm video được yêu thích bởi tất cả user
	public List<FavoriteVideoByAllUser> reportFavoriteVideoByAllUser(){
		String jpql = "select distinct new poly.edu.domain.FavoriteVideoByAllUser(f.video.videoId, f.video.title, "
				+ "f.video.description, f.video.poster, f.video.views, f.video.active) from Favorite f order by f.video.views DESC";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<FavoriteVideoByAllUser> list = null;
		
		try {
			TypedQuery<FavoriteVideoByAllUser> query = em.createQuery(jpql,FavoriteVideoByAllUser.class);
			
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
	}
	
	public List<Favorite> findFavoriteByUsername(String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Favorite f where f.user.username like :username";
		List<Favorite> list = null;
		
		try {

			TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
			query.setParameter("username", username);
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;

	}
	
	//tìm kiếm video đã được like hay share chưa để xóa
	public List<Favorite> findFavoriteByVideoId(String videoID) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Favorite f where f.video.videoId = :videoId";
		List<Favorite> list = null;
		
		try {

			TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
			query.setParameter("videoId", videoID);
			list = query.getResultList();
		} finally {
			em.close();
		}
		
		return list;

	}
	
	// tìm kiếm username đã like video hay chưa 
	public Favorite checkLikeVideoByUsername(String videoId, String username) {
		EntityManager em = JpaUtils.getEntityManager();
		String jpql = "select f from Favorite f where f.user.username = :username and f.video.videoId = :videoId";


			TypedQuery<Favorite> query = em.createQuery(jpql,Favorite.class);
			query.setParameter("username", username);
			query.setParameter("videoId", videoId);
			
			
			Favorite favorite = query.getSingleResult();
	
		return favorite;
		
	}
}







