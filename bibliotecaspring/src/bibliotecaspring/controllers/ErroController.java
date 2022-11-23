package bibliotecaspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErroController {
	@GetMapping("/erro")
	public ModelAndView erro(String erro){
		ModelAndView model = new ModelAndView("erro");
		model.addObject("erro", erro);
		return model;
	}
	
}
