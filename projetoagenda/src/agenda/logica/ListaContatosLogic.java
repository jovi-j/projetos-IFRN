package agenda.logica;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.daos.ContatoDAO;
import agenda.models.Contato;

public class ListaContatosLogic implements Logica {
	@Override
	public String executa(HttpServletRequest req, HttpServletResponse res) throws Exception {
		List<Contato> contatos = new ContatoDAO().getLista();
		req.setAttribute("contatos", contatos);	
		return "/WEB-INF/jsp/lista.jsp";
	}
}