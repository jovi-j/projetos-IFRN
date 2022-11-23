import java.io.Serializable;

public class Eleitor implements Serializable{
	private String nome;
    private double titulo;
    private String secao;
	private boolean votou = false;

	public boolean votou() {
		return votou;
	}
	public void setVotou() {
		this.votou = true;
	}
	public String getNome() {
		return nome;
    }
	public void setNome(String nome) {
		this.nome = nome;
    }
    public String getSecao() {
		return secao;
	}
	
	public double getTitulo() {
		return titulo;
    }
    public void setSecao(String secao) {
		this.secao = secao;
    }
    
    public void setTitulo(double titulo) {
		this.titulo = titulo;
	}

	public Eleitor(String nome, double titulo, String secao) {
		super();
		this.nome = nome;
		this.titulo = titulo;
		this.secao = secao;
	}
	
	@Override
	public String toString() {
		return "Dados do Eleitor: \nNome:" + nome + 
				"\nTitulo: " + titulo + 
				"\nSeção:" + secao;
	}
    
}
