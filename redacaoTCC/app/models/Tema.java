package models;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import play.db.jpa.Model;
@Entity
public class Tema extends Model {
	public String tema;

	@Temporal(TemporalType.TIMESTAMP)
	public Date dataLimiteDoTema;

    @OneToMany
	@JoinColumn(name="id_tema")
	public List<Comentario> comentarios;
    public void setDataLimite(){
        if(this.dataLimiteDoTema == null){
            Calendar c = Calendar.getInstance();
            Date d = new Date();
            c.setTime(d);
            c.add(Calendar.DAY_OF_MONTH, 7);
            this.dataLimiteDoTema = c.getTime();
        }
    }
    public boolean podeComentar(Tema tema){
        Date dataDeHoje = new Date();
            if(tema.dataLimiteDoTema.compareTo(dataDeHoje) >=0 ){
                return true;
            }else if(tema.dataLimiteDoTema.compareTo(dataDeHoje) <0 ){
                return false;
            }else{
                return true;
            }
    }


	
}
