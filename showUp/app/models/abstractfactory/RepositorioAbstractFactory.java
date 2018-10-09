package models.abstractfactory;

import models.repositorio.repositorioDB.RepositorioArtistaDB;
import models.repositorio.repositorioDB.RepositorioContratanteDB;

public interface RepositorioAbstractFactory {

    public RepositorioArtistaDB criaRepositorioArtista();
    public RepositorioContratanteDB criaRepositorioContratante();
}
