package models.base;


//import io.ebean.Model;
import play.data.validation.Constraints;
import java.util.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Contratante extends Usuario {

	@Constraints.Required
	@Constraints.MinLength(11)
	@Id
	String cpf;
	String nome; 
	String senha;
	Endereco endereco; 
	ArrayList<Evento> eventos;


    public Contratante(String cpf, String nome, String senha, Endereco endereco, ArrayList<Evento> eventos, Date date) {
       super(cpf, nome, senha, endereco, eventos, date); 
       
       //this.cpf=cpf;
       //this.nome=nome;
       //this.senha=senha;
       //this.endereco=endereco;
      // this.eventos=eventos;
    }

    public Contratante() {
    }

    public String getNome() {
   	 return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

   /* public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }*/
}