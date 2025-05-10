package frenchBeans.SpringMvcValidation.Controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import frenchBeans.SpringMvcValidation.Service.LandService;
import frenchBeans.SpringMvcValidation.Service.LandValidator;
import frenchBeans.SpringMvcValidation.model.Land;


@Controller
@RequestMapping("/land")
public class LandController {
	
	@Autowired
	private LandService service;
	
	LandValidator validate = new LandValidator();

	
	@ResponseBody
	@RequestMapping(value = "/add")
	public String addProduct(@RequestBody @Valid Land landOwner, BindingResult result ) {
		
		
		
		if (result.hasErrors()) {
            return "Email validation failed: " + result.getAllErrors();
        }
        else {
        	service.addProduct(landOwner);
        	 return "User registered successfully";
        }
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}")
	public String updateProduct(@RequestBody Land updatedProduct, @PathVariable("id") int id) {
		Land up = service.getLandById(id);
		up.setLandOwnerNames(updatedProduct.getLandOwnerNames());
		up.setLocation(updatedProduct.getLocation());
		service.updateLand(up);
		System.out.println("updated data:" + up);
		return "Successfully updated";
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{id}")
	public Land getLandById(@PathVariable("id") int id) {
		
		Land body = service.getLandById(id);
		return body;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}")
	public String removeBodyCare(@PathVariable("id") int id ) {
		
		service.removeLand(id);
		return "Body Care of " + id + " has been deleted";
	
}
	
	@ResponseBody
	@RequestMapping(value = "/valid")
    public String registerEmployee(@RequestBody @Validated Land land, BindingResult result) {
		  validate.validate(land, result);
        if (result.hasErrors()) {
            return "Registration has failed: " + result.getAllErrors();
        }
        else {
        	service.addProduct(land);
        	 return "Registered Successfully";
        }
	}
}
