package frenchBeans.SpringMVCSecurity.DAO;

import java.util.List;

import frenchBeans.SpringMVCSecurity.Model.Perfumes;




public interface PerfumesDAO {
	
	public void addProduct(Perfumes perfume);


public void updatePerfumes(Perfumes name);
	
	public Perfumes getPerfumesById(int id);
	
	public void removePerfume(int id);
	
	public List<Perfumes> listPerfumes();
}
