package models.base;


import io.ebean.*;
import play.data.validation.Constraints;
import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Contratante extends Usuario {
    @OneToMany(mappedBy="contratante")
    List<Evento> eventos;
    @OneToOne
    private Endereco endereco;
    public Contratante(String cpf, String nome, String email,String senha, Endereco endereco, ArrayList<Evento> eventos, Date date) {
       super(cpf, nome, email,senha, date); 
       this.endereco=endereco;
       this.eventos=eventos;
    }
    
    public Contratante() {
    }
    public static final Finder<String, Contratante> find = new Finder<String, Contratante>(Contratante.class);
}