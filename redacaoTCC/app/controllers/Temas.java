package controllers;

import java.util.List;

import models.Usuario;
import models.Tema;
import models.Comentario;
import play.mvc.Controller;
import java.util.List;
import play.mvc.With;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import play.db.jpa.*;


@With(Seguranca.class)
public class Temas extends Controller {
	public static void form() {
		render();
	}

	public static void adicionar(Tema tema) {
		tema.setDataLimite();
        tema.save();
		listar();
	}
	
	public static void listar() {
		List<Tema> temas = Tema.findAll();
		Tema ultimoTema = temas.get(temas.size() - 1);
		Usuario usuario = Usuario.findById(Long.parseLong(session.get("uid")));
		render(temas, ultimoTema, usuario);
	}

	public static List<Tema> getLista() {
		return Tema.findAll();
		
	}
	public static void mostrarTema(long idTema){
		Tema tema = Tema.findById(idTema);
		List<Comentario> comentariosSobreTema = Comentario.find("id_tema = ? ORDER BY likes DESC", tema.id).fetch();
		render(tema, comentariosSobreTema);
	}

    public static List<Comentario> mostrarResumo(long idTema){
        List<Comentario> comentariosMaisVotados = Comentario.find("id_tema = ? ORDER BY likes DESC", idTema).fetch(10);
        return comentariosMaisVotados;
    }
}
