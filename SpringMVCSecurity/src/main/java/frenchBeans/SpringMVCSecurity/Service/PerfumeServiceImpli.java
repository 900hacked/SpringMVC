package frenchBeans.SpringMVCSecurity.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import frenchBeans.SpringMVCSecurity.DAO.PerfumesDAO;
import frenchBeans.SpringMVCSecurity.Model.Perfumes;

@Service
public class PerfumeServiceImpli implements PerfumeService {
	
	@Autowired
	private PerfumesDAO perfumeDao;

	@Override
	@Transactional
	public void addProduct(Perfumes perfume) {
		
		perfumeDao.addProduct(perfume);
		
	}

	@Override
	@Transactional
	public void updatePerfumes(Perfumes name) {
		
		perfumeDao.updatePerfumes(name);
		
	}

	@Override
	@Transactional
	public Perfumes getPerfumesById(int id) {
		
		Perfumes smell = perfumeDao.getPerfumesById(id);
		return smell;
	}

	@Override
	@Transactional
	public void removePerfume(int id) {
		
		perfumeDao.removePerfume(id);
		
	}

	@Override
	@Transactional
	public List<Perfumes> listPerfumes() {
		
		return perfumeDao.listPerfumes();
	}

}
