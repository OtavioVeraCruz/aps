package models.repositorio.repositorioDB;

import io.ebean.Finder;
import models.base.Artista;
import models.repositorio.interfaces.IRepositorioArtista;


public class RepositorioArtistaDB implements IRepositorioArtista {

    private Finder<String, Artista> artistaFinder;

    public RepositorioArtistaDB() {
        this.artistaFinder = new Finder<>(Artista.class);
    }

    @Override
    public void cadastrar(Artista artista)
    {
        artista.save();
    }

    @Override
    public boolean existeArtista(String cpf)
    {
        return artistaFinder.byId(cpf) != null;
    }
}