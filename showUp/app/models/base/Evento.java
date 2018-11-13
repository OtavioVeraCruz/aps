package models.base;

import io.ebean.*;
import java.util.*;
import javax.persistence.*;

@Entity
public class Evento extends Model {
    @Id
    private int id;
    private String nome;
    @OneToOne
    private Endereco endereco;
    private double preco;
    private ArrayList<String> instrumentos;
    private String descricao;
    @OneToOne(mappedBy="evento")
    private Agenda agenda;
    @ManyToOne
    @JoinColumn(name = "contratante_id", referencedColumnName = "cpf")
    private Contratante contratante;

    @ManyToMany(mappedBy="eventos")
    private List<Artista>artistas;

    public Evento() {
    }
    public Evento(String nome,String descricao,Endereco endereco,double preco,ArrayList<String> instrumentos,Agenda agenda) {
        this.nome=nome;
        this.descricao=descricao;
        this.endereco=endereco;
        this.preco=preco;
        this.instrumentos=instrumentos;
        this.agenda=agenda;
    }

    public int getId(){
        return this.id;
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
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static Finder<String, Evento> find = new Finder<String, Evento>(Evento.class);
}