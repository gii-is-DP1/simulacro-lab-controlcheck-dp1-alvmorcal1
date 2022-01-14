package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
    
	@Autowired 
	ProductService productService;
	
	@GetMapping(path="/create")
	public String productFormGet(ModelMap modelMap) {
		modelMap.addAttribute("product", new Product());
		modelMap.addAttribute("productType", productService.findAllProductTypes());
		return "products/createOrUpdateProductForm";
	}
	
	@PostMapping(path="/create")
	public String productForm(@Valid Product p, BindingResult b, ModelMap modelMap) {
		if(b.hasErrors()) {
			modelMap.addAttribute("product", p);
			modelMap.addAttribute("productType", productService.findAllProductTypes());
			return "products/createOrUpdateProductForm";
		}else {
			productService.save(p);
			modelMap.addAttribute("message", "Añadido!");
			return "welcome";
		}
		
	}
}
