package models.base;

import io.ebean.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

import java.util.ArrayList;

@Entity
public class Evento extends Model {
    @Id
    private int id;
    private String nome;
    private Endereco endereco;
    private double preco;
    private ArrayList<String> instrumentos;
    private Agenda agenda;

    public Evento() {
    }
    public Evento(String nome,Endereco endereco,double preco,ArrayList<String> instrumentos,Agenda agenda) {
        this.nome=nome;
        this.endereco=endereco;
        this.preco=preco;
        this.instrumentos=instrumentos;
        this.agenda=agenda;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public ArrayList<String> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(ArrayList<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public Agenda getAgenda() {
        return agenda;
    }

    public void setAgenda(Agenda agenda) {
        this.agenda = agenda;
    }
}