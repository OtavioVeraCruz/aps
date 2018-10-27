package models.controlador;

import models.base.Contratante;
import models.cadastro.ContratanteCadastro;
import models.repositorio.interfaces.IRepositorioContratante;

public class ContratanteControlador
{
    private ContratanteCadastro contratanteCadastro;

    public ContratanteControlador(IRepositorioContratante repositorioContratante) {
        this.contratanteCadastro = new ContratanteCadastro(repositorioContratante);
    }

    public void cadastrar(Contratante contratante)
    {
        contratanteCadastro.cadastrar((Contratante) contratante);
    }

    public Contratante ler(String cpf) {
        return contratanteCadastro.ler(cpf);
    }

    public void update(Contratante contratante) {
        contratanteCadastro.update(contratante);
    }

    public void deletar(String cpf) {
        contratanteCadastro.deletar(cpf);
    }

}
