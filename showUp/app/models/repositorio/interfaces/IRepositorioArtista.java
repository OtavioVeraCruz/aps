package models.repositorio.interfaces;

import models.base.Artista;

public interface IRepositorioArtista {

    public void cadastrar(Artista artista);
    public boolean existeArtista(String cpf);
}