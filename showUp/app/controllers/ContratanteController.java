package controllers;

import com.google.inject.Inject;
import models.base.Contratante;
import models.base.Endereco;
import models.fachada.Fachada;
import play.data.DynamicForm;
import play.data.FormFactory;
import play.mvc.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class ContratanteController extends Controller{

    private FormFactory form;

    @Inject
    public ContratanteController(FormFactory formFactory) {
        this.form = formFactory;
    }

    public Result create() throws ParseException {
        DynamicForm data = form.form().bindFromRequest();
        Fachada fachada = Fachada.getInstance();
        String cpf = data.get("inputCPF"), nome = data.get("inputNome");
        String senha = data.get("inputSenha"), genero = data.get("inputGenero");

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

        Contratante contratante=new Contratante(cpf,nome,senha,endereco,null,date);
        fachada.cadastrarContratante(contratante);

        return redirect(routes.ContratanteController.index());
        }

    public Result index(){
        return ok(views.html.index.render("Contratante cadastrado!"));
    }
}