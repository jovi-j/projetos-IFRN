package controllers;

import java.util.List;

import models.Usuario;
import play.mvc.Controller;
import play.mvc.With;
import java.io.File;

@With(Seguranca.class)
public class Usuarios extends Controller {
	
	public static void form() {
		render();
	}
	
	public static void index(){
		render();
	}

	public static void perfil(Long id){
		Usuario usuario = Usuario.findById(id);
		render(usuario);
	}

    

	public static void salvar(Usuario usuario, String senha, String ver) {
		if (senha.equals("") == false){
			usuario.senha = senha;
		}
	    	
		usuario.save();
        
        if(ver != null){
            Application.index();
        }else{
            flash.success("Usuário criado com sucesso!");
            Login.form();
        }
	}
	
	public static void editar(Long id) {
		Usuario usuario = Usuario.findById(id);
		renderTemplate("Usuario/form.html", usuario);
	}
	
	public static void remover(Long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		listar();
	}
	
    public static void salvarFt(Long usuarioId, File foto){
        Usuario user = Usuario.findById(usuarioId);
        if(foto == null){
            flash.error("Foto vazia ou inválida.");
            Usuarios.perfil(user.id);
        }
        foto.renameTo(new File("./public/images/userprofile/" + session.get("uid") + foto.getName()));
        user.fotoUrl = session.get("uid") + foto.getName();
        user.save();
        session.put("fotoUrl", "/public/images/userprofile/" + user.fotoUrl);
        Usuarios.perfil(user.id);
    }

    public static void listar() {
		List<Usuario> usuarios = Usuario.findAll();
		render(usuarios);
	}
}
