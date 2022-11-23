package bibliotecaspring.controllers;

import java.util.List;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import bibliotecaspring.daos.AlunoDAO;
import bibliotecaspring.models.Aluno;

@Controller
public class AlunoController {
	@RequestMapping("/aluno/form")
	public String form() {
		return "aluno/form";
	}


	@PostMapping("/aluno")
	public String adicionar(Aluno aluno) {

		AlunoDAO aDAO = new AlunoDAO();
		aDAO.inserir(aluno);
		return "redirect:/aluno";

	}
	@PostMapping("/aluno/delete")
	public String deletar(Long id){
		AlunoDAO aDAO = new AlunoDAO();
		aDAO.remover(id);
		return "redirect:/aluno";

	}

	@GetMapping("/aluno")
	public ModelAndView listar(){
		AlunoDAO aDAO = new AlunoDAO();
		List<Aluno> lista = aDAO.getAlunos();
		ModelAndView model = new ModelAndView("aluno/lista");
		model.addObject("alunos", lista);
		return model;
	}

}
