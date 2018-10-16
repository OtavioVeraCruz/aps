package models.base;

import io.ebean.Model;

//import javax.persistence.*;


//@Entity
public class User extends Model {
   // @Id
    private String cpf;
    private String name;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}