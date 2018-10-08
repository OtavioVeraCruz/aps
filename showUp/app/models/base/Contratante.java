package models.base;


//import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.Date;

//@Entity
public class Contratante extends Usuario {

    public Contratante(String cpf, String nome, String senha, Endereco endereco, ArrayList<Evento> eventos, Date date) {
        super(cpf, nome, senha, endereco, eventos, date);
    }

    public Contratante() {
    }
}