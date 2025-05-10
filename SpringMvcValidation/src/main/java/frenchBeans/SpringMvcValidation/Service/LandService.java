package frenchBeans.SpringMvcValidation.Service;

import java.util.List;

import frenchBeans.SpringMvcValidation.model.Land;



public interface LandService {

public void addProduct(Land LandOwner);
	
	public void updateLand(Land owner);
	
	public Land getLandById(int id);
	
	public void removeLand(int id);
	
	public List<Land> listOwners();
}
