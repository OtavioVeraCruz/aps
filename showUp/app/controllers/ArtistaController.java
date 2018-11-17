package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.*;
import models.base.*;
import models.fachada.Fachada;
import java.lang.*;
import java.util.*;
import views.html.*;
import java.text.*;
import java.io.*;

public class ArtistaController extends Controller{

    private FormFactory form;
    private Fachada fachada;
    private static Artista artista;
    private static List<Evento> eventos=new ArrayList<>();
    @Inject
    public ArtistaController(FormFactory formFactory) {
        this.form = formFactory;
        this.fachada = Fachada.getInstance();
        eventos=Evento.find.all();
    }

    public Result index(){
        eventos=Evento.find.all();

        return ok(views.html.homeArtista.render(this.artista,eventos));
    }

    public Result create() throws ParseException{
        Form<Artista>formArtista=form.form(Artista.class);
        DynamicForm data = form.form().bindFromRequest();
        
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


        Endereco endereco = new Endereco(data.get("inputCep"), data.get("inputRua"), data.get("inputComplemento"),
        numero, data.get("inputCidade"), data.get("inputEstado"), data.get("inputPais"));
        endereco.save();
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
        String email="";
        if(data.get("inputEmail")!=null){
            email=data.get("inputEmail");
        }

        File foto=null;
        if(data.get("inputFoto")!=null){
            foto=new File(data.get("inputFoto"));
        }    
        Artista artista=new Artista(cpf,nome,email,senha,endereco,date,genero,instrumentos,
        preco,redes,foto);
        this.artista=artista;

        if (formArtista.hasErrors()) {
            return badRequest(views.html.cadastrarArtista.render(formArtista));
        } else {
            
            this.fachada.cadastrarArtista(artista);
            this.artista=artista;
            return ok(views.html.homeArtista.render(artista,eventos));
        } 
   }
   public Result verEvento(int id){
       Evento evento=Evento.find.byId(id);
       return ok(views.html.verEvento.render(evento));       
   }
  
}