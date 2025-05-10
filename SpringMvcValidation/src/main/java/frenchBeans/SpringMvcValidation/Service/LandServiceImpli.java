package frenchBeans.SpringMvcValidation.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import frenchBeans.SpringMvcValidation.DAO.LandDAO;
import frenchBeans.SpringMvcValidation.model.Land;

@Service
public class LandServiceImpli implements LandService {
	
	@Autowired
	private LandDAO landDao;

	@Override
	@Transactional
	public void addProduct(Land LandOwner) {
		landDao.addProduct(LandOwner);
		
	}

	@Override
	@Transactional
	public void updateLand(Land owner) {
		
		landDao.updateLand(owner);
		
	}

	@Override
	public Land getLandById(int id) {
		
		Land plot = landDao.getLandById(id);
		return plot;
	}

	@Override
	public void removeLand(int id) {
		
		landDao.removeLand(id);
		
	}

	@Override
	public List<Land> listOwners() {
		// TODO Auto-generated method stub
		return null;
	}

}
