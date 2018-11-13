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
 	private Fachada fachada;

 	@Inject
    public HomeController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada=Fachada.getInstance();	
    }

    public Result index() {
        return ok(index.render("ShowUp!"));
    }

    public Result registerContratante(){
    	Form<Contratante>formContratante=formFactory.form(Contratante.class);
        return ok(views.html.cadastrarContratante.render(formContratante,null));
    }
    public Result registerArtista(){
        Form<Artista>formArtista=formFactory.form(Artista.class);
        return ok(views.html.cadastrarArtista.render(formArtista));
    }
    public Result logout() {
        return ok(index.render("ShowUp!"));
    }

    public Result all(){
        List<Contratante> all=this.fachada.all();
        return ok(views.html.all.render(all));
    }

}
