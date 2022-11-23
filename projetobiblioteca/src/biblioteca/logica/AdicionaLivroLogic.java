package biblioteca.logica;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import biblioteca.daos.LivroDAO;
import biblioteca.models.Livro;

public class AdicionaLivroLogic implements Logica {
	@Override
	public String executa(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String nome = request.getParameter("nome");
		String autor = request.getParameter("autor");
		String secao = request.getParameter("secao");
		int ano = Integer.parseInt(request.getParameter("ano"));
		int qtde = Integer.parseInt(request.getParameter("quantidade"));
		Livro livro = new Livro();
		livro.setNome(nome);
		livro.setAutor(autor);
		livro.setSecao(secao);
		livro.setAno(ano);
		livro.setQuantidade(qtde);
		LivroDAO dao = new LivroDAO();
		dao.inserir(livro);
		System.out.println("Adicionando Livro...");
		return "mvc?logica=ListaLivroLogic";
	}
}