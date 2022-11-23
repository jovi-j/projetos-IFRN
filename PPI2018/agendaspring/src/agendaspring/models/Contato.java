package agendaspring.models;

import java.util.Calendar;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

public class Contato {

	private Long id;
	@NotNull(message="{contato.campo.nulo}")
	private String nome;
	@NotNull(message="{contato.campo.nulo}")
	private String email;
	@NotNull(message="{contato.campo.nulo}")
	private String endereco;
	@DateTimeFormat(pattern="dd/mm/yyyy")
	@Size(min=10, max=10, message="{contato.campo.pequeno}")
	@NotNull(message="{contato.campo.nulo}")
	private Calendar dataNascimento;

	@Override
	public String toString() {
		return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", endereco=" + endereco
				+ ", dataNascimento=" + dataNascimento + "]";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
