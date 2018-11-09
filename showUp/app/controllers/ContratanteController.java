package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.*;
import models.base.*;
import models.fachada.Fachada;
import java.lang.*;
import java.util.*;
import views.html.*;

public class ContratanteController extends Controller{
 
 	private FormFactory formFactory;
 	private Contratante contratante;
 	private Fachada fachada;

    @Inject
    public ContratanteController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.contratante=new Contratante();
        this.fachada=Fachada.getInstance();	
    }

    public Result create(){
     	Form<Contratante>formContratante=formFactory.form(Contratante.class);
     	Contratante contratante=formContratante.bindFromRequest().get();
        this.fachada.cadastrarContratante(contratante);
        List<Usuario> usuarios=new ArrayList<>();
        usuarios.add(new Artista("12345677774","Banda Cin","bandacin@email.com","52312315",null,null,null,"Rock",null,300,null,null));
        usuarios.add(new Artista("12345677775","Chico Science","chico@email.com","52312315",null,null,null,"Pop",null,400,null,null));
        return ok(views.html.home.render(contratante,usuarios));
    }
    /*public Result login(Usuario usuario,List<Usuario>usuarios){
        return ok(views.html.home.render(usuario,usuarios));
    }*/
}