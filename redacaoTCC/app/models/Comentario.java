package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Query;
import javax.persistence.EntityManager;
import play.db.jpa.*;

import play.db.jpa.Model;


@Entity
public class Comentario extends Model {
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date data;
	public String textoComent;
	
	@OneToMany(mappedBy = "comentario", cascade = CascadeType.REMOVE)
	public List<Reacao> reacoes;
    
    public Long resposta;

	public int likes;
    public int dislikes;
	@ManyToOne
	@JoinColumn(name="id_usuario")
	public Usuario autor;
	
	@ManyToOne
	@JoinColumn(name="id_tema")
	public Tema tema;
    public String nome(){
        Usuario u = Usuario.findById(autor.id);
        return u.nome + " " + u.sobrenome;
    }
    public String foto(){
        Usuario u = Usuario.findById(autor.id);
        return u.fotoUrl;
    }
    public String tipo(){
        Usuario u = Usuario.findById(autor.id);
        return u.tipo;
    }
    
    public Comentario() {
    	this.reacoes = new ArrayList<Reacao>();
    }
    
    public long likes() {
    	long quantidade = Reacao.count("comentario = ? and tipoReacao = ?", this, TipoReacao.LIKE);
    	return quantidade;
    }
    public String textoResposta(){
        Comentario c = Comentario.findById(this.resposta);
        return c.textoComent;

    } 
    public String autorResposta(){
        Comentario c = Comentario.findById(this.resposta);
        return c.nome();
    }
    public long dislikes() {
    	long quantidade = Reacao.count("comentario = ? and tipoReacao = ?", this, TipoReacao.DISLIKE);
    	return quantidade;
    }
    
    public void like(Long idUsuario) {
    	Usuario usuario = Usuario.findById(idUsuario);
    	Reacao like = new Reacao();
    	like.usuario = usuario;
    	like.tipoReacao = TipoReacao.LIKE;
    	like.comentario = this;
    	like.save();
        this.likes = this.likes + 1;
    	save();
    }
    
    public void dislike(Long idUsuario) {
    	Usuario usuario = Usuario.findById(idUsuario);
    	Reacao dislike = new Reacao();
    	dislike.usuario = usuario;
    	dislike.tipoReacao = TipoReacao.DISLIKE;
    	dislike.comentario = this;
    	dislike.save();
        this.dislikes = this.dislikes + 1;
    	save();
    }
    
    public boolean usuarioCurtiu(String id) {
    	Long idUsuario = Long.parseLong(id);
    	Usuario usuario = Usuario.findById(idUsuario);
    	long numReacoes = Reacao.count(" comentario = ? and usuario = ?", this, usuario);
    	return numReacoes > 0;
    }

}
