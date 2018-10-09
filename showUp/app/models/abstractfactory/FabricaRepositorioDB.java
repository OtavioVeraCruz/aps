package models.abstractfactory;

import models.repositorio.repositorioDB.RepositorioArtistaDB;
import models.repositorio.repositorioDB.RepositorioContratanteDB;

public class FabricaRepositorioDB implements RepositorioAbstractFactory {

    @Override
    public RepositorioArtistaDB criaRepositorioArtista() {
        return new RepositorioArtistaDB();
    }

    @Override
    public RepositorioContratanteDB criaRepositorioContratante() {
        return new RepositorioContratanteDB();
    }
}
