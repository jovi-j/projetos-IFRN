package jobs;

import models.Usuario;
import models.Postagem;
import play.jobs.Job;
import play.jobs.OnApplicationStart;


@OnApplicationStart
public class dados extends Job{
		
	@Override
	public void doJob() throws Exception {
		
		Usuario juvenal = new Usuario();
		juvenal.nome = "Juvens";
		juvenal.email = "juvens@localnet.br";
		juvenal.senha = "goku007";
		juvenal.Nascimento = 2020;	

		Usuario juba = new Usuario();
		juba.nome = "Jujuba";
		juba.email = "anejoestar@localnet.br";
		juba.senha = "speedwagongostosa01";
		juba.Nascimento = 2020;

		Usuario ademir = new Usuario();
		ademir.nome = "Ademir";
		ademir.email = "admin@admin";
		ademir.senha = "admin";
		ademir.Nascimento = 2020;

		ademir.save();
		juba.save();
		juvenal.save();

		Postagem p = new Postagem();
		p.empresa = "Posto Ipiranga - MACAU";
		p.texto = "O atendimento é massa";
		p.donoDaPostagem = juba;
		p.save();

		Postagem q = new Postagem();
		q.empresa = "Posto Ipiranga - MACAU";
		q.texto = "Atendimento rápido";
		q.donoDaPostagem = juvenal;
		q.save();
	}
}
