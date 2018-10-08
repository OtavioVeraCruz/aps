package models.controlador;

import models.base.Artista;
import models.cadastro.ArtistaCadastro;
import models.repositorio.interfaces.IRepositorioArtista;

public class ArtistaControlador
{
    private ArtistaCadastro artistaCadastro;

    public ArtistaControlador(IRepositorioArtista repositorioArtista) {
        this.artistaCadastro = new ArtistaCadastro(repositorioArtista);
    }

    public void cadastrar(Artista usuario)
    {
        artistaCadastro.cadastrar(usuario);
    }

}
