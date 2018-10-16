package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.*;
import models.base.*;
import models.fachada.Fachada;
import play.mvc.*;
import java.lang.*;
import java.util.*;
import views.html.*;

public class HomeController extends Controller {

	private FormFactory formFactory;
 	private Contratante contratante;
 	private Fachada fachada;

 	 @Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.contratante=new Contratante();
        this.fachada=Fachada.getInstance();	
    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result registerContratante(){
    	Form<Contratante>formContratante=formFactory.form(Contratante.class);

        return ok(views.html.cadastrarContratante.render(formContratante));
    }
    public Result registerArtista(){return ok(views.html.cadastrarArtista.render());
    }

}
