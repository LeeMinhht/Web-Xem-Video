package poly.edu.dao;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;


import poly.edu.domain.FavoriteUserReport;
import poly.edu.model.Video;


public class VideoDao extends AbstractEntityDao<Video> {

	public VideoDao() {
		super(Video.class);
		// TODO Auto-generated constructor stub
	}

	public List<Video> findVideoByTitle(String title){
		String jpql = " select v from Video v where v.title like :title";
		
		EntityManager em = JpaUtils.getEntityManager();
		List<Video> list = null;
		
		try {
			TypedQuery<Video> query = em.createQuery(jpql,Video.class);
			
			query.setParameter("title", "%"+title+"%");
			list = query.getResultList();
		} finally {
			em.close();
		}
		return list;
		
	}
	
	public Long videoCount() {
		String jpql = " select count(videoId) from Video v";
		EntityManager em = JpaUtils.getEntityManager();
		
		TypedQuery<Long> query = em.createQuery(jpql,Long.class);
		return query.getSingleResult();
		
	}
	
	public List<Video> pagingvideo(int index){
		
		String jpql = "select * from Videos order by videoId offset ? rows fetch next 8 rows only ";
		EntityManager em = JpaUtils.getEntityManager();
		

			javax.persistence.Query query = em.createNativeQuery(jpql,Video.class);
			query.setParameter(1, (index-1)*8);
			List<Video> list = query.getResultList();

		return list;
		
	}
	
	//check xem video đã được like hay chưa
	
	
	
}
