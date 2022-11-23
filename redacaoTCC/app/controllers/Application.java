package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;
import play.mvc.With;

@With(Seguranca.class)
public class Application extends Controller {

    public static void index() {
        List<Tema> temas = Tema.findAll();
        Tema ultimoTema = temas.get(temas.size() - 1);
        List<Comentario> comentariosTop = Temas.mostrarResumo(ultimoTema.id);
        render(ultimoTema, comentariosTop);
    }
    public static void ajuda(){
        render();
    }

}
