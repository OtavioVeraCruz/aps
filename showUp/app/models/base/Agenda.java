package models.base;

import io.ebean.Model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Agenda extends Model {
    
    @Id
    private int id;
    private Date data;
    private String horaInicio;
    private String horaFim;
    private String descricao;
    private int evento_id;
   // @OneToOne(mappedBy="evento_id")
    private Evento evento;

    public Agenda() {
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

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}