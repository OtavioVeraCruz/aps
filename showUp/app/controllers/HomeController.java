package controllers;

import play.mvc.Controller;
import play.mvc.Result;
import views.html.index;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result registerContratante(){
        return ok(views.html.cadastrarContratante.render());
    }
    public Result registerArtista(){return ok(views.html.cadastrarArtista.render());
    }

}
