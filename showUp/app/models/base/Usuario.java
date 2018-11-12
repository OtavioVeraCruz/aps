package models.base;

import io.ebean.Model;
import play.data.validation.Constraints;
import java.util.*;

import javax.persistence.*;

@MappedSuperclass
public class Usuario extends Model{

    @Constraints.Required
    @Id
    String cpf;
    @Constraints.Required
    String nome;
    @Constraints.Required
    String email;
    String senha;
    //Endereco endereco;

    Date date;

    public Usuario(){}

    public Usuario(String cpf, String nome, String email, String senha/*, Endereco endereco, ArrayList<Evento> eventos*/, Date date) {
        this.cpf = cpf;
        this.nome = nome;
        this.senha = senha;
        //this.endereco = endereco;
        //this.eventos = eventos;
        this.date = date;
        this.email=email;
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
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

     /*public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

   public List<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }*/

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}