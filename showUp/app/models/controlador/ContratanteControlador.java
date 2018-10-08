package models.controlador;

import models.base.Contratante;
import models.base.Usuario;
import models.cadastro.ContratanteCadastro;
import models.repositorio.interfaces.IRepositorioContratante;

public class ContratanteControlador
{
    private ContratanteCadastro contratanteCadastro;

    public ContratanteControlador(IRepositorioContratante repositorioContratante) {
        this.contratanteCadastro = new ContratanteCadastro(repositorioContratante);
    }

    public void cadastrar(Usuario contratante)
    {
        contratanteCadastro.cadastrar((Contratante) contratante);
    }

    public Usuario ler(String cpf) {
        return contratanteCadastro.ler(cpf);
    }

    public void update(Contratante contratante) {
        contratanteCadastro.update(contratante);
    }

    public void deletar(String cpf) {
        contratanteCadastro.deletar(cpf);
    }

}
