package models.repositorio.repositorioDB;

import io.ebean.Finder;
import models.base.Contratante;
import models.repositorio.interfaces.IRepositorioContratante;


public class RepositorioContratanteDB implements IRepositorioContratante {


    private Finder<String, Contratante> contratanteFinder;

    public RepositorioContratanteDB() {
        this.contratanteFinder = new Finder<>(Contratante.class);
    }

    @Override
    public void cadastrar(Contratante contratante)
    {
        contratante.save();
    }

    @Override
    public Contratante ler(String cpf) {
        return contratanteFinder.byId(cpf);
    }

    @Override
    public void update(Contratante contratante) {
        Contratante aux = contratanteFinder.ref(contratante.getCpf());
        aux.setNome(contratante.getNome());
        aux.update();
    }

    @Override
    public void deletar(String cpf) {
        contratanteFinder.ref(cpf).delete();
    }

    @Override
    public boolean existeContratante(String cpf)
    {
        return contratanteFinder.byId(cpf) != null;
    }
}