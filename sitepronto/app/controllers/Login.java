package controllers;


import models.Usuario;
import play .mvc.Controller;

public class Login extends Controller{

	public static void login() {
		render();
	}
	
	public static void autenticar(String email, String senha) {
		Usuario usuario = Usuario.find("email = ? and senha = ?", email, senha).first();
		if(usuario == null) {
			flash.error("Usuário ou senha inválidos.");
			params.flash();
			login();
		}else {
			session.put("usuario.id", usuario.id);
			session.put("usuario.email", usuario.email);
			Application.index();
		}
	}	
	public static void logout() {
		session.clear();
		login();
	}

}
	
