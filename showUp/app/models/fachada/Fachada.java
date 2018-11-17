package models.fachada;

import java.util.List;

import models.abstractfactory.FabricaRepositorioDB;
import models.base.Artista;
import models.base.Contratante;
import models.controlador.ArtistaControlador;
import models.controlador.ContratanteControlador;
import models.repositorio.repositorioDB.RepositorioArtistaDB;
import models.repositorio.repositorioDB.RepositorioContratanteDB;

public class Fachada
{
    private ArtistaControlador artistaControlador;
    private ContratanteControlador contratanteControlador;

    private static Fachada instance;

    private Fachada() {

        FabricaRepositorio fabricaRepositorio = getRepositorio();
        this.artistaControlador = new ArtistaControlador(fabricaRepositorioDB.criaRepositorioArtista());
        this.contratanteControlador = new ContratanteControlador(fabricaRepositorioDB.criaRepositorioContratante());

    }

    public static Fachada getInstance()
    {
        if(instance == null)
        {
            instance = new Fachada();
        }

        return instance;
    }


    public void cadastrarArtista(Artista artista)
    {
        artistaControlador.cadastrar(artista);
    }

    public void cadastrarContratante(Contratante contratante)
    {
        contratanteControlador.cadastrar(contratante);
    }

    public Contratante recuperarContratante(String cpf) {
        return contratanteControlador.ler(cpf);
    }

    public void updateContratante(Contratante contratante) {
        contratanteControlador.update(contratante);
    }

    public void deletarContratante(String cpf) {
        contratanteControlador.deletar(cpf);
    }
    public List<Contratante> all(){
        return contratanteControlador.all();
    }

    public FabricaRepositorio getRepositorio(){
        BufferedReader br = null;
        FileReader fr = null;
        try {

            //br = new BufferedReader(new FileReader(FILENAME));
            fr = new FileReader("ConfigDB.config");
            br = new BufferedReader(fr);

            String sCurrentLine;
            String db = "";
            while ((sCurrentLine = br.readLine()) != null) {

            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return null;
    }
}