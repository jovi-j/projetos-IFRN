package bibliotecaspring.controllers;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bibliotecaspring.daos.LivroDAO;
import bibliotecaspring.models.Livro;

@Controller
public class LivroController {
	
	@RequestMapping("/livro/form")
	public String form() {
		return "livro/form";
	}

	@PostMapping("/livro")
	public String adicionar(Livro livro) {

		LivroDAO lDAO = new LivroDAO();
		lDAO.inserir(livro);
		return "redirect:/livro";

	}
	
	@GetMapping("/livro")
	public ModelAndView listar(){
		LivroDAO lDAO = new LivroDAO();
		List<Livro> lista = lDAO.getLivros();
		ModelAndView model = new ModelAndView("livro/lista");
		model.addObject("livros", lista);
		return model;
	}
	
	@PostMapping("/livro/delete")
	public String deletar(Long id){
		LivroDAO lDAO = new LivroDAO();
		lDAO.remover(id);
		return "redirect:/livro";

	}
	@PostMapping("/livro/buscar")
	public ModelAndView buscar(String titulo){
		LivroDAO lDAO = new LivroDAO();
		List<Livro> lista = lDAO.pesquisar(titulo);
		ModelAndView model = new ModelAndView("livro/lista");
		model.addObject("livros", lista);
		return model;
	}
	



}
