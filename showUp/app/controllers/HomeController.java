package controllers;

import play.mvc.*;

import views.html.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.*;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.List;

import static play.libs.Scala.asScala;
import models.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {
    private final Form<User> form;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
    @Inject
    public HomeController(FormFactory formFactory){
        this.form=formFactory.form(User.class);

    }

    public Result index() {
        return ok(index.render("Your new application is ready."));
    }

    public Result login(){
        final Form<User> boundForm = form.bindFromRequest();
        String name;
        return redirect(routes.UserController.index());
    }
    public Result registerContratante(){
        return ok(views.html.cadastrarContratante.render());
    }
    public Result registerArtista(){
        return ok(views.html.cadastrarArtista.render());
    }

}
