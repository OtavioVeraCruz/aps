package project.models.base;

import io.ebean.Model;

import javax.persistence.*;

@Entity
public class User extends Model {
    @Id
    private String cpf;
    private String name;

}