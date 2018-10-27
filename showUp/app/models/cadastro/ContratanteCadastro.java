package models.cadastro;

import models.base.Contratante;
import models.repositorio.interfaces.IRepositorioContratante;

public class ContratanteCadastro
{
    private IRepositorioContratante repositorioContratante;

    public ContratanteCadastro(IRepositorioContratante repositorioContratanteDB) {
        this.repositorioContratante = repositorioContratanteDB;
    }

    public void cadastrar(Contratante contratante)
    {
        if (repositorioContratante.existeContratante(contratante.getCpf()))
            repositorioContratante.cadastrar(contratante);
    }

    public Contratante ler(String cpf)
    {
        return repositorioContratante.ler(cpf);
    }

    public void update(Contratante contratante)
    {
        repositorioContratante.update(contratante);
    }

    public void deletar(String cpf)
    {
        repositorioContratante.deletar(cpf);
    }

}