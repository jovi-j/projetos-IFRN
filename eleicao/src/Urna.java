import java.util.List;

public class Urna {
	private String secao;
	private boolean bloqueada = false; 
	
	public String getSecao() {
		return secao;
	}

	public void setSecao(String secao) {
		this.secao = secao;
	}

	public boolean isBloqueada() {
		return bloqueada;
	}

	public void bloquearUrna() {
		this.bloqueada = true;
	}
	
	public Candidato checarCandidato(Candidato c) {
		List<Candidato> candidatosDisp = Sistema.pegarCandidatos();
		for(Candidato cand : candidatosDisp) {
			if(cand.getNumero() == c.getNumero()) {
				return c;
			}
		}
		return null;
	}
	
	public boolean checarEleitor(Eleitor e) {
		List<Eleitor> eleitoresDisp = Sistema.pegarEleitores();
		for(Eleitor elei : eleitoresDisp) {
			if(elei.getTitulo() == e.getTitulo() && elei.getSecao() == this.getSecao()) {
				return true;
			}
		}
		return false;
	}
	
	public boolean gravarVoto(Voto v) {
		if (this.bloqueada == false) {
			Sistema.salvarVoto(v);
			return true;
			
		} else {
			return false;
		}
	}
	
	public List<Voto> votosDaSecao(){
		List<Voto> votosTemp = null; 
		
		for(Voto v : Sistema.pegarVotos()) {
			if(v.getEleitor().getSecao() == this.getSecao()) {
				votosTemp.add(v);
			}
		}
		return votosTemp;
	}
	
}
