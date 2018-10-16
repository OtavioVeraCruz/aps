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
       //DynamicForm data =form.form().bindFromRequest();
        //String cep=	data.get("inputCep");
       // String rua=data.get("inputRua");
       // String complemento=data.get("inputComplemento");
       // int num=Integer.parseInt(data.get("inputNumero"));
      //  String cidade=data.get("inputCidade");
      //  String estado=data.get("inputEstado");
      //  String pais=data.get("inputPais");

       // Endereco endereco=new Endereco(data.get("inputCep"),data.get("inputRua"),data.get("inputComplemento"),
         //       Integer.parseInt(data.get("inputNumero")),data.get("inputCidade"),data.get("inputEstado"),data.get("inputPais"));  

     //   Contratante contratante	= new Contratante(data.get("inputCnpj"),data.get("inputNome"),data.get("inputSenha"),
        //										endereco,null);

     //   fachada.cadastrarContratante(contratante);

     	Form<Contratante>formContratante=formFactory.form(Contratante.class);
     	Contratante contratante=formContratante.bindFromRequest().get();
		this.fachada.cadastrarContratante(contratante);

        return redirect(routes.HomeController.index());
    }

    public Result index(){

        return ok(views.html.index.render("Show Up!"));
    }
}