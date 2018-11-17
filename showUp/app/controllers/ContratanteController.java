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

public class ContratanteController extends Controller{
 
 	private FormFactory formFactory;
 	private static Contratante contratante;
    private Fachada fachada;
    private List<Evento> eventos=new ArrayList<>();  
    private List<Artista> artistas=new ArrayList<>();
    @Inject
    public ContratanteController(FormFactory formFactory) {
        this.formFactory = formFactory;
        this.fachada=Fachada.getInstance();	
        this.artistas=Artista.find.all();
    }

    public Result index(){
        artistas=Artista.find.all();
        return ok(views.html.homeContratante.render(contratante,artistas));
    }
    public Result create() throws ParseException{
        Form<Contratante>formContratante=formFactory.form(Contratante.class);
        DynamicForm data = formFactory.form().bindFromRequest();
        
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
     
        String email="";
        if(data.get("inputEmail")!=null){
            email=data.get("inputEmail");
        }

    
        if(!formContratante.hasErrors())  {
            Contratante contratante=new Contratante(cpf,nome,email,senha,endereco,null,date);
            this.fachada.cadastrarContratante(contratante);
            this.contratante=contratante;
            if(this.fachada.recuperarContratante(contratante.getCpf())!=null){
                return badRequest(views.html.cadastrarContratante.render(formContratante,"Usuário já foi cadastrado!"));
            }
            else{
                
               // this.artistas.add(new Artista("12345677774","Banda Cin","bandacin@email.com","52312315",null,null,"Rock",null,300,null,null));
                //this.artistas.add(new Artista("12345677775","Chico Science","chico@email.com","52312315",null,null,"Pop",null,400,null,null));
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
    public Result saveEvento()throws ParseException{
        Form<Evento>formEvento=formFactory.form(Evento.class);
        DynamicForm data = formFactory.form().bindFromRequest();
        
        
        String nome = data.get("inputNome");
        String desc =data.get("inputDesc");
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

        Date date = null;
        if (data.get("inputData")!=null){
            date = formatter.parse(data.get("inputData"));
        }
        
        String horaInicial=data.get("inputHoraInicial");
        String horaFinal=data.get("inputHoraFinal");
        Agenda a=new Agenda(date,horaInicial,horaFinal);
        a.save();
        if(nome!=null&&desc!=null&&endereco!=null&&instrumentos!=null&&a!=null){
        Evento e=new Evento(nome,desc,endereco,preco,instrumentos,a);
        e.save();
        this.eventos=Evento.find.query().select("*").where().eq("contratante_cpf",contratante.getCpf()).findList();
        
        return ok(views.html.meusEventos.render(this.eventos));
        }
        else{
            return ok("Erro!");
        }
    }

    public Result meusEventos(){
        this.eventos=Evento.find.query().select("*").where().eq("contratante_cpf",contratante.getCpf()).findList();

        return ok(views.html.meusEventos.render(this.eventos));
    }
}