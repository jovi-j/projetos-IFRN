package models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import play.data.validation.Required;

import play.db.jpa.Model;

@Entity
public class Postagem extends Model {

	@Required
	public String texto; 

	@Required
	public String empresa;

	@ManyToOne
	@JoinColumn()
	public Usuario donoDaPostagem;
}
