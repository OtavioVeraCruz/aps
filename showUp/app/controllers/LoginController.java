package controllers;

import models.base.Usuario;
import models.fachada.Fachada;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;

public class LoginController extends Controller {

    /*@Inject
    private final Form<Usuario> form;*/

    private static Fachada fachada = Fachada.getInstance();


    /*public LoginController(FormFactory formFactory){
        this.form=formFactory.form(Usuario.class);
    }*/

    /*public Result login(){
        return ok(views.html.home.render());
    }*/

   /* public Result cadastrarArtista(){
        return ok(views.html.cadastrarArtista.render());
    }

    public Result cadastrarContratante(){
        return ok(views.html.cadastrarContratante.render());
    }*/


}
