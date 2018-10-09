package models.fachada;

import models.abstractfactory.FabricaRepositorioDB;
import models.base.Artista;
import models.base.Contratante;
import models.base.Usuario;
import models.controlador.ArtistaControlador;
import models.controlador.ContratanteControlador;
import models.repositorio.repositorioDB.RepositorioArtistaDB;
import models.repositorio.repositorioDB.RepositorioContratanteDB;

public class Fachada
{
    private ArtistaControlador artistaControlador;
    private ContratanteControlador contratanteControlador;

    private static Fachada instance;

    private Fachada() {

        FabricaRepositorioDB fabricaRepositorioDB=new FabricaRepositorioDB();
        this.artistaControlador = new ArtistaControlador(fabricaRepositorioDB.criaRepositorioArtista());
        this.contratanteControlador = new ContratanteControlador(fabricaRepositorioDB.criaRepositorioContratante());

    }

    public static Fachada getInstance()
    {
        if(instance == null)
        {
            instance = new Fachada();
        }

        return instance;
    }


    public void cadastrarArtista(Artista artista)
    {
        artistaControlador.cadastrar(artista);
    }

    public void cadastrarContratante(Contratante contratante)
    {
        contratanteControlador.cadastrar(contratante);
    }

    public Usuario recuperarContratante(String cpf) {
        return contratanteControlador.ler(cpf);
    }

    public void updateContratante(Contratante contratante) {
        contratanteControlador.update(contratante);
    }

    public void deletarContratante(String cpf) {
        contratanteControlador.deletar(cpf);
    }
}