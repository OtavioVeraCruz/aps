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
 	private static Contratante contratante;
 	private Fachada fachada;

    @Inject
    public ContratanteController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada=Fachada.getInstance();	
    }

    public Result create(){
        Form<Contratante>formContratante=formFactory.form(Contratante.class);
        if(!formContratante.hasErrors())  {
            Contratante contratante=formContratante.bindFromRequest().get();
            this.fachada.cadastrarContratante(contratante);
            this.contratante=contratante;
            if(this.fachada.recuperarContratante(contratante.getCpf())!=null){
                return badRequest(views.html.cadastrarContratante.render(formContratante,"Usuário já foi cadastrado!"));
            }
            else{
                List<Artista> artistas=new ArrayList<>();
                artistas.add(new Artista("12345677774","Banda Cin","bandacin@email.com","52312315",null,null,"Rock",null,300,null,null));
                artistas.add(new Artista("12345677775","Chico Science","chico@email.com","52312315",null,null,"Pop",null,400,null,null));
                return ok(views.html.homeContratante.render(contratante,artistas));
            }
         }else{
            return badRequest(views.html.cadastrarContratante.render(formContratante,null));
         }
      
    }

    public Result criarEvento(){
        Form<Evento>formEvento=formFactory.form(Evento.class);
        return ok(views.html.criarEvento.render(this.contratante,formEvento));
    }

    public Result meusEventos(){
        ArrayList<Evento>eventos=null;

        return ok(views.html.meusEventos.render(eventos));
    }
}