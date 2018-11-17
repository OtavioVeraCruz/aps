package models.base;

import javax.persistence.*;
import java.io.File;
import java.util.*;
import io.ebean.*;

@Entity
public class Artista extends Usuario {

    private String generoMusical;
    private ArrayList<String> instrumentos;
    private double precoShow;
    private ArrayList<String> linkRedesSocial;
    private File photo;
    @ManyToMany
    private List<Evento>eventos;
    @OneToOne
    private Endereco endereco;

    public Artista() { }

    public Artista(String cpf, String nome,String email, String senha, Endereco endereco, Date date,
     String generoMusical,ArrayList<String> instrumentos, double precoShow, 
     ArrayList<String> linkRedesSocial, File photo) {
        super(cpf, nome,email, senha/*, endereco, eventos*/, date);
        this.generoMusical = generoMusical;
        this.instrumentos = instrumentos;
        this.precoShow = precoShow;
        this.linkRedesSocial = linkRedesSocial;
        this.photo = photo;                 
    }

    public String getGeneroMusical() {
        return generoMusical;
    }

    public void setGeneroMusical(String generoMusical) {
        this.generoMusical = generoMusical;
    }

    public ArrayList<String> getInstrumentos() {
        return instrumentos;
    }

    public void setInstrumentos(ArrayList<String> instrumentos) {
        this.instrumentos = instrumentos;
    }

    public double getPrecoShow() {
        return precoShow;
    }

    public void setPrecoShow(double precoShow) {
        this.precoShow = precoShow;
    }

    public ArrayList<String> getLinkRedesSocial() {
        return linkRedesSocial;
    }

    public void setLinkRedesSocial(ArrayList<String>linkRedesSocial) {
        this.linkRedesSocial = linkRedesSocial;
    }

    public File getPhoto() {
        return photo;
    }

    public void setPhoto(File photo) {
        this.photo = photo;
    }
    public static final Finder<String, Artista> find = new Finder<String, Artista>(Artista.class);
}