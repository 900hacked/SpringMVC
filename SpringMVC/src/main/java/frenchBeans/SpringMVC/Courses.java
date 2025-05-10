package frenchBeans.SpringMVC;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;



	@Controller
	@RequestMapping("/so") // example of RequestMapping at class level
	public class Courses {
		
		@ResponseBody
		@RequestMapping("/sugar")
		public String giveSugar() {
			
			return "Ok; here's the sugar for your tea.";
		}
		
		@ResponseBody
		@RequestMapping(value = "/*dear", method = RequestMethod.GET)
		public String daddy() {
			
			return "daddy";
		}
		
		@ResponseBody
		@RequestMapping(value = "/mum")
		public String mummy() {
			return "mummy is going to the market to buy onions";
		}
		
		@ResponseBody
		@RequestMapping(value = "/product")
		public String prod() {
			Products pro = new Products();
			pro.setProductName("Light Bulb");
			return pro.getProductName();
		}
		
		@ResponseBody
		@RequestMapping(value = "/buck")
		public Products pro() {
			
			return new Products("Bucket",50.1);
		}
	}

