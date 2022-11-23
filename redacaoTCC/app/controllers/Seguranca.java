package controllers;

import play.mvc.Before;
import play.mvc.Controller;


public class Seguranca extends Controller {

	@Before(unless={"Login.form", "Login.salvar", "Usuarios.salvar", "Usuarios.form"})
	static void verificar(){
		
		if (session.contains("email") == false){
			Login.form();
		}
		
	}
	
	@Before(only={"Tema.form","Tema.salvar","Tema.remover"})
	static void permissoes(){
		if (session.get("tipo").equals("admin") == false){
			renderText("Acesso negado");
		}
	}
	
}
