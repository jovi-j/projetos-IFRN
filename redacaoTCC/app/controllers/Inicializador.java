package controllers;

import models.Tema;
import models.Usuario;
import models.Comentario;
import play.jobs.Job;
import play.jobs.OnApplicationStart;
import play.test.Fixtures;

@OnApplicationStart
public class Inicializador extends Job {

	public void doJob() throws Exception {
			if(Tema.count() == 0) {
				Fixtures.loadModels("temas.yml");
			}
			if(Usuario.count() == 0) {
				Fixtures.loadModels("users.yml");
			}
			
		}
	}



