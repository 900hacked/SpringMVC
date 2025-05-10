package frenchBeans.SpringMVCSecurity.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frenchBeans.SpringMVCSecurity.Model.Perfumes;



@Repository
public class PerfumeDAOImpli implements PerfumesDAO{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Perfumes perfume) {
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(perfume);
		
	}

	@Override
	public void updatePerfumes(Perfumes name) {
		try {
			Session session = sessionFactory.getCurrentSession();
			 session.update(name);
			 System.out.println("Successfully updated" + name);
			}
			catch(Exception e) {
				System.out.println("Something went wrong" + e);
			}
		
	}

	@Override
	public Perfumes getPerfumesById(int id) {
		
		Session session = sessionFactory.getCurrentSession();
		Perfumes body = (Perfumes) session.get(Perfumes.class, new Integer(id));
		return body;
		
	}

	@Override
	public void removePerfume(int id) {
		Session session = sessionFactory.getCurrentSession();
		Perfumes remove = (Perfumes) session.get(Perfumes.class, new Integer(id));
		if(null != remove){
			session.delete(remove);
		}
		
	}

	@Override
	public List<Perfumes> listPerfumes() {
		Session session = sessionFactory.getCurrentSession();
		List<Perfumes> perfumeList = session.createQuery("from Perfumes").list();
		return perfumeList;
		
	}

}
