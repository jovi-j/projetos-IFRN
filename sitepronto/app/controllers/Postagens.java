package controllers;

import java.util.List;

import models.Postagem;
import models.Usuario;
import play.mvc.Controller;

public class Postagens extends Controller {

	public static void form(Long id) {
		Postagem post = new Postagem();
		render(post, id);
	}
	
	public static void salvar(Postagem post, Long uid) {
		post.donoDaPostagem = Usuario.findById(uid);
		post.save();
		listar(); 
	}
	public static void listar() {
		List<Postagem> lista = Postagem.findAll();
		render(lista);
	}
	public static void editar(long id) {
		Postagem post	= Postagem.findById(id);
		renderTemplate("Postagens/form.html",post);
	}
	public static void deletar(long id) {
		Postagem post = Postagem.findById(id);
		post.delete();
		listar();
	}

}
