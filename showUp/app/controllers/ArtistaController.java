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
import java.util.ArrayList;

public class ArtistaController extends Controller{

    private FormFactory form;

    @Inject
    public ArtistaController(FormFactory formFactory) {
        this.form = formFactory;
    }

    public Result create() throws ParseException {
        DynamicForm data = form.form().bindFromRequest();
        Fachada fachada = Fachada.getInstance();
        String cpf ="";
        String nome = data.get("inputNome");
        if (data.get("inputCPF")!=null) {
            cpf=data.get("inputCPF");
        }
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

       ArrayList<String> instrumentos=new ArrayList<>();

        if (data.get("inputInstrumentos")!=null&&data.get("inputInstrumentos").contains(",")){
            String aux[]=data.get("inputInstrumentos").split(",");

             for (int i=0;i<aux.length;i++) {
                    instrumentos.add(aux[i]);
             }
        }
        else if (data.get("inputInstrumentos")!=null){
            instrumentos.add(data.get("inputInstrumentos"));
        }

        ArrayList<String> redes=new ArrayList<>();

        if (data.get("inputLink")!=null&&data.get("inputLink").contains(",")){
            String[] aux=data.get("inputLink").split(",");
            for (int i=0;i<aux.length;i++) {
                redes.add(aux[i]);
            }
            
        }
        else if (data.get("inputLink")!=null){
            redes.add(data.get("inputLink"));
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