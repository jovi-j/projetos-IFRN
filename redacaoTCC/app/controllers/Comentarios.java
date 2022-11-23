package controllers;

import java.util.Date;
import java.util.List;

import models.Comentario;
import models.Tema;
import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;

@With(Seguranca.class)
public class Comentarios extends Controller {
	public static void form(Long id_tema, Long idComentario) {
        if(idComentario == null){
            render(id_tema); 
        }else{
            Comentario resposta = Comentario.findById(idComentario);
            render(id_tema, resposta);
        }
    }

	public static void adicionar(Comentario comentario, Long autor, Long tema, Long idResposta) {
		Usuario u = Usuario.findById(autor);
        comentario.autor = u;
        Tema t = Tema.findById(tema);
        comentario.tema = t;
        comentario.data = new Date();
        if (idResposta != null){
            comentario.resposta = idResposta;
        }
        comentario.save();
		Temas.mostrarTema(tema);
	}
	
	public static void excluir(Long idComentario) {
		Comentario comentario = Comentario.findById(idComentario);
		comentario.delete();
		Temas.mostrarTema(comentario.tema.id);
	}


	public static void like(Long idComentario, Long idUsuario) {
		Comentario comentario = Comentario.findById(idComentario);
		comentario.like(idUsuario);
		comentario.save();
		Temas.mostrarTema(comentario.tema.id);
	}

	public static void dislike(Long idComentario, Long idUsuario) {
		Comentario comentario = Comentario.findById(idComentario);
		comentario.dislike(idUsuario);
		comentario.save();
		Temas.mostrarTema(comentario.tema.id);
	}


    public static void listarPorAutor(String autor){
        List<Comentario> comentarios = Comentario.find("autor like ?", "%" + autor + "%").fetch();
		render(comentarios);
    }

    public static void responder(Long idComentario){
        Comentario comentario = Comentario.findById(idComentario);
        comentario.resposta = idComentario;
        comentario.save();
        Temas.mostrarTema(comentario.tema.id);
  }
}

