package models.repositorio.interfaces;

import java.util.List;

import models.base.Contratante;

public interface IRepositorioContratante {

    void cadastrar(Contratante contratante);
    Contratante ler(String cpf);
    void update(Contratante contratante);
    void deletar(String cpf);
    boolean existeContratante(String cpf);
    List<Contratante>all();
}