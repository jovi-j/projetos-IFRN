package models;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import play.db.jpa.Model;

@Entity
public class Usuario extends Model {
 public String nome;
 public String sobrenome;
 public String email;
 public String senha;
 public String tipo;
 public String areaEspec;
 public String fotoUrl = "default/default.png";

 @JoinColumn(name="id_comentario")
 @OneToMany
 public List<Comentario> comentarios;
 
}
