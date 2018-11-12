package controllers;

import play.mvc.*;
import play.data.*;
import javax.inject.*;
import models.base.*;
import models.fachada.Fachada;
import java.lang.*;
import java.util.*;
import views.html.*;

public class ArtistaController extends Controller{

    private FormFactory form;
    private Fachada fachada;
    private static Artista artista;
    private static ArrayList<Evento> eventos;
    @Inject
    public ArtistaController(FormFactory formFactory) {
        this.form = formFactory;
        this.fachada = Fachada.getInstance();
    }

    /*public Result create() throws ParseException {
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
        this.fachada.cadastrarArtista(artista);

        return  redirect(routes.ArtistaController.index());
    }

    public Result index(){
        return ok(views.html.index.render("Show Up!"));
        
    }*/

    public Result create(){
        Form<Artista>formArtista=form.form(Artista.class);
        if (formArtista.hasErrors()) {
            return badRequest(views.html.cadastrarArtista.render(formArtista));
        } else {
            Artista artista=formArtista.bindFromRequest().get();
            this.fachada.cadastrarArtista(artista);
            this.artista=artista;
            ArrayList<Evento> eventos=null;  
            this.eventos=eventos;  
            return ok(views.html.homeArtista.render(artista,null));
        } 
   }
   public Result verEvento(int id){
       Evento evento=null;
       if(this.eventos!=null){
        for(Evento aux : eventos)   {
           if(aux.getId()==id){
               evento=aux; 
           }
        }
        return ok(views.html.verEvento.render(evento));
       }
       else{
        return ok(views.html.verEvento.render(null));
       }
      
   }
  
}