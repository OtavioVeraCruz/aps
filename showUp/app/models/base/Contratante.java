package models.base;


import io.ebean.*;
import play.data.validation.Constraints;
import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Contratante extends Usuario {

    public Contratante(String cpf, String nome, String email,String senha, Endereco endereco, ArrayList<Evento> eventos, Date date) {
       super(cpf, nome, email,senha, endereco, eventos, date); 
    }

    public Contratante() {
    }
}