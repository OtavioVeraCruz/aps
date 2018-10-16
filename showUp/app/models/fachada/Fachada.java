package models.fachada;

import models.base.Artista;
import models.base.Contratante;
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
        this.artistaControlador = new ArtistaControlador(new RepositorioArtistaDB());
        this.contratanteControlador = new ContratanteControlador(new RepositorioContratanteDB());
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

    public Contratante recuperarContratante(String cpf) {
        return contratanteControlador.ler(cpf);
    }

    public void updateContratante(Contratante contratante) {
        contratanteControlador.update(contratante);
    }

    public void deletarContratante(String cpf) {
        contratanteControlador.deletar(cpf);
    }
}