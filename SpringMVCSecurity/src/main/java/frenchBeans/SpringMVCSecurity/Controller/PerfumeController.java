package frenchBeans.SpringMVCSecurity.Controller;

import java.nio.charset.StandardCharsets;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import frenchBeans.SpringMVCSecurity.Model.Perfumes;
import frenchBeans.SpringMVCSecurity.Service.PerfumeService;


@Controller
@RequestMapping("/perfume")
public class PerfumeController {
	
	@Autowired
	private PerfumeService service;
	
	

	
	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProduct(@RequestBody @Valid Perfumes name, BindingResult result, HttpServletRequest request ) {
		
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return "Access denied: No active session.";
        }
		
		if (result.hasErrors()) {
            return "Email validation failed: " + result.getAllErrors();
        }
        else {
        	service.addProduct(name);
        	 return "User registered successfully";
        }
		
		
	}
	
	@ResponseBody
	@RequestMapping(value = "/update/{id}",  method = RequestMethod.PUT)
	
	public String updateProduct(@RequestBody Perfumes updatedProduct, @PathVariable("id") int id, HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            return "Access denied: No active session.";
        } else {
        
		Perfumes scent = service.getPerfumesById(id);
		scent.setPerfumeName(updatedProduct.getPerfumeName());
		scent.setMililitres(updatedProduct.getMililitres());
		service.updatePerfumes(scent);
		System.out.println("updated data:" + scent);
		return "Successfully updated";
        }
	}
	
	@ResponseBody
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public Perfumes getLandById(@PathVariable("id") int id) {
		
		Perfumes body = service.getPerfumesById(id);
		return body;
	}
	
	@ResponseBody
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String removeBodyCare(@PathVariable("id") int id ) {
		
		service.removePerfume(id);
		return "Body Care of " + id + " has been deleted";
	
}
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response) {
		
		String authHeader = request.getHeader("Authorization");
		
		if (authHeader == null || !authHeader.startsWith("Basic ")) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "Missing or invalid Authorization header";
        }
		String base64Credentials = authHeader.substring(6);

		 
        String credentials = new String(Base64.decodeBase64(base64Credentials), StandardCharsets.UTF_8);
  
        String[] values = credentials.split(":", 2);

        
 
        if ("admin".equals(values[0]) && "password".equals(values[1])) {
            HttpSession session = request.getSession();
            session.setAttribute("user", values[0]);
            return "Session Token: " + session.getId();
        } else {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return "Invalid credentials";
        }
	}
	
	@ResponseBody
	@RequestMapping(value = "/gets", method = RequestMethod.GET)
	public List<Perfumes> getAll() {
		
		return  service.listPerfumes();
	}
	
//	@ResponseBody
//	@RequestMapping(value = "/valid")
//    public String registerEmployee(@RequestBody @Validated Land land, BindingResult result) {
//		  validate.validate(land, result);
//        if (result.hasErrors()) {
//            return "Registration has failed: " + result.getAllErrors();
//        }
//        else {
//        	service.addProduct(land);
//        	 return "Registered Successfully";
//        }
//	}

}
