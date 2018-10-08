package models.cadastro;

import models.base.Artista;
import models.repositorio.interfaces.IRepositorioArtista;

public class ArtistaCadastro
{
    private IRepositorioArtista repositorioArtista;

    public ArtistaCadastro(IRepositorioArtista repositorioArtista) {
        this.repositorioArtista = repositorioArtista;
    }

    public void cadastrar(Artista artista)
    {
        if (repositorioArtista.existeArtista(artista.getCpf()))
            repositorioArtista.cadastrar(artista);
    }

}