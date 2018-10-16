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

    public Result create() throws ParseException {
        DynamicForm data = form.form().bindFromRequest();
        Fachada fachada = Fachada.getInstance();
        String cpf = data.get("inputCPF"), nome = data.get("inputNome");
        String senha = data.get("inputSenha"), genero = data.get("inputGenero");
        double preco=0;
        if (data.get("inputPreco") != null) {
            preco = Double.parseDouble(data.get("inputPreco"));
        }

        int numero = 0;
        if (data.get("inputNumero") != null) {
            numero = Integer.parseInt(data.get("inputNumero"));
        }

        Endereco endereco = new Endereco(data.get("inputCep"), data.get("inputRua"), data.get("inputComplemento"), numero
                , data.get("inputCidade"), data.get("inputEstado"), data.get("inputPais"));

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);

        Date date = null;
        if (data.get("inputData")!=null){
            date = formatter.parse(data.get("inputData"));
        }

        String[]instrumentos=null;

        if (data.get("inputInstrumentos")!=null&&data.get("inputInstrumentos").contains(",")){

            instrumentos=data.get("inputInstrumentos").split(",");
        }
        else if (data.get("inputInstrumentos")!=null){
            instrumentos=new String[1];
            instrumentos[0]=data.get("inputInstrumentos");
        }

        String [] redes=null;

        if (data.get("inputLink")!=null&&data.get("inputLink").contains(",")){
            redes=data.get("inputLink").split(",");
        }
        else if (data.get("inputLink")!=null){
            redes=new String[1];
            redes[0]=data.get("inputLink");
        }

        Artista artista=new Artista(cpf,nome,senha,endereco,null,date,genero,instrumentos,
        preco,redes,null);
        fachada.cadastrarArtista(artista);

        return  redirect(routes.ArtistaController.index());
    }

    public Result index(){
        return ok(views.html.index.render("Show Up!"));
    }


}