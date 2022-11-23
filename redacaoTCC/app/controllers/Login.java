package controllers;

import models.Usuario;
import play.mvc.Controller;

public class Login extends Controller {
	
	public static void form(){
		render();
	}
	
	public static void logar(String email, String senha){




        Usuario usuario = Usuario.find("email = ?1 and senha = ?2",
                                        email, senha ).first() ;
            
        if (usuario == null){
            flash.error("Email ou senha inválido.");
             Login.form();
        } else {
            session.put("email", usuario.email);  
            session.put("nome", usuario.nome); 
            session.put("sobrenome", usuario.sobrenome);
            session.put("tipo", usuario.tipo);    
            session.put("uid", usuario.id);
            session.put("fotoUrl", "/public/images/userprofile/" + usuario.fotoUrl);    
            Application.index();
        }
	}
	
	public static void sair(){
		session.clear();
		form();
	}
	
}
