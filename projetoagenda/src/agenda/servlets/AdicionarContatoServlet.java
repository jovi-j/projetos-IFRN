package agenda.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import agenda.daos.ContatoDAO;
import agenda.models.Contato;


@WebServlet("/adicionarContato")
public class AdicionarContatoServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String dataEmTexto = request.getParameter("dataNascimento");

		Calendar dataFinal = null;
		try {
			Date dataProvisoria = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataFinal = Calendar.getInstance();
			dataFinal.setTime(dataProvisoria);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDataNascimento(dataFinal);

		ContatoDAO dao = new ContatoDAO();
		dao.inserir(contato);

		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/contato-adicionado.jsp");
		rd.forward(request, response);
 
	}
}
