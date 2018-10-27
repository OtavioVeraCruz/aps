package models.base;

import javax.persistence.Entity;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;

@Entity
public class Artista extends Usuario {

    private String generoMusical;
    private ArrayList<String> instrumentos;
    private double precoShow;
    private ArrayList<String> linkRedesSocial;
    private File photo;
    
    
    public Artista() { }

    public Artista(String cpf, String nome, String senha, Endereco endereco, ArrayList<Evento> eventos, Date date, String generoMusical,
                   ArrayList<String> instrumentos, double precoShow, ArrayList<String> linkRedesSocial, File photo) {
        super(cpf, nome, senha, endereco, eventos, date);
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
}