package models.base;

import io.ebean.Model;
import javax.persistence.*;

@Entity
public class Endereco extends Model
{
    @Id
    private int id;
    private String cep;
    private String rua;
    private String complemento;
    private int numero;
    private String cidade;
    private String estado;
    private String pais;

    public Endereco() {
    }

    public Endereco( String cep,String rua, String complemento,int numero,String cidade,String estado,String pais) {
        this.cep=cep;
        this.rua=rua;
        this.complemento=complemento;
        this.numero=numero;
        this.cidade=cidade;
        this.estado=estado;
        this.pais=pais;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    
}