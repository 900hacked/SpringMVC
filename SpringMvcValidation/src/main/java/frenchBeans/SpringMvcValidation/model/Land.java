package frenchBeans.SpringMvcValidation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "Land")
public class Land {
	
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int landId;
	
//	@NotEmpty(message = "Name is required") @Size(min = 4, message = "First name must be at least 4 characters long")
	private String landOwnerNames;
	
//	@NotEmpty(message = "Email is required") @Pattern(regexp = ".+@.+\\..+", message = "Invalid email format")
	private String emailAdress;
	
	private String location;
	
	public Land() {
		
	}

	public Land( String landOwnerNames, String email, String location) {
		
		
		this.landOwnerNames = landOwnerNames;
		this.emailAdress = email;
		this.location = location;
	}

	public int getLandId() {
		return landId;
	}

	public void setLandId(int landId) {
		this.landId = landId;
	}

	public String getLandOwnerNames() {
		return landOwnerNames;
	}

	public void setLandOwnerNames(String landOwnerNames) {
		this.landOwnerNames = landOwnerNames;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}
	
	
	

}
