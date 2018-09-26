package project.models.base;

import io.ebean.Model;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.Required;

import javax.persistence.*;

@Entity
public class User extends Model {
    @Id
    private String cpf;
    @Required
    private String name;

}