import java.io.Serializable;

public class Voto implements Serializable {
	private Candidato candidato;
	private Eleitor eleitor;
	
	public Candidato getCandidato() {
		return candidato;
	}
	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}
	public Eleitor getEleitor() {
		return eleitor;
	}
	public void setEleitor(Eleitor eleitor) {
		this.eleitor = eleitor;
	}
	
	public Voto(Candidato candidato, Eleitor eleitor) {
		super();
		this.candidato = candidato;
		this.eleitor = eleitor;
	}
}
