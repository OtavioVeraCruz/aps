package models.base;

import io.ebean.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Agenda extends Model {
    
    @Id
    private int id;
    private Date data;
    private String horaInicio;
    private String horaFim;
    @OneToOne
    private Evento evento;

    public Agenda() {}
    public Agenda(Date data,String horaInicio,String horaFim) {
        this.data=data;
        this.horaInicio=horaInicio;
        this.horaFim=horaFim;
    }
    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(String horaFim) {
        this.horaFim = horaFim;
    }

    public static Finder<Integer, Agenda> find = new Finder<Integer, Agenda>(Agenda.class);
}