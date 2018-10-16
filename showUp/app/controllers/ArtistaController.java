package controllers;

import com.google.inject.Inject;
import models.base.Artista;
import models.base.Endereco;
import models.fachada.Fachada;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ArtistaController extends Controller{

    private FormFactory form;

    @Inject
    public ArtistaController(FormFactory formFactory) {
        this.form = formFactory;
    }

    public Result create(){
        DynamicForm data =form.form().bindFromRequest();
        Fachada fachada=Fachada.getInstance();

        Endereco endereco=new Endereco(data.get("inputCep"),data.get("inputRua"),data.get("inputComplemento"),
                Integer.parseInt(data.get("inputNumero")),data.get("inputCidade"),data.get("inputEstado"),data.get("inputPais"));
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
         
       // Date date = formatter.parse(data.get("inputData"));
Date date = new Date(data.get("inputData"));
        Artista artista=new Artista(data.get("inputCPF"),data.get("inputNome"),data.get("inputSenha"),endereco,null,
               date,data.get("inputGenero"),data.get("input").split(","),
                Double.parseDouble(data.get("inputPreco")),data.get("inputLink").split(","),null);
        fachada.cadastrarArtista(artista);


        return redirect(routes.HomeController.index());
    }

    public Result index(){
        return ok(views.html.index.render("Show Up!"));
    }
}