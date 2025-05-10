package frenchBeans.SpringMvcValidation.Service;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import frenchBeans.SpringMvcValidation.model.Land;

public class LandValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Land.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Land land = (Land) target;
        
        if (land.getEmailAdress() == null || !land.getEmailAdress().matches(".+@.+\\..+")) {
            errors.rejectValue("email", "email.invalid", "Invalid email format");
        }
        if (land.getLandOwnerNames() == null || land.getLandOwnerNames().length() < 4) {
            errors.rejectValue("firstName", "firstName.invalid", "First name must be at least 4 characters long");
        }
        
        if (land.getLocation() == null || land.getLocation().length() < 3) {
            errors.rejectValue("Location", "location.invalid", "location should be at least 3 characters");
        }
		
	}

}
