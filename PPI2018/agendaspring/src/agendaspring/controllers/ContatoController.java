package agendaspring.controllers;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import agendaspring.daos.ContatoDAO;
import agendaspring.models.Contato;

@Controller
public class ContatoController {
	@RequestMapping("/contatos/form")
	public String form() {
		return "contatos/form";
	}

	@PostMapping("/contatos")
	public String adicionar(Contato contato) {

		ContatoDAO cDAO = new ContatoDAO();
		cDAO.inserir(contato);
		return "redirect:/contatos";

	}
	@PostMapping("/contatos/delete")
	public String deletar(Long id){
		ContatoDAO cDAO = new ContatoDAO();
		cDAO.remover(id);
		return "redirect:/contatos";

	}

	@GetMapping("/contatos")
	public ModelAndView listar(){
		ContatoDAO cDAO = new ContatoDAO();
		List<Contato> lista = cDAO.getLista();
		ModelAndView model = new ModelAndView("contatos/lista");
		model.addObject("contatos", lista);
		return model;
	}

}
