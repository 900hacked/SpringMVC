package frenchBeans.SpringMvcValidation.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import frenchBeans.SpringMvcValidation.model.Land;

@Repository
public class LandDAOImpli implements LandDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void addProduct(Land LandOwner) {
		
		Session session = sessionFactory.getCurrentSession();
		session.persist(LandOwner);
	}

	@Override
	public void updateLand(Land owner) {
		
		try {
			Session session = sessionFactory.getCurrentSession();
			 session.update(owner);
			 System.out.println("Successfully updated" + owner);
			}
			catch(Exception e) {
				System.out.println("Something went wrong" + e);
			}
		
	}

	@Override
	public Land getLandById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Land body = (Land) session.get(Land.class, new Integer(id));
		return body;
	}

	@Override
	public void removeLand(int id) {
		Session session = sessionFactory.getCurrentSession();
		Land remove = (Land) session.get(Land.class, new Integer(id));
		if(null != remove){
			session.delete(remove);
		}
		
	}

	@Override
	public List<Land> listOwners() {
		// TODO Auto-generated method stub
		return null;
	}

}
