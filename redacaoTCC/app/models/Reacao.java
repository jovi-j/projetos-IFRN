package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;

@Entity
public class Reacao extends Model{
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
	
	@ManyToOne
	public Usuario usuario;
	
	@Enumerated(EnumType.STRING)
	public TipoReacao tipoReacao;
	
	@ManyToOne
	public Comentario comentario;
	
	public Reacao() {
		this.data = new Date();
	}
}
