package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.*;
import models.base.*;
import models.fachada.Fachada;
import java.lang.*;
import java.util.*;
import views.html.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

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
        return redirect(controllers.routes.ContratanteController.login(contratante.getNome()));
    }
    public Result login(String nome){
        return ok(views.html.home.render(nome));
    }
}